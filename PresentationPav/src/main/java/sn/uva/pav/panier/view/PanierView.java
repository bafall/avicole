package sn.uva.pav.panier.view;

import java.util.List;

import sn.organisation.pav.entite.Article;
import sn.uva.pav.mvp.BaseView;
import sn.uva.pav.mvp.BaseViewListener;

public interface PanierView extends BaseView {
	
	public void setDisplayListeArticles(List<Article> listeArticles); 
	
	public interface PanierViewListener extends BaseViewListener{
		void buttonClick(String captionBouton);
	}

}
