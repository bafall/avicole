package sn.uva.pav.catalogue.view;


import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;
import org.apache.shiro.authz.annotation.RequiresRoles;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;
import org.vaadin.risto.stepper.IntStepper;
import ru.xpoft.vaadin.VaadinView;
import sn.organisation.pav.entite.Article;
import sn.organisation.pav.entite.Employe;
import sn.organisation.pav.entite.LigneCommande;
import sn.uva.pav.PavUI;
import sn.uva.pav.commun.ConnexionPav;
import sn.uva.pav.commun.Constantes;
import sn.uva.pav.commun.FenetreConnexionPav;
import sn.uva.pav.commun.OngletPav;
import sn.uva.pav.commun.PivHautPav;
import sn.uva.pav.commun.TablePagineePav;
import sn.uva.pav.commun.UploadPav;
import sn.uva.pav.mvp.BaseViewListener;
import com.jensjansson.pagedtable.PagedTable;
import com.vaadin.data.Item;
import com.vaadin.data.util.IndexedContainer;
import com.vaadin.navigator.ViewChangeListener.ViewChangeEvent;
import com.vaadin.server.StreamResource;
import com.vaadin.shared.ui.label.ContentMode;
import com.vaadin.ui.AbstractComponent;
import com.vaadin.ui.Alignment;
import com.vaadin.ui.Button;
import com.vaadin.ui.Button.ClickListener;
import com.vaadin.ui.HorizontalLayout;
import com.vaadin.ui.Image;
import com.vaadin.ui.Label;
import com.vaadin.ui.Panel;
import com.vaadin.ui.Table.ColumnHeaderMode;
import com.vaadin.ui.VerticalLayout;
import com.vaadin.ui.Button.ClickEvent;
import com.vaadin.ui.themes.Reindeer;

@Component
@Scope("prototype")
@RequiresRoles("client")
@VaadinView(CatalogueViewImpl.NAME)
public class CatalogueViewImpl extends VerticalLayout implements CatalogueView, ClickListener {
	
	public static final String NAME = "/accueil/catalogue";	
	private VerticalLayout cadrePrincipal = new VerticalLayout();
	private HorizontalLayout cadreFctionnalites = new HorizontalLayout();
	private CatalogueViewListener listener;
	//private PagedTable tableCatalogue;
	private TablePagineePav tableCatalogue;
	private IndexedContainer catalogueConteneur;
	private UploadPav upload;
	FenetreConnexionPav fenetreLogin;
	private Button inscription;
	private Button submit;
	private PivHautPav pivH;
	
	private List<LigneCommande> panier;
	

	public List<LigneCommande> getPanier() {
		return panier;
	}

//	public void setPanier(List<LigneCommande> panier) {
//		this.panier = panier;
//	}

	@Override
	public void addListener(BaseViewListener listener) {
		this.listener = (CatalogueViewListener)listener;

	}

	@Override
	public void enter(ViewChangeEvent event) {
		this.paintPivHaut();
		panier = new ArrayList<LigneCommande>();
		
		inscription = new Button("Inscription");
		inscription.addClickListener(this);
		submit = new Button("Connexion");
		submit.addClickListener(this);
		
        Button backButton = new Button("commande");
        //backButton.setStyleName("pavbouton");
        
        backButton.addStyleName("pavbouton");
        backButton.setImmediate(true);
        backButton.addClickListener(this);
        VerticalLayout contenu = new VerticalLayout();
        //contenu.setSizeFull();
        contenu.addComponent(backButton);
        
        catalogueConteneur = creerCatalogueContainer(((PavUI) this.getUI()).getCatalogue());
        tableCatalogue = new TablePagineePav(catalogueConteneur);
        contenu.addComponent(tableCatalogue);
        contenu.setComponentAlignment(tableCatalogue, Alignment.MIDDLE_CENTER);
        upload = new UploadPav("Téleversement");
        contenu.addComponent(upload);
        
        Button enreg = new Button("enreg");
        enreg.addClickListener(this);
        contenu.addComponent(enreg);
        OngletPav onglet = new OngletPav(contenu, new String[]{"Catalogue : Articles et produits"});
        fenetreLogin = new FenetreConnexionPav(inscription, submit);
        fenetreLogin.bindCadreLogin(ConnexionPav.isUtilisateurConnecte());
        cadreFctionnalites.setSizeFull();
        cadreFctionnalites.setSpacing(true);
        cadreFctionnalites.addComponent(onglet);
        cadreFctionnalites.addComponent(fenetreLogin);
        cadreFctionnalites.setExpandRatio(onglet, 2);
        cadreFctionnalites.setExpandRatio(fenetreLogin, 1);
        cadrePrincipal.addComponent(cadreFctionnalites);
        
        this.addComponent(cadrePrincipal);
        this.setComponentAlignment(cadrePrincipal, Alignment.BOTTOM_CENTER);

	}

	/**
	 * Mets à jour la liste de permis à afficher dans le display du catalogue
	 */
	@Override
	public void setDisplayListeArticles(List<Article> listeArticles) {
		
	}

	@Override
	public void buttonClick(ClickEvent event) {
		listener.buttonClick(event.getButton().getCaption());
	}
	
	public void paintPivHaut(){
		pivH = new PivHautPav(cadrePrincipal, ((PavUI) this.getUI()).getEmploye().getPrenom());
	}

	@Override
	public PagedTable creerTableCatalogue(List<Article> listeArticles) {
		PagedTable table = new PagedTable();
		table.setContainerDataSource(creerCatalogueContainer(listeArticles));
		table.setColumnHeaderMode(ColumnHeaderMode.HIDDEN);
		table.setImmediate(true);
		table.setPageLength(5);
		
        
		return table;
	}
	
	private IndexedContainer creerCatalogueContainer(List<Article> listeArticles){
		IndexedContainer container = new IndexedContainer();
        //container.addContainerProperty(Constantes.CATALOGUE_VIGNETTE, AbstractComponent.class, null);
        //container.addContainerProperty(Constantes.CATALOGUE_TITRE, AbstractComponent.class, "");
        //container.addContainerProperty(Constantes.CATALOGUE_QTE, AbstractComponent.class, "");
        container.addContainerProperty(Constantes.CATALOGUE_ACTIONS, AbstractComponent.class, "");
        
        for(Article article: listeArticles){
        	LigneCommande ligneCommande = new LigneCommande();
        	Item item = container.addItem(article);
        	
        	//this.setColonneVignette(item, article);
        	//this.setColonneTitre(item, article);
        	//this.setColonneQuantite(item, article, ligneCommande);
        	//this.setColonneActions(item, article);
        	this.setcolonneComposee(item, article, ligneCommande);
        	
//        	if(ligneCommande.getQteArticle() > 0){
//        		ligneCommande.setArtId(article);
//        	    ligneCommande.setPrixUnitaire(article.getArtPrix());
//        		getPanier().add(ligneCommande);
//        	}
        }
		return container;
	}
	
	@SuppressWarnings("unchecked")
	private void setColonneVignette(Item item, final Article article){ 
		VerticalLayout cadreVignette = new VerticalLayout();
		cadreVignette.setWidth("20em");
		Image image = new Image();
		if(article.getArtPhoto()!=null){
	  		StreamResource.StreamSource pdfSource = new StreamResource.StreamSource() {

	            public InputStream getStream() {
	            	
	               InputStream inStream =  new ByteArrayInputStream(article.getArtPhoto()) ;
	               return inStream;
	            }
	         };
	         image.setSource(new StreamResource(pdfSource, ""));
		}
         cadreVignette.addComponent(image);
		item.getItemProperty(Constantes.CATALOGUE_VIGNETTE).setValue(cadreVignette);
	}
	
	
	@SuppressWarnings("unchecked")
	private void setColonneTitre(Item item, Article article){
		VerticalLayout cadreTitre = new VerticalLayout();
		Label labelTitre = new Label(article.getArtNom());
		labelTitre.setStyleName(Reindeer.LABEL_H2);
		Label labelEtat = new Label(article.getArtEtat());
		Label labelRef = new Label(article.getArtDesc());
		cadreTitre.addComponent(labelTitre);
		cadreTitre.addComponent(labelEtat);
		cadreTitre.addComponent(labelRef);
		item.getItemProperty(Constantes.CATALOGUE_TITRE).setValue(cadreTitre);
	}
	
	
	
	@SuppressWarnings("unchecked")
	private void setColonneQuantite(Item item, Article article, LigneCommande ligne){
		VerticalLayout cadreQte = new VerticalLayout();
		cadreQte.setSizeFull();
		HorizontalLayout cadreBoutons = new HorizontalLayout();
		//final TextField textQte = new TextField();
		Label labelQte = new Label("Qté :");
		IntStepper quantite = new IntStepper();
		quantite.setValue(0);
		quantite.setStepAmount(1);
		quantite.setInvalidAllowed(false);
		quantite.setWidth("50px");
		quantite.setImmediate(true);
		quantite.setMaxValue(article.getArtStock());
		quantite.setMinValue(0);
		
		cadreBoutons.addComponent(labelQte);
		cadreBoutons.addComponent(quantite);
		
		cadreQte.addComponent(cadreBoutons);
		cadreQte.setComponentAlignment(cadreBoutons, Alignment.BOTTOM_RIGHT);
		item.getItemProperty(Constantes.CATALOGUE_QTE).setValue(cadreQte);
		
		ligne.setQteArticle(quantite.getValue());
	}
	
	@SuppressWarnings("unchecked")
	private void setColonneActions(Item item, Article article){
		VerticalLayout cadreActions = new VerticalLayout();
		Label labelPrix = new Label(article.getArtPrix().toString());
		labelPrix.setStyleName(Reindeer.LABEL_H2);
		Button bPanier = new Button("Ajouter au panier");
		bPanier.setData(article);
		bPanier.addClickListener(new ClickListener() {
			
			@Override
			public void buttonClick(ClickEvent event) {
				// Ajouter les articles au panier 
				
			}
		});
		cadreActions.addComponent(labelPrix);
		cadreActions.addComponent(bPanier);
		cadreActions.setComponentAlignment(labelPrix, Alignment.TOP_RIGHT);
		cadreActions.setComponentAlignment(bPanier, Alignment.BOTTOM_RIGHT);
		item.getItemProperty(Constantes.CATALOGUE_ACTIONS).setValue(cadreActions);
	}

	@Override
	public byte[] getVignettes() {
		return upload.getByteUpload();
	}
	
	@SuppressWarnings("unchecked")
	public void setcolonneComposee(Item item, final Article article, final LigneCommande ligneCmd){
		HorizontalLayout cadre = new HorizontalLayout();
		cadre.setWidth("98%");
		cadre.setHeight("150px");
		
		Panel cadreVignette = new Panel();
		cadreVignette.setHeight("150px");
		cadreVignette.setWidth("150px");
		
		VerticalLayout cadreArticle = new VerticalLayout();
		cadreArticle.setSizeFull();
		cadreArticle.setHeight("150px");
		HorizontalLayout cadreTitreArticle = new HorizontalLayout();
		HorizontalLayout cadreBouton = new HorizontalLayout();
		Label labelTitre = new Label(article.getArtNom());		
		labelTitre.setStyleName(Reindeer.LABEL_H2);
		Label labelPrix = new Label("Prix : <b>"+article.getArtPrix() + Constantes.DEVISE_SN+"</b>", ContentMode.HTML);
		Label labelEtat = new Label("État : "+article.getArtEtat());		
		Label labelReference = new Label(article.getArtDesc());	
		Label labelQte = new Label("Qté : ");
		
		final IntStepper quantite = new IntStepper();
		quantite.setValue(0);
		quantite.setStepAmount(1);
		quantite.setInvalidAllowed(false);
		quantite.setWidth("45px");
		quantite.setImmediate(true);
		quantite.setMaxValue(article.getArtStock());
		quantite.setMinValue(0);
		
		Button bPanier = new Button("Ajouter au panier");
		bPanier.setData(article);
		bPanier.addClickListener(new ClickListener() {
			
			@Override
			public void buttonClick(ClickEvent event) {
				// Ajouter les articles au panier 
				if(quantite.getValue() >0){
	        		ligneCmd.setArtId(article);
	        	    ligneCmd.setPrixUnitaire(article.getArtPrix());
	        	    ligneCmd.setQteArticle(quantite.getValue());
	        		getPanier().add(ligneCmd);
	        		
	        		setValeurPanier(getPanier());
				}
				

			}
		});
		
		//vignette
		Image image = new Image();
		if(article.getArtPhoto()!=null){
	  		StreamResource.StreamSource pdfSource = new StreamResource.StreamSource() {

	            public InputStream getStream() {
	            	
	               InputStream inStream =  new ByteArrayInputStream(article.getArtPhoto()) ;
	               return inStream;
	            }
	         };
	         image.setSource(new StreamResource(pdfSource, ""));
		}
         cadreVignette.setContent(image);
		
         
		cadre.addComponent(cadreVignette);
		cadre.addComponent(cadreArticle);
		cadre.setExpandRatio(cadreVignette, 2);
		cadre.setExpandRatio(cadreArticle, 7);
		
		cadreBouton.addComponent(labelQte);
		cadreBouton.addComponent(quantite);
		cadreBouton.addComponent(bPanier);
		cadreBouton.setSpacing(true);
		cadreArticle.addComponent(cadreTitreArticle);
		cadreArticle.addComponent(labelEtat);
		cadreArticle.addComponent(labelReference);
		cadreArticle.addComponent(cadreBouton);
		
		cadreTitreArticle.addComponent(labelTitre);
		cadreTitreArticle.addComponent(labelPrix);
		cadreTitreArticle.setSizeFull();
		cadreTitreArticle.setExpandRatio(labelTitre, 3);
		cadreTitreArticle.setExpandRatio(labelPrix, 1);
		cadreTitreArticle.setComponentAlignment(labelTitre, Alignment.TOP_LEFT);
		cadreTitreArticle.setComponentAlignment(labelPrix, Alignment.TOP_RIGHT);
		
		cadreArticle.setComponentAlignment(cadreBouton, Alignment.BOTTOM_RIGHT);
		
		
		item.getItemProperty(Constantes.CATALOGUE_ACTIONS).setValue(cadre);
			
	}

	@Override
	public Employe enregistrer() {		
		return fenetreLogin.getCompte();
	}

	@Override
	public void setCadreLogin(boolean isUtilisateurConnecte) {
		fenetreLogin.bindCadreLogin(isUtilisateurConnecte);
		
	}

	@Override
	public void afficherMessageErreur(String message) {
		fenetreLogin.afficherMessage();
		
	}
	
	public void setValeurPanier(List<LigneCommande> panier){
		if(panier!=null && !panier.isEmpty()){
			int nbArticle = 0;
			double prixTotal= 0;
			for(LigneCommande unite : panier){
				nbArticle = nbArticle + unite.getQteArticle();
				prixTotal = prixTotal + (unite.getQteArticle() *unite.getPrixUnitaire());
			}
			pivH.setValeurPanier(nbArticle, prixTotal);
		}
	}
	

}
