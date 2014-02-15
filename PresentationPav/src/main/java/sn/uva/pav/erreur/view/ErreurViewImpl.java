package sn.uva.pav.erreur.view;

import java.util.List;

import org.apache.shiro.authz.annotation.RequiresRoles;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import ru.xpoft.vaadin.VaadinView;
import sn.organisation.pav.entite.Article;
import sn.uva.pav.PavUI;
import sn.uva.pav.commun.PivHautPav;
import sn.uva.pav.mvp.BaseViewListener;
import sn.uva.pav.panier.view.PanierViewImpl;

import com.vaadin.navigator.ViewChangeListener.ViewChangeEvent;
import com.vaadin.server.ExternalResource;
import com.vaadin.ui.Button;
import com.vaadin.ui.Button.ClickListener;
import com.vaadin.ui.Label;
import com.vaadin.ui.Link;
import com.vaadin.ui.UI;
import com.vaadin.ui.VerticalLayout;
import com.vaadin.ui.Button.ClickEvent;

@Component
@Scope("prototype")
@VaadinView(ErreurViewImpl.NAME)
public class ErreurViewImpl extends VerticalLayout implements ErreurView {
	
	public static final String NAME = "erreur";
	private PivHautPav pivH;

	@Override
	public void addListener(BaseViewListener listener) {
		// TODO Auto-generated method stub

	}

	@Override
	public void enter(ViewChangeEvent event) {
		paintPivHaut();
		addComponent(new Label("Impossible de connecter "));
        addComponent(new Link("login", new ExternalResource("/PresentationPav/login/")));
        this.setSpacing(true);

	}

	/**
	 * Mets à jour la liste de permis à afficher dans le display du catalogue
	 */
	@Override
	public void setDisplayListeArticles(List<Article> listeArticles) {
		
	}
	
	public void paintPivHaut(){
		//pivH = new PivHautPav(cadrePrincipal, ((PavUI) this.getUI()).getEmploye().getPrenom());
	}

}
