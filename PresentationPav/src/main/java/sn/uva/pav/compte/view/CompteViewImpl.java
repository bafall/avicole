package sn.uva.pav.compte.view;


import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;
import ru.xpoft.vaadin.VaadinView;
import sn.organisation.pav.entite.Employe;
import sn.uva.pav.PavUI;
import sn.uva.pav.commun.OngletPav;
import sn.uva.pav.commun.PivHautPav;
import sn.uva.pav.mvp.BaseViewListener;
import com.vaadin.navigator.ViewChangeListener.ViewChangeEvent;
import com.vaadin.ui.Alignment;
import com.vaadin.ui.Button;
import com.vaadin.ui.Button.ClickListener;
import com.vaadin.ui.FormLayout;
import com.vaadin.ui.HorizontalLayout;
import com.vaadin.ui.VerticalLayout;
import com.vaadin.ui.Button.ClickEvent;

@Component
@Scope("prototype")
//@RequiresRoles("client")
@VaadinView(CompteViewImpl.NAME)
public class CompteViewImpl extends VerticalLayout implements CompteView, ClickListener {
	
	private CompteViewListener listener;
	public static final String NAME = "admin/compte";
	public static final String BOUTON_MODIFIER = "Mettre à jour";
	public static final String BOUTON_ANNULER = "Annuler";
	private CompteForm compteForm;
	
	private PivHautPav pivH; 


	FormLayout formCompte = new FormLayout();
	
	private VerticalLayout cadrePrincipal = new VerticalLayout();

	@Override
	public void addListener(BaseViewListener listener) {
		this.listener = (CompteViewListener)listener;

	}

	@Override
	public void enter(ViewChangeEvent event) {

		compteForm = new CompteForm(((PavUI) this.getUI()).getEmploye());
		this.paintPivHaut();

		HorizontalLayout cadreBoutons = new HorizontalLayout();
		Button bAnnuler = new Button(BOUTON_ANNULER);
		Button bINscription = new Button(BOUTON_MODIFIER);
		
		bAnnuler.addClickListener(this);
		bINscription.addClickListener(this);
        VerticalLayout contenu = new VerticalLayout();
        contenu.addComponent(compteForm);
        cadreBoutons.addComponent(bAnnuler);
        cadreBoutons.addComponent(bINscription);
        cadreBoutons.setMargin(true);
        cadreBoutons.setSpacing(true);
        contenu.addComponent(cadreBoutons); 
        contenu.setSizeFull();
        contenu.setComponentAlignment(cadreBoutons, Alignment.BOTTOM_RIGHT);
        cadrePrincipal.addComponent(new OngletPav(contenu, new String[]{"Informations du compte"}));
        
        this.addComponent(cadrePrincipal);
        this.setComponentAlignment(cadrePrincipal, Alignment.BOTTOM_CENTER);

	}

	@Override
	public void buttonClick(ClickEvent event) {
		listener.buttonClick(event.getButton().getCaption());
	}

	@Override
	public void setDisplayInfosCompte(Employe employe) {
		
	}

	@Override
	public Employe getDisplayInfosCompte(Employe employe) {
		return (employe == null) ? new Employe() : employe ;
	}
	
	@Override
	public Employe enregistrer(){
		if(!compteForm.validateFields()){
			return null;
		}
		return compteForm.getCompte();
	}

	@Override
	public void annuler() {
		compteForm.annuler();
		
	}
	
	public void paintPivHaut(){
		pivH = new PivHautPav(cadrePrincipal, null);
	}

}
