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
@Table(name = "commande")
public class Commande {

    @OneToMany(mappedBy = "cmdId")
    private Set<LigneCommande> ligneCommandes;

    @OneToMany(mappedBy = "cmdId")
    private Set<Livraison> livraisons;

    @ManyToOne
    @JoinColumn(name = "CLIENT_CODE_UTI", referencedColumnName = "CLIENT_CODE_UTI", nullable = false)
    private Client clientCodeUti;

    @Column(name = "CMD_NO", length = 30)
    @NotNull
    private String cmdNo;

    @Column(name = "CMD_DATE_CREAT")
    @NotNull
    @Temporal(TemporalType.DATE)
    @DateTimeFormat(style = "M-")
    private Date cmdDateCreat;

    @Column(name = "CMD_DATE_MODIF")
    @Temporal(TemporalType.DATE)
    @DateTimeFormat(style = "M-")
    private Date cmdDateModif;

    @Column(name = "CMD_POIDS_TOTAL")
    private Double cmdPoidsTotal;

    @Column(name = "CMD_ETAT", length = 3)
    @NotNull
    private String cmdEtat;

    @Column(name = "CMD_PRIX_TOTAL")
    private Double cmdPrixTotal;

    @Column(name = "CMD_NOTES", length = 500)
    private String cmdNotes;

    public Set<LigneCommande> getLigneCommandes() {
        return ligneCommandes;
    }

    public void setLigneCommandes(Set<LigneCommande> ligneCommandes) {
        this.ligneCommandes = ligneCommandes;
    }

    public Set<Livraison> getLivraisons() {
        return livraisons;
    }

    public void setLivraisons(Set<Livraison> livraisons) {
        this.livraisons = livraisons;
    }

    public Client getClientCodeUti() {
        return clientCodeUti;
    }

    public void setClientCodeUti(Client clientCodeUti) {
        this.clientCodeUti = clientCodeUti;
    }

    public String getCmdNo() {
        return cmdNo;
    }

    public void setCmdNo(String cmdNo) {
        this.cmdNo = cmdNo;
    }

    public Date getCmdDateCreat() {
        return cmdDateCreat;
    }

    public void setCmdDateCreat(Date cmdDateCreat) {
        this.cmdDateCreat = cmdDateCreat;
    }

    public Date getCmdDateModif() {
        return cmdDateModif;
    }

    public void setCmdDateModif(Date cmdDateModif) {
        this.cmdDateModif = cmdDateModif;
    }

    public Double getCmdPoidsTotal() {
        return cmdPoidsTotal;
    }

    public void setCmdPoidsTotal(Double cmdPoidsTotal) {
        this.cmdPoidsTotal = cmdPoidsTotal;
    }

    public String getCmdEtat() {
        return cmdEtat;
    }

    public void setCmdEtat(String cmdEtat) {
        this.cmdEtat = cmdEtat;
    }

    public Double getCmdPrixTotal() {
        return cmdPrixTotal;
    }

    public void setCmdPrixTotal(Double cmdPrixTotal) {
        this.cmdPrixTotal = cmdPrixTotal;
    }

    public String getCmdNotes() {
        return cmdNotes;
    }

    public void setCmdNotes(String cmdNotes) {
        this.cmdNotes = cmdNotes;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "CMD_ID")
    private Integer cmdId;

    public Integer getCmdId() {
        return this.cmdId;
    }

    public void setCmdId(Integer id) {
        this.cmdId = id;
    }

    public String toString() {
        return new ReflectionToStringBuilder(this, ToStringStyle.SHORT_PREFIX_STYLE).setExcludeFieldNames("ligneCommandes", "livraisons", "clientCodeUti").toString();
    }
}
