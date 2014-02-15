package sn.uva.pav.catalogue.presenter;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.util.JRLoader;

import org.apache.shiro.authc.IncorrectCredentialsException;
import org.apache.shiro.authc.UnknownAccountException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Configurable;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import com.vaadin.server.StreamResource;
import com.vaadin.ui.Notification;
import com.vaadin.ui.UI;

import sn.organisation.pav.entite.Article;
import sn.organisation.pav.entite.Employe;
import sn.organisation.pav.service.ServiceCommande;
import sn.organisation.pav.service.ServiceRapportCommande;
import sn.uva.pav.catalogue.view.CatalogueView;
import sn.uva.pav.commun.ConnexionPav;
import sn.uva.pav.compte.view.CompteView;
import sn.uva.pav.compte.view.CompteViewImpl;
import sn.uva.pav.mvp.BasePresenter;

@Configurable(preConstruction = true)
@Transactional
@Component
@Scope("prototype")
public class CataloguePresenter extends BasePresenter implements CatalogueView.CatalogueViewListener {

	@Autowired
	ServiceRapportCommande serviceRapportCommande;
	@Autowired
	ServiceCommande serviceCommande;
	
	@SuppressWarnings("deprecation")
	@Override
	public void buttonClick(String identifiantBouton) {
		if("commande".equals(identifiantBouton)){
			byte [] rapport = null;
			rapport = imprimerRapport();
			final byte [] rapportNew = rapport;
	  		StreamResource.StreamSource pdfSource = new StreamResource.StreamSource() {

	            public InputStream getStream() {
	            	
	               InputStream inStream =  new ByteArrayInputStream(rapportNew) ;
	               return inStream;
	            }
	         };
	        StreamResource pdfRessource = new StreamResource ( pdfSource,"formulaires.pdf");
	        pdfRessource.setMIMEType ( "application/x-nknown" );
	        pdfRessource.setCacheTime(0);
	        UI.getCurrent().getPage().open(pdfRessource, "_blank", false);
			Notification.show("taille rapport :"+rapport.length);
		}
		
		if("enreg".equals(identifiantBouton)){
			
			List<Article> liste = serviceCommande.getListeArticles();
			liste.get(4).setArtPhoto(((CatalogueView)view).getVignettes());
			liste.get(6).setArtPhoto(((CatalogueView)view).getVignettes());
			serviceCommande.modifierArticle(liste.get(4));
			serviceCommande.modifierArticle(liste.get(6));
			
		}
		if("Inscription".equals(identifiantBouton)){
			UI.getCurrent().getNavigator().navigateTo(CompteViewImpl.NAME);
		}
		if("Connexion".equals(identifiantBouton)){
			Employe employe = ((CatalogueView) view).enregistrer();
			boolean authc = false;
			try {
				authc = ConnexionPav.connecter(employe.getCodeEmploye(),
						employe.getMotPasse());
			} catch (Exception e) {
				if(e.getCause() instanceof UnknownAccountException || 
						e.getCause() instanceof IncorrectCredentialsException){
					((CatalogueView) view).afficherMessageErreur("");
				} else{
					((CatalogueView) view).afficherMessageErreur("");
				}
			}
			if(authc){
				((CatalogueView) view).setCadreLogin(true);
			}
		}
	}
	
    public byte[] imprimerRapport(){
    	byte[] rapport = null;
    	JasperReport jasperreport = null;
    	Map<String, Object> parametres = new HashMap<String, Object>();
    	try {
			jasperreport = (JasperReport) JRLoader.loadObjectFromFile("/Users/bafal/Documents/Dev/pavsn/PresentationPav/src/main/jasperreports/pavEmploye.jasper");
			if(jasperreport!=null){
				parametres.put("role", "utilisateur");
			}
			rapport = serviceRapportCommande.getRapportJasper(jasperreport, parametres);
		} catch (JRException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    	return rapport;
    			
    }
    

}
