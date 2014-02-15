package sn.uva.pav.commun;


import com.vaadin.shared.ui.label.ContentMode;
import com.vaadin.ui.Alignment;
import com.vaadin.ui.Button;
import com.vaadin.ui.HorizontalLayout;
import com.vaadin.ui.Label;
import com.vaadin.ui.VerticalLayout;
import com.vaadin.ui.Window;
import com.vaadin.ui.themes.Reindeer;

/**
 * Classe utilitaire permettant de créer un popup Glr personnalisé.
 * @author bafall
 *
 */
public class PavPopup extends Window {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private static final String MSG_PAR_DEFAUT = "<p>Des modifications ont été apportés au formulaire. Elles ne seront pas " +
			"sauvegardées si vous quittez cette page. Voulez-vous continuer?</p>";
	
	public PavPopup(String titre, String message, Button popupOK, Button popupAnnuler){
		this.setCaption(titre);
		this.setWidth("500px");
		this.setStyleName(Reindeer.WINDOW_BLACK);
		Label messageLabel = new Label((message!=null)? message : MSG_PAR_DEFAUT, ContentMode.HTML);
		
		VerticalLayout layout = new VerticalLayout();
		layout.setSizeFull();
		HorizontalLayout layoutBoutons = new HorizontalLayout();
		popupOK.setCaption("OK");
		popupAnnuler.setCaption("Annuler");
        layoutBoutons.addComponent(popupOK);
        layoutBoutons.addComponent(popupAnnuler);
        layout.addComponent(messageLabel);
        layout.addComponent(layoutBoutons);
        layout.setComponentAlignment(layoutBoutons, Alignment.BOTTOM_RIGHT);
        this.setContent(layout);
        this.center();
	}
	
	public void fermerPopup(){
		
	}
}
