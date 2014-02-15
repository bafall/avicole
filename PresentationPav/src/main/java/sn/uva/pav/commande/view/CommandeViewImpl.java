package sn.uva.pav.commande.view;

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
import com.vaadin.server.ThemeResource;
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
@RequiresRoles("client")
@VaadinView(CommandeViewImpl.NAME)
public class CommandeViewImpl extends VerticalLayout implements CommandeView, ClickListener {
	
	private CommandeViewListener listener;
	public static final String NAME = "/client/commande";
	//private static final String CADRE_WIDTH = "700px";
	private static final String RESERVER_HR = "Actualiser panier";
	private static final String ANNULER = "Annuler";
	private static final String SOUMETTRE_CMD = "Commander";
	private static final ThemeResource ICON_RECHERCHE = new ThemeResource("images/btnSearch.png");
	
	private VerticalLayout cadrePrincipal = new VerticalLayout();
	Button bReserverHoraire = new Button(RESERVER_HR);
	Button bAnnuler = new Button(ANNULER);
	Button bSoumettreCmd = new Button(SOUMETTRE_CMD);
	
	private PivHautPav pivH;

	
	@Override
	public void enter(ViewChangeEvent event) {
		this.paintPivHaut();
        
		VerticalLayout contenuReservation = new VerticalLayout();
		VerticalLayout contenuDetail = new VerticalLayout();
		VerticalLayout contenuSuivi = new VerticalLayout();
        VerticalLayout contenuHistorique = new VerticalLayout();
        HorizontalLayout cadreBoutons = new HorizontalLayout();
        bReserverHoraire.addClickListener(this);
        bAnnuler.addClickListener(this); 
        cadreBoutons.addComponent(bReserverHoraire);
        cadreBoutons.addComponent(bAnnuler);
        cadreBoutons.setMargin(true);
        cadreBoutons.setSpacing(true);
        contenuHistorique.addComponent(new Label("<h3>Mon panier a venir</h3>",ContentMode.HTML));
        contenuHistorique.addComponent(cadreBoutons); 
        contenuHistorique.setSizeFull();
        contenuHistorique.setComponentAlignment(cadreBoutons, Alignment.BOTTOM_RIGHT);
        cadrePrincipal.addComponent(new OngletPav(new VerticalLayout [] 
        		{contenuReservation, contenuSuivi,contenuHistorique, contenuDetail}, new String[]{"Réservation - Plage horaire", 
        		"Suivi  de commande", "Détail de la commande", "Historique commande"}));
        
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
		this.listener = (CommandeViewListener)listener;	
	}
	
	public void paintPivHaut(){
		pivH = new PivHautPav(cadrePrincipal, null);
	}

}
