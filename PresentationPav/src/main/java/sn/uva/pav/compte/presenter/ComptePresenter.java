package sn.uva.pav.compte.presenter;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Configurable;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import com.vaadin.ui.Notification;

import sn.organisation.pav.entite.Employe;
import sn.organisation.pav.service.ServiceCommande;
import sn.uva.pav.compte.view.CompteView;
import sn.uva.pav.compte.view.CompteViewImpl;
import sn.uva.pav.mvp.BasePresenter;

@Configurable(preConstruction = true)
@Transactional
@Component
@Scope("prototype")
public class ComptePresenter extends BasePresenter implements CompteView.CompteViewListener {
	
	@Autowired
	ServiceCommande serviceCommande;
	
	public ComptePresenter(){
		
	}

	@Override
	public void buttonClick(String identifiantBouton) {
		if(CompteViewImpl.BOUTON_MODIFIER.equals(identifiantBouton)){
			onModifierCompte ();
			
		} else if(CompteViewImpl.BOUTON_ANNULER.equals(identifiantBouton)){
			// Discard ...
			onAnnulerInscription();
		} 
	}
	
	/**
	 * Lance la création d'un nouveau compte utilisateur,
	 * qui sera stocké dans la table EMPLOYE de la BD.
	 */
	private void onModifierCompte (){
		
		Employe employe = ((CompteView) view).enregistrer();
		if(employe == null){
			Notification.show(null, "<br/><p>Le formulaire contient des erreurs!</p>", Notification.Type.ERROR_MESSAGE);
		} else {
			((CompteView) view).setDisplayInfosCompte(employe);
			serviceCommande.modifierEmploye(employe);
			Notification.show("la modification du compte s'est effectuée avec succès!");
		}

	}
	
	private void onAnnulerInscription (){
		((CompteView) view).annuler();
	}
	
	

}
