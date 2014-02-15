package sn.organisation.pav.entite;
import java.util.Date;
import java.util.Set;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import org.apache.commons.lang3.builder.ReflectionToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import org.springframework.beans.factory.annotation.Configurable;
import org.springframework.format.annotation.DateTimeFormat;


@Configurable
@Entity
@Table(name = "article")
public class Article {

	public String toString() {
        return new ReflectionToStringBuilder(this, ToStringStyle.SHORT_PREFIX_STYLE).setExcludeFieldNames("ligneCommandes", "categCode").toString();
    }

	@Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "ART_ID")
    private Integer artId;

	public Integer getArtId() {
        return this.artId;
    }

	public void setArtId(Integer id) {
        this.artId = id;
    }

	@OneToMany(mappedBy = "artId")
    private Set<LigneCommande> ligneCommandes;

	@ManyToOne
    @JoinColumn(name = "CATEG_CODE", referencedColumnName = "CATEG_CODE", nullable = false)
    private CategorieArticle categCode;

	@Column(name = "ART_NOM", length = 100)
    @NotNull
    private String artNom;

	@Column(name = "ART_DESC")
    @NotNull
    private String artDesc;

	@Column(name = "ART_PRIX")
    @NotNull
    private Double artPrix;

	@Column(name = "ART_ETAT", length = 3)
    @NotNull
    private String artEtat;

	@Column(name = "ART_POIDS")
    private Double artPoids;

	@Column(name = "ART_PHOTO")
    private byte[] artPhoto;

	@Column(name = "ART_VIGNETTE")
    private byte[] artVignette;

	@Column(name = "ART_REDUCTION")
    private Integer artReduction;

	@Column(name = "ART_STOCK")
    @NotNull
    private Integer artStock;

	@Column(name = "ART_DATE")
    @Temporal(TemporalType.DATE)
    @DateTimeFormat(style = "M-")
    private Date artDate;

	public Set<LigneCommande> getLigneCommandes() {
        return ligneCommandes;
    }

	public void setLigneCommandes(Set<LigneCommande> ligneCommandes) {
        this.ligneCommandes = ligneCommandes;
    }

	public CategorieArticle getCategCode() {
        return categCode;
    }

	public void setCategCode(CategorieArticle categCode) {
        this.categCode = categCode;
    }

	public String getArtNom() {
        return artNom;
    }

	public void setArtNom(String artNom) {
        this.artNom = artNom;
    }

	public String getArtDesc() {
        return artDesc;
    }

	public void setArtDesc(String artDesc) {
        this.artDesc = artDesc;
    }

	public Double getArtPrix() {
        return artPrix;
    }

	public void setArtPrix(Double artPrix) {
        this.artPrix = artPrix;
    }

	public String getArtEtat() {
        return artEtat;
    }

	public void setArtEtat(String artEtat) {
        this.artEtat = artEtat;
    }

	public Double getArtPoids() {
        return artPoids;
    }

	public void setArtPoids(Double artPoids) {
        this.artPoids = artPoids;
    }

	public byte[] getArtPhoto() {
        return artPhoto;
    }

	public void setArtPhoto(byte[] artPhoto) {
        this.artPhoto = artPhoto;
    }

	public byte[] getArtVignette() {
        return artVignette;
    }

	public void setArtVignette(byte[] artVignette) {
        this.artVignette = artVignette;
    }

	public Integer getArtReduction() {
        return artReduction;
    }

	public void setArtReduction(Integer artReduction) {
        this.artReduction = artReduction;
    }

	public Integer getArtStock() {
        return artStock;
    }

	public void setArtStock(Integer artStock) {
        this.artStock = artStock;
    }

	public Date getArtDate() {
        return artDate;
    }

	public void setArtDate(Date artDate) {
        this.artDate = artDate;
    }


}
