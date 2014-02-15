package sn.organisation.pav.entite;
import java.util.Set;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import org.apache.commons.lang3.builder.ReflectionToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import org.springframework.beans.factory.annotation.Configurable;


@Entity
@Table(name = "employe")
@Configurable
public class Employe {

    @OneToMany(mappedBy = "codeEmploye")
    private Set<RoleEmploye> roleEmployes;

    @Column(name = "MOT_PASSE", length = 100)
    private String motPasse;
    
    @Column(name = "CONFIRMATION_MOT_PASSE", length = 100)
    private String confirmationMotPasse;



	@Column(name = "NOM", length = 100)
    @NotNull
    private String nom;

    @Column(name = "PRENOM", length = 100)
    @NotNull
    private String prenom;

    @Column(name = "COURRIEL", length = 200)
    private String courriel;

    @Column(name = "CODE_STATUT", length = 2)
    private String codeStatut;
    
    @Column(name = "CODE_SEXE", length = 3)
    @NotNull
    private String codeSexe;

    public String getCodeSexe() {
		return codeSexe;
	}

	public void setCodeSexe(String codeSexe) {
		this.codeSexe = codeSexe;
	}

	public Set<RoleEmploye> getRoleEmployes() {
        return roleEmployes;
    }

    public void setRoleEmployes(Set<RoleEmploye> roleEmployes) {
        this.roleEmployes = roleEmployes;
    }

    public String getMotPasse() {
        return motPasse;
    }

    public void setMotPasse(String motPasse) {
        this.motPasse = motPasse;
    }
    
    public String getConfirmationMotPasse() {
		return confirmationMotPasse;
	}

	public void setConfirmationMotPasse(String confirmationMotPasse) {
		this.confirmationMotPasse = confirmationMotPasse;
	}

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getPrenom() {
        return prenom;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    public String getCourriel() {
        return courriel;
    }

    public void setCourriel(String courriel) {
        this.courriel = courriel;
    }

    public String getCodeStatut() {
        return codeStatut;
    }

    public void setCodeStatut(String codeStatut) {
        this.codeStatut = codeStatut;
    }

    @Id
    //@GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "CODE_EMPLOYE", length = 100)
    private String codeEmploye;

    public String getCodeEmploye() {
        return this.codeEmploye;
    }

    public void setCodeEmploye(String id) {
        this.codeEmploye = id;
    }

    public String toString() {
        return new ReflectionToStringBuilder(this, ToStringStyle.SHORT_PREFIX_STYLE).setExcludeFieldNames("roleEmployes").toString();
    }
}
