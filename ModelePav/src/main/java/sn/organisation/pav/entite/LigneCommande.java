package sn.organisation.pav.entite;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import org.apache.commons.lang3.builder.ReflectionToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import org.springframework.beans.factory.annotation.Configurable;

@Configurable
@Entity
@Table(name = "ligne_commande")
public class LigneCommande {

	@ManyToOne
    @JoinColumn(name = "ART_ID", referencedColumnName = "ART_ID", nullable = false)
    private Article artId;

	@ManyToOne
    @JoinColumn(name = "CMD_ID", referencedColumnName = "CMD_ID", nullable = false)
    private Commande cmdId;

	@Column(name = "QTE_ARTICLE")
    @NotNull
    private Integer qteArticle;

	@Column(name = "PRIX_UNITAIRE")
    @NotNull
    private Double prixUnitaire;

	public Article getArtId() {
        return artId;
    }

	public void setArtId(Article artId) {
        this.artId = artId;
    }

	public Commande getCmdId() {
        return cmdId;
    }

	public void setCmdId(Commande cmdId) {
        this.cmdId = cmdId;
    }

	public Integer getQteArticle() {
        return qteArticle;
    }

	public void setQteArticle(Integer qteArticle) {
        this.qteArticle = qteArticle;
    }

	public Double getPrixUnitaire() {
        return prixUnitaire;
    }

	public void setPrixUnitaire(Double prixUnitaire) {
        this.prixUnitaire = prixUnitaire;
    }

	public String toString() {
        return new ReflectionToStringBuilder(this, ToStringStyle.SHORT_PREFIX_STYLE).setExcludeFieldNames("artId", "cmdId").toString();
    }




	@Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "LIGNE_CMD_ID")
    private Integer ligneCmdId;

	public Integer getLigneCmdId() {
        return this.ligneCmdId;
    }

	public void setLigneCmdId(Integer id) {
        this.ligneCmdId = id;
    }
}
