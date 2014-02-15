package sn.uva.pav.commun;

import com.vaadin.ui.Layout;
import com.vaadin.ui.Notification;
import com.vaadin.ui.TabSheet;
import com.vaadin.ui.TabSheet.SelectedTabChangeEvent;
import com.vaadin.ui.UI;
import com.vaadin.ui.VerticalLayout;

public class OngletPav extends VerticalLayout{
	
	private TabSheet onglets = new TabSheet();
	
	public TabSheet getOnglets() {
		return onglets;
	}

	public void setOnglets(TabSheet onglets) {
		this.onglets = onglets;
	}

	public static final String  RESERVATION = "Réservation - Plage horaire" ;
	public static final String  SUIVI = "Suivi de commande"; 
	public static final String  DETAIL = "Détail de la commande"; 
	public static final String  HISTORIQUE = "Historique commande";
	public OngletPav(VerticalLayout contenu, String [] listeOnglets){
		
		for(int i=0; i<listeOnglets.length; i++ ){
			onglets.addTab(contenu, listeOnglets[i]);
		}
		
		this.addComponent(onglets);
	}
	
	public OngletPav(VerticalLayout [] listeContenus, String [] listeOnglets){
		
		for(int i=0; i<listeOnglets.length; i++ ){
			onglets.addTab(listeContenus[i], listeOnglets[i]);
		}
		
		this.addComponent(onglets);
		//this.gererOnglets();
	}
	
	public void gererOnglets(){
		// Create tab content dynamically when tab is selected
		onglets.addSelectedTabChangeListener(
		        new TabSheet.SelectedTabChangeListener() {
		    @Override
		    public void selectedTabChange(SelectedTabChangeEvent event) {
		        // Find the tabsheet
		        TabSheet tabsheet = event.getTabSheet();
		        
		        // Find the tab (here we know it's a layout)
		        Layout tab = (Layout) tabsheet.getSelectedTab();

		        
		        // Get the tab caption from the tab object
		        String caption = tabsheet.getTab(tab).getCaption();
		        Notification.show(caption);
		        String suivi = event.getTabSheet().getTab((Layout)event.getTabSheet().getSelectedTab()).getCaption();
		        if(suivi.equals(SUIVI) ||suivi.equalsIgnoreCase(SUIVI)){
		        	
		        	Notification.show("Bingo");
		        }
		        if(SUIVI.equalsIgnoreCase(event.getTabSheet().getSelectedTab().getCaption())){
		        	Notification.show("Bingo");
		        }

		    }

		});
	}

}
