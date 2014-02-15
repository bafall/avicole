package sn.uva.pav.compte.view;


import sn.organisation.pav.entite.Employe;
import sn.uva.pav.mvp.BaseView;
import sn.uva.pav.mvp.BaseViewListener;

public interface CompteView extends BaseView {
	
	public void setDisplayInfosCompte(Employe employe); 
	
	public Employe getDisplayInfosCompte(Employe employe);
	
	public Employe enregistrer();
	
	public void annuler();
	
	public interface CompteViewListener extends BaseViewListener{
		
		void buttonClick(String identifiantBouton);
		
	}

}
