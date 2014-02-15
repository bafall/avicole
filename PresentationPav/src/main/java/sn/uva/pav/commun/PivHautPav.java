package sn.uva.pav.commun;


import com.vaadin.server.ExternalResource;
import com.vaadin.ui.Alignment;
import com.vaadin.ui.Button;
import com.vaadin.ui.HorizontalLayout;
import com.vaadin.ui.Label;
import com.vaadin.ui.Link;
import com.vaadin.ui.TextField;
import com.vaadin.ui.VerticalLayout;
import com.vaadin.ui.themes.BaseTheme;
import com.vaadin.ui.themes.Reindeer;

public class PivHautPav {

	private HorizontalLayout pivHaut;
	private Button labelPanier;
	
	public PivHautPav(VerticalLayout cadrePrincipal, String nomEmploye) {
		HorizontalLayout layoutLogo = new HorizontalLayout();
		HorizontalLayout layoutPanier = new HorizontalLayout();
		HorizontalLayout header = new HorizontalLayout();
		HorizontalLayout layoutMenu = new HorizontalLayout();
		HorizontalLayout layoutBlancMenu = new HorizontalLayout();
		
		pivHaut = new  HorizontalLayout();
		labelPanier = new Button("(0) | 0");
		
		TextField champRecherche = new TextField();
		Button bRechercher = new Button();
		Link inscription = new Link("Inscription", new ExternalResource(Constantes.URL_INSCRIPTION));
		Link seConnecter = new Link("Se connecter", new ExternalResource(Constantes.URL_CONNEXION));
		MenuPav menu = new MenuPav();
		Label barreVerticale = new Label(" | ");
		Button logoPav = new Button();
		
		header.setHeight("50px");
		header.setSizeFull();
		header.setStyleName(Reindeer.LAYOUT_WHITE);
		layoutPanier.setStyleName(Reindeer.LAYOUT_WHITE);
		layoutPanier.setSizeFull();
		layoutPanier.setHeight("50px");
		layoutPanier.setMargin(true);
		
		header.addComponent(layoutLogo);
		header.addComponent(layoutPanier);	
		header.setExpandRatio(layoutLogo, 2);
		header.setExpandRatio(layoutPanier, 3);			
		
		labelPanier.setIcon(Constantes.ICONE_PANIER);
		labelPanier.setStyleName(BaseTheme.BUTTON_LINK);		
		
		layoutLogo.setStyleName(Reindeer.LAYOUT_WHITE);
		layoutLogo.setSpacing(true);
		layoutLogo.setSizeFull();
		layoutLogo.setHeight("50px");
		
		bRechercher.setStyleName(BaseTheme.BUTTON_LINK);
		bRechercher.setIcon(Constantes.ICON_RECHERCHE, "Rechercher");
	
		
		logoPav.setIcon(Constantes.LOGO_PAV);
		logoPav.setStyleName(Reindeer.BUTTON_LINK);
		champRecherche.setInputPrompt(Constantes.RECHERCHER_ARTICLE);
		champRecherche.setStyleName(Reindeer.TEXTFIELD_SMALL);
		champRecherche.setWidth(Constantes.TAILLE_CHAMP_RECHERCHE);
		
		
		layoutLogo.addComponent(logoPav);
		layoutLogo.addComponent(seConnecter);
		layoutLogo.addComponent(barreVerticale);
		layoutLogo.addComponent(inscription);
		layoutLogo.setExpandRatio(logoPav, 4);
		layoutLogo.setExpandRatio(seConnecter, 3);
		layoutLogo.setExpandRatio(barreVerticale, 1);
		layoutLogo.setExpandRatio(inscription, 3);
		layoutLogo.setComponentAlignment(logoPav, Alignment.MIDDLE_LEFT);
		layoutLogo.setComponentAlignment(seConnecter, Alignment.MIDDLE_LEFT);
		layoutLogo.setComponentAlignment(barreVerticale, Alignment.MIDDLE_LEFT);
		layoutLogo.setComponentAlignment(inscription, Alignment.MIDDLE_LEFT);
		
		pivHaut.setSpacing(true);
		
		layoutPanier.addComponent(labelPanier);
		layoutPanier.setComponentAlignment(labelPanier, Alignment.MIDDLE_RIGHT);
		
		cadrePrincipal.setWidth(Constantes.CADRE_TAILLE);
		cadrePrincipal.addComponent(header);
		cadrePrincipal.setSpacing(true);
		cadrePrincipal.addComponent(pivHaut);
		cadrePrincipal.setComponentAlignment(pivHaut, Alignment.BOTTOM_RIGHT);
		
		layoutMenu.addStyleName("pavlayoutmenu");
		layoutMenu.setSizeFull();
		
		layoutMenu.addComponent(menu);
		layoutMenu.addComponent(champRecherche);
		layoutMenu.addComponent(bRechercher);
		layoutMenu.setExpandRatio(menu, 9);
		layoutMenu.setExpandRatio(champRecherche, 4);
		layoutMenu.setExpandRatio(bRechercher, 1);
		layoutMenu.setComponentAlignment(champRecherche, Alignment.MIDDLE_RIGHT);
		layoutMenu.setComponentAlignment(bRechercher, Alignment.MIDDLE_LEFT);
		cadrePrincipal.addComponent(layoutMenu);
		cadrePrincipal.addComponent(layoutBlancMenu);
		
	}
	
	
	
	public void setValeurPanier(int nbArticle, double prixTotal){
		
		labelPanier.setCaption("("+nbArticle+") | "+prixTotal+"");
		labelPanier.setStyleName(Reindeer.BUTTON_LINK);
		labelPanier.setImmediate(true);
	}

}
