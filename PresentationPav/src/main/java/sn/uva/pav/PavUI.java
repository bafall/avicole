package sn.uva.pav;


import java.util.List;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Configurable;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;
import sn.organisation.pav.entite.Article;
import sn.organisation.pav.entite.Employe;
import sn.organisation.pav.service.ServiceCommande;
import sn.uva.pav.catalogue.presenter.CataloguePresenter;
import sn.uva.pav.catalogue.view.CatalogueViewImpl;
import sn.uva.pav.commande.presenter.CommandePresenter;
import sn.uva.pav.commande.view.CommandeViewImpl;
import sn.uva.pav.commun.ConnexionPav;
import sn.uva.pav.compte.presenter.ComptePresenter;
import sn.uva.pav.compte.view.CompteViewImpl;
import sn.uva.pav.erreur.presenter.ErreurPresenter;
import sn.uva.pav.erreur.view.ErreurViewImpl;
import sn.uva.pav.mvp.MVPDiscoveryNavigator;
import sn.uva.pav.panier.presenter.PanierPresenter;
import sn.uva.pav.panier.view.PanierViewImpl;
import com.vaadin.annotations.Theme;
import com.vaadin.annotations.Title;
import com.vaadin.server.VaadinRequest;
import com.vaadin.ui.UI;


@Configurable(preConstruction = true)
@Transactional
@Theme("pavtheme")
@SuppressWarnings("serial")
@Component
@Scope("prototype")
@Title("Commande Online ::. Pav")
public class PavUI extends UI
{

    /*@WebServlet(value = "/*", asyncSupported = true)
    @VaadinServletConfiguration(productionMode = false, ui = PavUI.class, widgetset = "sn.uva.pav.AppWidgetSet")
    public static class Servlet extends VaadinServlet {
    }*/
	
	@Autowired
	ServiceCommande serviceCommande;
	
	private Employe employe;

    public Employe getEmploye() {
    	if(employe == null){
    		return new Employe();
    	}
		return employe;
	}

	public void setEmploye(Employe employe) {
		this.employe = employe;
	}

	@Override
    protected void init(VaadinRequest request) {
		MVPDiscoveryNavigator navigator = new MVPDiscoveryNavigator(this, this);
		
		//Set me to UI so that I can be used even from other views.
		this.setNavigator(navigator);
		
		//ConnexionPav.connecter("bafal", "entrer");
		this.recupererInfosCompteConnecte();
		
		
		/*if(currentSubject.hasRole("utilisateur")){
			Notification.show("role valide");
		}*/
		
		// Ajout des vues et présenteurs au gestionnaire de navigateur personnalisé MVPDiscoveryNavigator
		navigator.addBeanViewPresenter(CatalogueViewImpl.NAME, CatalogueViewImpl.class, CataloguePresenter.class, false);
		navigator.addBeanViewPresenter(PanierViewImpl.NAME, PanierViewImpl.class, PanierPresenter.class, false);
		navigator.addBeanViewPresenter(ErreurViewImpl.NAME, ErreurViewImpl.class, ErreurPresenter.class, false);
		navigator.addBeanViewPresenter(CompteViewImpl.NAME, CompteViewImpl.class, ComptePresenter.class, false);
		navigator.addBeanViewPresenter(CommandeViewImpl.NAME, CommandeViewImpl.class, CommandePresenter.class, false);
		navigator.navigateTo(CatalogueViewImpl.NAME);
    }
	
	private void recupererInfosCompteConnecte(){
		Subject currentSubject = SecurityUtils.getSubject();
		
		if(currentSubject.isAuthenticated()){
			Object objetLogin = currentSubject.getPrincipal();
			Employe employeCourant = serviceCommande.obtenirEmployeParId(objetLogin.toString());
			this.setEmploye(employeCourant);
		}
	}
	
	public List<Article> getCatalogue(){
		return serviceCommande.getListeArticles();
	}

}
