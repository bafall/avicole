package sn.uva.pav.commande.view;

import java.util.List;

import sn.organisation.pav.entite.Article;
import sn.uva.pav.mvp.BaseView;
import sn.uva.pav.mvp.BaseViewListener;

public interface CommandeView extends BaseView {
	
	public void setDisplayListeArticles(List<Article> listeArticles); 
	
	public interface CommandeViewListener extends BaseViewListener{
		void buttonClick(String captionBouton);
	}

}
