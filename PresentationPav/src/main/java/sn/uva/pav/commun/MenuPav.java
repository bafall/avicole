package sn.uva.pav.commun;

import sn.uva.pav.catalogue.view.CatalogueViewImpl;
import sn.uva.pav.commande.view.CommandeViewImpl;
import sn.uva.pav.compte.view.CompteViewImpl;
import sn.uva.pav.panier.view.PanierViewImpl;
import com.vaadin.ui.MenuBar;
import com.vaadin.ui.UI;
import com.vaadin.ui.MenuBar.MenuItem;
import com.vaadin.ui.VerticalLayout;


public class MenuPav extends VerticalLayout{

	
	public MenuPav(){
		MenuBar barmenu = new MenuBar();
		barmenu.setSizeFull();
		
		
	       // Define a common menu command for all the menu items.
	        MenuBar.Command ongletCommande = new MenuBar.Command() {
		            private static final long serialVersionUID = 4483012525105015694L;
		
			            public void menuSelected(MenuItem selectedItem) {
			            	if(Constantes.MENU_CATALOGUE.equals(selectedItem.getText())){
			            		UI.getCurrent().getNavigator().navigateTo(CatalogueViewImpl.NAME);
			            	} else if(Constantes.MENU_PANIER.equals(selectedItem.getText())){
			            		UI.getCurrent().getNavigator().navigateTo(PanierViewImpl.NAME);
			            	} else if (Constantes.MENU_COMMANDE.equals(selectedItem.getText())){
			            		UI.getCurrent().getNavigator().navigateTo(CommandeViewImpl.NAME);
			            	} else if(Constantes.MENU_COMPTE.equals(selectedItem.getText())){
			            		UI.getCurrent().getNavigator().navigateTo(CompteViewImpl.NAME);
			            	}
			            } 
	      };
	      MenuBar.MenuItem catalogue = barmenu.addItem(Constantes.MENU_CATALOGUE, Constantes.ICON_HOME, ongletCommande);
	      MenuBar.MenuItem panier = barmenu.addItem(Constantes.MENU_PANIER, null, ongletCommande);
	      MenuBar.MenuItem commande = barmenu.addItem(Constantes.MENU_COMMANDE, null, ongletCommande);
	      MenuBar.MenuItem compte = barmenu.addItem(Constantes.MENU_COMPTE, null, ongletCommande);
	      addComponent(barmenu);
	}
}
