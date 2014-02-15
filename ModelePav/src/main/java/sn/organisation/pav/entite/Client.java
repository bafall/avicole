package sn.organisation.pav.entite;
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
import javax.validation.constraints.NotNull;
import org.apache.commons.lang3.builder.ReflectionToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import org.springframework.beans.factory.annotation.Configurable;


@Configurable
@Entity
@Table(name = "client")
public class Client {

    public String toString() {
        return new ReflectionToStringBuilder(this, ToStringStyle.SHORT_PREFIX_STYLE).setExcludeFieldNames("commandes", "entrepriseId").toString();
    }

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "CLIENT_CODE_UTI", length = 100)
    private String clientCodeUti;

    public String getClientCodeUti() {
        return this.clientCodeUti;
    }

    public void setClientCodeUti(String id) {
        this.clientCodeUti = id;
    }

    @OneToMany(mappedBy = "clientCodeUti")
    private Set<Commande> commandes;

    @ManyToOne
    @JoinColumn(name = "ENTREPRISE_ID", referencedColumnName = "ENTREPRISE_ID")
    private Entreprise entrepriseId;

    @Column(name = "CLIENT_MOT_PASSE", length = 100)
    @NotNull
    private String clientMotPasse;

    @Column(name = "CLIENT_NOM", length = 100)
    @NotNull
    private String clientNom;

    @Column(name = "CLIENT_PRENOM", length = 100)
    @NotNull
    private String clientPrenom;

    @Column(name = "CLIENT_COURRIEL", length = 100)
    @NotNull
    private String clientCourriel;

    @Column(name = "CLIENT_TELEPHONE", length = 15)
    private String clientTelephone;

    @Column(name = "CLIENT_ADR_LIGNE1", length = 200)
    @NotNull
    private String clientAdrLigne1;

    @Column(name = "CLIENT_ADR_LIGNE2", length = 200)
    private String clientAdrLigne2;

    @Column(name = "CLIENT_VILLE", length = 45)
    @NotNull
    private String clientVille;

    @Column(name = "CLIENT_CODE_ZIP", length = 10)
    private String clientCodeZip;

    @Column(name = "CLIENT_PROVINCE", length = 45)
    private String clientProvince;

    @Column(name = "CLIENT_PAYS", length = 45)
    @NotNull
    private String clientPays;

    public Set<Commande> getCommandes() {
        return commandes;
    }

    public void setCommandes(Set<Commande> commandes) {
        this.commandes = commandes;
    }

    public Entreprise getEntrepriseId() {
        return entrepriseId;
    }

    public void setEntrepriseId(Entreprise entrepriseId) {
        this.entrepriseId = entrepriseId;
    }

    public String getClientMotPasse() {
        return clientMotPasse;
    }

    public void setClientMotPasse(String clientMotPasse) {
        this.clientMotPasse = clientMotPasse;
    }

    public String getClientNom() {
        return clientNom;
    }

    public void setClientNom(String clientNom) {
        this.clientNom = clientNom;
    }

    public String getClientPrenom() {
        return clientPrenom;
    }

    public void setClientPrenom(String clientPrenom) {
        this.clientPrenom = clientPrenom;
    }

    public String getClientCourriel() {
        return clientCourriel;
    }

    public void setClientCourriel(String clientCourriel) {
        this.clientCourriel = clientCourriel;
    }

    public String getClientTelephone() {
        return clientTelephone;
    }

    public void setClientTelephone(String clientTelephone) {
        this.clientTelephone = clientTelephone;
    }

    public String getClientAdrLigne1() {
        return clientAdrLigne1;
    }

    public void setClientAdrLigne1(String clientAdrLigne1) {
        this.clientAdrLigne1 = clientAdrLigne1;
    }

    public String getClientAdrLigne2() {
        return clientAdrLigne2;
    }

    public void setClientAdrLigne2(String clientAdrLigne2) {
        this.clientAdrLigne2 = clientAdrLigne2;
    }

    public String getClientVille() {
        return clientVille;
    }

    public void setClientVille(String clientVille) {
        this.clientVille = clientVille;
    }

    public String getClientCodeZip() {
        return clientCodeZip;
    }

    public void setClientCodeZip(String clientCodeZip) {
        this.clientCodeZip = clientCodeZip;
    }

    public String getClientProvince() {
        return clientProvince;
    }

    public void setClientProvince(String clientProvince) {
        this.clientProvince = clientProvince;
    }

    public String getClientPays() {
        return clientPays;
    }

    public void setClientPays(String clientPays) {
        this.clientPays = clientPays;
    }
}
