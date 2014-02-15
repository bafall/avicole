package sn.uva.pav.catalogue.view;

import java.util.List;

import com.vaadin.ui.Table;

import sn.organisation.pav.entite.Article;
import sn.organisation.pav.entite.Employe;
import sn.organisation.pav.entite.LigneCommande;
import sn.uva.pav.mvp.BaseView;
import sn.uva.pav.mvp.BaseViewListener;

public interface CatalogueView extends BaseView {
	
	void setDisplayListeArticles(List<Article> listeArticles); 
	
	 Table creerTableCatalogue(List<Article> listeArticles);
	
    byte[] getVignettes();
	
	List<LigneCommande> getPanier();
	
	public Employe enregistrer();
	
	public void setCadreLogin(boolean isUtilisateurConnecte);
	public void afficherMessageErreur(String message);
	
	public interface CatalogueViewListener extends BaseViewListener{
		
		void buttonClick(String identifiantBouton);
		
		
	}

}
