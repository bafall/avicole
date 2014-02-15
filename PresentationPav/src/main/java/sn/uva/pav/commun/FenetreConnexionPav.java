package sn.uva.pav.commun;


import sn.organisation.pav.entite.Employe;
import sn.uva.pav.PavUI;

import com.vaadin.data.fieldgroup.BeanFieldGroup;
import com.vaadin.data.fieldgroup.FieldGroup;
import com.vaadin.data.fieldgroup.FieldGroup.CommitException;
import com.vaadin.data.util.BeanItem;
import com.vaadin.server.VaadinSession;
import com.vaadin.shared.ui.label.ContentMode;
import com.vaadin.ui.Button;
import com.vaadin.ui.CheckBox;
import com.vaadin.ui.FormLayout;
import com.vaadin.ui.Label;
import com.vaadin.ui.Panel;
import com.vaadin.ui.PasswordField;
import com.vaadin.ui.TextField;
import com.vaadin.ui.VerticalLayout;
import com.vaadin.ui.Button.ClickEvent;
import com.vaadin.ui.Button.ClickListener;
import com.vaadin.ui.themes.Reindeer;

public class FenetreConnexionPav  extends Panel{

	private PasswordField champMotPasse = new PasswordField("Mot de passe :");
	private TextField champIdentifiant = new TextField("Identifiant :");
	private CheckBox seSouvenirDeMoi = new CheckBox("Se souvenir de moi?");
	private final FieldGroup bean = new BeanFieldGroup<Employe>(Employe.class);
	private Button inscription;
	private Button submit;
	private FormLayout cadreLogin;
	private VerticalLayout cadreConnecte;
	private Label labelMessage = new Label("<span style=\"color:red\">Les infos de conexions sont incorrects</span>", ContentMode.HTML);
	
	public FenetreConnexionPav(Button inscription, Button submit) {
		this.inscription = inscription;
		this.submit = submit;
		cadreLogin = new FormLayout();
		cadreConnecte = new VerticalLayout();
		champIdentifiant.setInputPrompt("Pseudo");
		champIdentifiant.setNullRepresentation("");
		champMotPasse.setInputPrompt("*****");
		champMotPasse.setNullRepresentation("");
		this.setCaption("Déjà membre?");
		//this.setContent(cadreLogin);
	}
	
	public void bindCadreLogin(boolean isUtilisateurConnecte){
		if(isUtilisateurConnecte){
			bindCadreConnecte();
		} else {
			bindFormLogin();
		}

	}
	
	
	public void bindCadreConnecte(){
		Button livraison = new Button("Deconnexion");
		livraison.setStyleName(Reindeer.BUTTON_LINK);
		cadreConnecte.addComponent(livraison);
		this.setContent(cadreConnecte);
		
		livraison.addClickListener(new ClickListener() {
			
			@Override
			public void buttonClick(ClickEvent event) {
				// Deconnexion
				if(ConnexionPav.isUtilisateurConnecte()){
					ConnexionPav.deconnexion();
					bindFormLogin();
				}
				
			}
		});
	}
	
	public void bindFormLogin(){
		cadreLogin.addComponent(labelMessage);
		labelMessage.setVisible(false);
		labelMessage.setImmediate(true);
		cadreLogin.addComponent(champIdentifiant);
		cadreLogin.addComponent(champMotPasse);
		cadreLogin.addComponent(seSouvenirDeMoi);
		cadreLogin.addComponent(submit);
		cadreLogin.addComponent(inscription);
	    bean.bind(champIdentifiant,"codeEmploye");
	    bean.bind(champMotPasse,"motPasse");
	    
	    bean.setItemDataSource(new BeanItem<Employe>(new Employe()));
		this.setContent(cadreLogin);
		this.setHeight("300px");
	}
	
	@SuppressWarnings("unchecked")
	public Employe getCompte() {

		try {
			bean.commit();
		} catch (CommitException e) {
			e.printStackTrace();
		}
			
        return ((BeanItem<Employe>) bean.getItemDataSource()).getBean();
    }
	
	public void afficherMessage(){
		labelMessage.setVisible(true);
	}
	

}
