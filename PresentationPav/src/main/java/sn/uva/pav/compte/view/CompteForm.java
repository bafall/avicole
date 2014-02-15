package sn.uva.pav.compte.view;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;

import sn.organisation.pav.entite.Employe;
import sn.uva.pav.commun.Constantes;
import sn.uva.pav.commun.UtilitairePav;

import com.vaadin.data.Validator.EmptyValueException;
import com.vaadin.data.Validator.InvalidValueException;
import com.vaadin.data.fieldgroup.BeanFieldGroup;
import com.vaadin.data.fieldgroup.FieldGroup;
import com.vaadin.data.fieldgroup.FieldGroupFieldFactory;
import com.vaadin.data.fieldgroup.FieldGroup.CommitException;
import com.vaadin.data.fieldgroup.PropertyId;
import com.vaadin.data.util.BeanItem;
import com.vaadin.data.validator.BeanValidator;
import com.vaadin.server.UserError;
import com.vaadin.ui.AbstractField;
import com.vaadin.ui.ComboBox;
import com.vaadin.ui.Component;
import com.vaadin.ui.Field;
import com.vaadin.ui.FormLayout;
import com.vaadin.ui.PasswordField;
import com.vaadin.ui.Select;
import com.vaadin.ui.TextField;

public class CompteForm extends FormLayout {
	
	final FieldGroup fieldGroup = new BeanFieldGroup<Employe>(Employe.class);
	

	
	//@PropertyId("codeSexe")
	//private Field<?> champGenre = fieldGroup.buildAndBind("","codeSexe", Select.class);
	private ComboBox champGenre = new ComboBox("", UtilitairePav.getListeSexes());
	
	//@PropertyId("nom")
	//private Field<?> champNom = fieldGroup.buildAndBind("Nom :","nom", TextField.class);
	private TextField champNom = new TextField("Nom :");
	
	//@PropertyId("prenom")
	//private Field<?> champPrenom = fieldGroup.buildAndBind("Prénom :","prenom", TextField.class);
	private TextField champPrenom = new TextField("Prénom :");
	
	//@PropertyId("courriel")
	//private Field<?> champCourriel= fieldGroup.buildAndBind("Courriel :","courriel", TextField.class);
	private TextField champCourriel= new TextField("Courriel :");
	
	//@PropertyId("codeEmploye")
	private TextField champIdentifiant = new TextField("Identifiant :");
	
	//@PropertyId("motPasse")
	//private Field<?> champMotPasse = fieldGroup.buildAndBind("Mot de passe :","motPasse", PasswordField.class);
	private PasswordField champMotPasse = new PasswordField("Mot de passe :");
	
	//@PropertyId("confirmationMotPasse")
	//private Field<?> champConfirmMotPasse = fieldGroup.buildAndBind("Confirmation mot de passe :","confirmationMotPasse", PasswordField.class);
	private PasswordField champConfirmMotPasse = new PasswordField("Confirmation mot de passe :");
	
	
    private List<AbstractField> champsAValider;

	//@PropertyId("motPasse")
	//private PasswordField champConfirmMotPasse;
	
	
	public CompteForm(Employe employe){
		
	    //fieldGroup.setBuffered(true);

		//fieldGroup.buildAndBindMemberFields(this);
		//champGenre.setContainerDataSource(UtilitairePav.getListeSexes());
		//champGenre.setItemCaptionPropertyId(UtilitairePav.Sexe_PROPERTY_NAME);
		//champGenre.setConverter(String.class);
		
		champsAValider = new ArrayList<AbstractField>();
		
	    champGenre.setItemCaptionPropertyId(UtilitairePav.Sexe_PROPERTY_NAME);
	    
	    /**
	     * Mappage des composants de la vue aux champs de l'entité Employe
	     */
	    fieldGroup.bind(champGenre,"codeSexe");
	    fieldGroup.bind(champNom,"nom");
	    fieldGroup.bind(champPrenom,"prenom");
	    fieldGroup.bind(champIdentifiant,"codeEmploye");
	    fieldGroup.bind(champCourriel,"courriel");
	    fieldGroup.bind(champMotPasse,"motPasse");
	    fieldGroup.bind(champConfirmMotPasse,"confirmationMotPasse");
	    this.setValidationUtils();
	    champNom.setWidth(Constantes.WIDTH_CHAMPS);
	    champPrenom.setWidth(Constantes.WIDTH_CHAMPS);
	    champCourriel.setWidth(Constantes.WIDTH_CHAMPS);
	    champIdentifiant.setWidth(Constantes.WIDTH_CHAMPS);
		addComponent(champGenre);
		addComponent(champNom);
		addComponent(champPrenom);
		addComponent(champCourriel);
		addComponent(champIdentifiant);
		addComponent(champMotPasse);
		addComponent(champConfirmMotPasse);
		fieldGroup.setItemDataSource(new BeanItem<Employe>(employe));
		champIdentifiant.setEnabled(false);
		setImmediate(true);
		setMargin(true);
		setSpacing(true);
		
		
	}
	
	public void setValidationUtils(){
		//champPrenom.setRequired(true);
		//champPrenom.setRequiredError(Constantes.DEFAULT_MANDATORY_FIELD);
		champPrenom.addValidator(new BeanValidator(Employe.class, "prenom"));
		//champNom.addValidator(new BeanValidator(Employe.class, "nom"));
		champNom.setRequired(true);
		//champNom.setRequiredError(Constantes.DEFAULT_MANDATORY_FIELD);
		champGenre.setRequired(true);
		//champGenre.setRequiredError(Constantes.DEFAULT_MANDATORY_FIELD);
		champGenre.setImmediate(true);
		champMotPasse.setRequired(true);
		//champMotPasse.setRequiredError(Constantes.DEFAULT_MANDATORY_FIELD);
		champConfirmMotPasse.setRequired(true);
		//champConfirmMotPasse.setRequiredError(Constantes.DEFAULT_MANDATORY_FIELD);
		champCourriel.setRequired(true);
		//champCourriel.setRequiredError(Constantes.DEFAULT_MANDATORY_FIELD);

		champsAValider.add(champGenre);
		champsAValider.add(champNom);
		champsAValider.add(champPrenom);
		champsAValider.add(champCourriel);
		champsAValider.add(champIdentifiant);
		champsAValider.add(champMotPasse);
		champsAValider.add(champConfirmMotPasse);
		
	}
	
	
    @SuppressWarnings("unchecked")
	public Employe getCompte() {
    	try {

			fieldGroup.commit();
			
		} catch (EmptyValueException e) {
		    // A required value was missing
		    for (Iterator<Component> i = this.getComponentIterator();
		            i.hasNext();)
		           ((AbstractField) i.next()).setValidationVisible(true);
		    
		    
		} catch (CommitException e) {
		    for (Component c: this)
		        ((AbstractField)c).setValidationVisible(true);
		    
		    
		    for (Iterator<Component> i = this.getComponentIterator();
		            i.hasNext();)
		           ((AbstractField) i.next()).setValidationVisible(true);
		}
        return ((BeanItem<Employe>) fieldGroup.getItemDataSource()).getBean();
    }
    
    public void annuler(){
    	
    	fieldGroup.discard();
    }
    
    public boolean estModifie(){
    	return fieldGroup.isModified();
    }
    
    
    /**
     * Permet d'effectuer la validation des champs requis du formulaire
     * avant sa soumission à la BD
     * @return <code>true</code> si tous les champs sont valides
     */
    public boolean validateFields()
    {
       boolean valide = true;
       for (int i = 0; i < champsAValider.size(); ++i)
       {
          AbstractField field = champsAValider.get(i);
          field.setComponentError(null);
          try
          {
             if (field.isVisible())
             {
            	 if (field.isRequired() && estVide(field.getValue()))
                {
                   throw new InvalidValueException((Constantes.DEFAULT_MANDATORY_FIELD));
                }
                else
                {
                   field.validate();
                }
             }
          }
          catch (InvalidValueException e)
          {

             // C'est ici qu'on récupère les exception durant la validation et
             // qu'on les affiches.
             field.setComponentError(new UserError(e.getMessage()));
             valide = false;
          }
       }
       return valide;
    }
    
    
    /**
     * Retourne <code>true</code> si l'objet passé en paramètre est vide 
     * @param o l'objet 
     * @return <code>true</code> si l'objet est vide <code>false</code> sinon
     */
    private boolean estVide(Object o)
    {
       return o == null || o.equals("") || isEmptyArray(o) || isEmptyCollection(o);
    }

    /**
     * Découpage de la fonction isEmpty(). Cette partie s'occupe des arrays.
     * 
     * @return True si o est un array vide.
     */
    private boolean isEmptyArray(Object o)
    {
       return (o instanceof Object[] && ((Object[]) o).length == 0);
    }

    /**
     * Découpage de la fonction isEmpty(). Cette partie s'occupe des collections.
     * 
     * @return True si o est une collection vide.
     */
    private boolean isEmptyCollection(Object o)
    {
       return (o instanceof Collection<?> && ((Collection<?>) o).isEmpty());
    }
  

}
