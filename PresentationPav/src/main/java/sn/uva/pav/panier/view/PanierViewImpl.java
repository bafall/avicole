package sn.uva.pav.panier.view;

import java.util.List;
import org.apache.shiro.authz.annotation.RequiresRoles;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;
import ru.xpoft.vaadin.VaadinView;
import sn.organisation.pav.entite.Article;
import sn.uva.pav.commun.OngletPav;
import sn.uva.pav.commun.PivHautPav;
import sn.uva.pav.mvp.BaseViewListener;
import com.vaadin.navigator.ViewChangeListener.ViewChangeEvent;
import com.vaadin.shared.ui.label.ContentMode;
import com.vaadin.ui.Alignment;
import com.vaadin.ui.Button;
import com.vaadin.ui.Button.ClickEvent;
import com.vaadin.ui.Button.ClickListener;
import com.vaadin.ui.HorizontalLayout;
import com.vaadin.ui.Label;
import com.vaadin.ui.VerticalLayout;

@Component
@Scope("prototype")
@RequiresRoles("administrateur")
@VaadinView(PanierViewImpl.NAME)
public class PanierViewImpl extends VerticalLayout implements PanierView, ClickListener {
	
	private PanierViewListener listener;
	public static final String NAME = "panier";
	private static final String ACTUALISER_PANIER = "Actualiser panier";
	private static final String COMMANDER = "Commander";
	
	private VerticalLayout cadrePrincipal = new VerticalLayout();
	private Button bActualiserPanier = new Button(ACTUALISER_PANIER);
	private Button bCommander = new Button(COMMANDER);
	private PivHautPav pivH; 

	
	@Override
	public void enter(ViewChangeEvent event) {
		
		this.paintPivHaut();
        
        VerticalLayout contenu = new VerticalLayout();
        HorizontalLayout cadreBoutons = new HorizontalLayout();
        bActualiserPanier.addClickListener(this);
        bCommander.addClickListener(this); 
        cadreBoutons.addComponent(bActualiserPanier);
        cadreBoutons.addComponent(bCommander);
        cadreBoutons.setMargin(true);
        cadreBoutons.setSpacing(true);
        contenu.addComponent(new Label("<h3>Mon panier a venir</h3>",ContentMode.HTML));
        contenu.addComponent(cadreBoutons); 
        contenu.setSizeFull();
        contenu.setComponentAlignment(cadreBoutons, Alignment.BOTTOM_RIGHT);
        cadrePrincipal.addComponent(new OngletPav(contenu, new String[]{"Mon panier"}));
        
        this.addComponent(cadrePrincipal);
        this.setComponentAlignment(cadrePrincipal, Alignment.BOTTOM_CENTER);

	}

	/**
	 * Mets à jour la liste de permis à afficher dans le display du catalogue
	 */
	@Override
	public void setDisplayListeArticles(List<Article> listeArticles) {
		
	}
	


	@Override
	public void buttonClick(ClickEvent event) {
		listener.buttonClick(event.getButton()
                .getCaption());
	}

	@Override
	public void addListener(BaseViewListener listener) {
		this.listener = (PanierViewListener)listener;	
	}
	

	public void paintPivHaut(){
		pivH = new PivHautPav(cadrePrincipal, null);
	}

}
