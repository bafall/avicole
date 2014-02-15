package sn.organisation.pav.entite;
import java.util.Date;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import org.apache.commons.lang3.builder.ReflectionToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import org.springframework.beans.factory.annotation.Configurable;
import org.springframework.format.annotation.DateTimeFormat;


@Configurable
@Entity
@Table(name = "role_employe")
public class RoleEmploye {

	public String toString() {
        return new ReflectionToStringBuilder(this, ToStringStyle.SHORT_PREFIX_STYLE).setExcludeFieldNames("codeEmploye").toString();
    }

	@ManyToOne
    @JoinColumn(name = "CODE_EMPLOYE", referencedColumnName = "CODE_EMPLOYE", nullable = false, insertable = false, updatable = false)
    private Employe codeEmploye;

	@Column(name = "DATE_DEBUT_ACTIVITE")
    @Temporal(TemporalType.DATE)
    @DateTimeFormat(style = "M-")
    private Date dateDebutActivite;

	@Column(name = "DATE_FIN_ACTIVITE")
    @Temporal(TemporalType.DATE)
    @DateTimeFormat(style = "M-")
    private Date dateFinActivite;

	@Column(name = "DESC_PERIODE_ACTIVITE", length = 500)
    private String descPeriodeActivite;

	@Column(name = "CREE_PAR", length = 50)
    private String creePar;

	@Column(name = "DATE_CREATION")
    @Temporal(TemporalType.DATE)
    @DateTimeFormat(style = "M-")
    private Date dateCreation;

	@Column(name = "MODIFIE_PAR", length = 50)
    private String modifiePar;

	@Column(name = "DATE_MODIFICATION")
    @Temporal(TemporalType.DATE)
    @DateTimeFormat(style = "M-")
    private Date dateModification;

	public Employe getCodeEmploye() {
        return codeEmploye;
    }

	public void setCodeEmploye(Employe codeEmploye) {
        this.codeEmploye = codeEmploye;
    }

	public Date getDateDebutActivite() {
        return dateDebutActivite;
    }

	public void setDateDebutActivite(Date dateDebutActivite) {
        this.dateDebutActivite = dateDebutActivite;
    }

	public Date getDateFinActivite() {
        return dateFinActivite;
    }

	public void setDateFinActivite(Date dateFinActivite) {
        this.dateFinActivite = dateFinActivite;
    }

	public String getDescPeriodeActivite() {
        return descPeriodeActivite;
    }

	public void setDescPeriodeActivite(String descPeriodeActivite) {
        this.descPeriodeActivite = descPeriodeActivite;
    }

	public String getCreePar() {
        return creePar;
    }

	public void setCreePar(String creePar) {
        this.creePar = creePar;
    }

	public Date getDateCreation() {
        return dateCreation;
    }

	public void setDateCreation(Date dateCreation) {
        this.dateCreation = dateCreation;
    }

	public String getModifiePar() {
        return modifiePar;
    }

	public void setModifiePar(String modifiePar) {
        this.modifiePar = modifiePar;
    }

	public Date getDateModification() {
        return dateModification;
    }

	public void setDateModification(Date dateModification) {
        this.dateModification = dateModification;
    }

	@EmbeddedId
    private RoleEmployePK id;

	public RoleEmployePK getId() {
        return this.id;
    }

	public void setId(RoleEmployePK id) {
        this.id = id;
    }



}
