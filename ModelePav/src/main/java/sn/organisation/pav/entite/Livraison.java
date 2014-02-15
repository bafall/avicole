package sn.organisation.pav.entite;
import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import org.apache.commons.lang3.builder.ReflectionToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import org.springframework.beans.factory.annotation.Configurable;
import org.springframework.format.annotation.DateTimeFormat;


@Entity
@Table(name = "livraison")
@Configurable
public class Livraison {



	public String toString() {
        return new ReflectionToStringBuilder(this, ToStringStyle.SHORT_PREFIX_STYLE).setExcludeFieldNames("cmdId").toString();
    }

	@Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "LIVRAISON_ID")
    private Integer livraisonId;

	public Integer getLivraisonId() {
        return this.livraisonId;
    }

	public void setLivraisonId(Integer id) {
        this.livraisonId = id;
    }

	@ManyToOne
    @JoinColumn(name = "CMD_ID", referencedColumnName = "CMD_ID", nullable = false)
    private Commande cmdId;

	@Column(name = "LIVRAISON_MODE", length = 45)
    @NotNull
    private String livraisonMode;

	@Column(name = "LIVRAISON_DATE")
    @Temporal(TemporalType.DATE)
    @DateTimeFormat(style = "M-")
    private Date livraisonDate;

	@Column(name = "LIVRAISON_COMPLEMENT_DATE", length = 45)
    private String livraisonComplementDate;

	@Column(name = "LIVRAISON_FRAIS")
    private Double livraisonFrais;

	@Column(name = "LIVRAISON_ADR", length = 300)
    private String livraisonAdr;

	@Column(name = "MAGASIN_ADR", length = 300)
    private String magasinAdr;

	public Commande getCmdId() {
        return cmdId;
    }

	public void setCmdId(Commande cmdId) {
        this.cmdId = cmdId;
    }

	public String getLivraisonMode() {
        return livraisonMode;
    }

	public void setLivraisonMode(String livraisonMode) {
        this.livraisonMode = livraisonMode;
    }

	public Date getLivraisonDate() {
        return livraisonDate;
    }

	public void setLivraisonDate(Date livraisonDate) {
        this.livraisonDate = livraisonDate;
    }

	public String getLivraisonComplementDate() {
        return livraisonComplementDate;
    }

	public void setLivraisonComplementDate(String livraisonComplementDate) {
        this.livraisonComplementDate = livraisonComplementDate;
    }

	public Double getLivraisonFrais() {
        return livraisonFrais;
    }

	public void setLivraisonFrais(Double livraisonFrais) {
        this.livraisonFrais = livraisonFrais;
    }

	public String getLivraisonAdr() {
        return livraisonAdr;
    }

	public void setLivraisonAdr(String livraisonAdr) {
        this.livraisonAdr = livraisonAdr;
    }

	public String getMagasinAdr() {
        return magasinAdr;
    }

	public void setMagasinAdr(String magasinAdr) {
        this.magasinAdr = magasinAdr;
    }
}
