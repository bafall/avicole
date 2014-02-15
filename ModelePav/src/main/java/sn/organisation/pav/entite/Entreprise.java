package sn.organisation.pav.entite;
import java.util.Set;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import org.apache.commons.lang3.builder.ReflectionToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import org.springframework.beans.factory.annotation.Configurable;


@Configurable
@Entity
@Table(name = "entreprise")
public class Entreprise {

    public String toString() {
        return new ReflectionToStringBuilder(this, ToStringStyle.SHORT_PREFIX_STYLE).setExcludeFieldNames("clients").toString();
    }

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "ENTREPRISE_ID")
    private Integer entrepriseId;

    public Integer getEntrepriseId() {
        return this.entrepriseId;
    }

    public void setEntrepriseId(Integer id) {
        this.entrepriseId = id;
    }

    @OneToMany(mappedBy = "entrepriseId")
    private Set<Client> clients;

    @Column(name = "ENTREPRISE_NOM", length = 200)
    @NotNull
    private String entrepriseNom;

    @Column(name = "ENTREPRISE_NOTES", length = 500)
    private String entrepriseNotes;

    @Column(name = "ENTREPRISE_CODE_FID", length = 45)
    private String entrepriseCodeFid;

    public Set<Client> getClients() {
        return clients;
    }

    public void setClients(Set<Client> clients) {
        this.clients = clients;
    }

    public String getEntrepriseNom() {
        return entrepriseNom;
    }

    public void setEntrepriseNom(String entrepriseNom) {
        this.entrepriseNom = entrepriseNom;
    }

    public String getEntrepriseNotes() {
        return entrepriseNotes;
    }

    public void setEntrepriseNotes(String entrepriseNotes) {
        this.entrepriseNotes = entrepriseNotes;
    }

    public String getEntrepriseCodeFid() {
        return entrepriseCodeFid;
    }

    public void setEntrepriseCodeFid(String entrepriseCodeFid) {
        this.entrepriseCodeFid = entrepriseCodeFid;
    }
}
