package sn.uva.pav.commun;

import com.jensjansson.pagedtable.PagedTable;
import com.vaadin.data.util.IndexedContainer;
import com.vaadin.ui.CustomComponent;
import com.vaadin.ui.Panel;
import com.vaadin.ui.Table.ColumnHeaderMode;
import com.vaadin.ui.themes.Reindeer;
import com.vaadin.ui.VerticalLayout;


public class TablePagineePav extends CustomComponent {


	private static final long serialVersionUID = 1L;
    private PagedTable tablepaginee;
    private Panel root;



	public TablePagineePav(IndexedContainer conteneur) {
		root = new Panel();
		setCompositionRoot(root);
		root.setStyleName(Reindeer.PANEL_LIGHT);
		tablepaginee = new PagedTable();
		tablepaginee.setContainerDataSource(conteneur);
		
		root.setWidth("98%");
		
		VerticalLayout cadre = new VerticalLayout();
		cadre.addComponent(tablepaginee.createControls());
		cadre.addComponent(tablepaginee);       
		cadre.addComponent(tablepaginee.createControls());
		root.setContent(cadre);
		cadre.setWidth("99%");
		tablepaginee.setWidth("100%");
		tablepaginee.setColumnHeaderMode(ColumnHeaderMode.HIDDEN);
		tablepaginee.setPageLength(5);		
		 
	}
	
	
	/**
	 * Met à jour le contenu de la table
	 * @param conteneur le nouveau contenu
	 */
	public void setConteneur(IndexedContainer conteneur) {
		tablepaginee.setContainerDataSource(conteneur);
	}
	
	
	/**
	 * Met à jour la taille par page.
	 * @param pageLength la nouvelle taille
	 */
	public void setTaillePage(int pageLength){
		tablepaginee.setPageLength(pageLength);
	}
	
	
    


}
