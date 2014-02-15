package sn.uva.pav.erreur.view;

import java.util.List;

import sn.organisation.pav.entite.Article;
import sn.uva.pav.mvp.BaseView;
import sn.uva.pav.mvp.BaseViewListener;

public interface ErreurView extends BaseView {
	
	public void setDisplayListeArticles(List<Article> listeArticles); 
	
	public interface ErreurViewListener extends BaseViewListener{
		void buttonClick(char operation);
	}

}
