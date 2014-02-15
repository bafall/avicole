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
@Table(name = "categorie_article")
public class CategorieArticle {

	public String toString() {
        return new ReflectionToStringBuilder(this, ToStringStyle.SHORT_PREFIX_STYLE).setExcludeFieldNames("articles").toString();
    }

	@OneToMany(mappedBy = "categCode")
    private Set<Article> articles;

	@Column(name = "CATEG_NOM", length = 100)
    @NotNull
    private String categNom;

	public Set<Article> getArticles() {
        return articles;
    }

	public void setArticles(Set<Article> articles) {
        this.articles = articles;
    }

	public String getCategNom() {
        return categNom;
    }

	public void setCategNom(String categNom) {
        this.categNom = categNom;
    }

	@Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "CATEG_CODE", length = 5)
    private String categCode;

	public String getCategCode() {
        return this.categCode;
    }

	public void setCategCode(String id) {
        this.categCode = id;
    }



}
