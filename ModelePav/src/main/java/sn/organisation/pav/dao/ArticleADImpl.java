package sn.organisation.pav.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import org.springframework.beans.factory.annotation.Configurable;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import sn.organisation.pav.entite.Article;

@Repository
@Configurable
public class ArticleADImpl implements ArticleAD {
	
	@PersistenceContext
    transient EntityManager entityManager;

	public EntityManager entityManager() {
        return entityManager;
    }


	@Override
	public  long countArticles() {
        return entityManager().createQuery("SELECT COUNT(o) FROM Article o", Long.class).getSingleResult();
    }


	@Override
	public  List<Article> findAllArticles() {
        return entityManager().createQuery("SELECT o FROM Article o", Article.class).getResultList();
    }


	@Override
	public  Article findArticle(Integer artId) {
        if (artId == null) return null;
        return entityManager().find(Article.class, artId);
    }


	@Override
	public  List<Article> findArticleEntries(int firstResult, int maxResults) {
        return entityManager().createQuery("SELECT o FROM Article o", Article.class).setFirstResult(firstResult).setMaxResults(maxResults).getResultList();
    }


	@Override
	@Transactional
    public void persist(Article article) {
        if (this.entityManager == null) this.entityManager = entityManager();
        this.entityManager.persist(article);
    }

	@Override
	@Transactional
    public void remove(Article article) {
        if (this.entityManager == null) this.entityManager = entityManager();
        if (this.entityManager.contains(article)) {
            this.entityManager.remove(article);
        } else {
            Article articleNew = this.findArticle(article.getArtId());
            this.entityManager.remove(articleNew);
        }
    }

	@Override
	@Transactional
    public void flush() {
        if (this.entityManager == null) this.entityManager = entityManager();
        this.entityManager.flush();
    }


	@Override
	@Transactional
    public void clear() {
        if (this.entityManager == null) this.entityManager = entityManager();
        this.entityManager.clear();
    }


	@Override
	@Transactional
    public Article merge(Article article) {
        if (this.entityManager == null) this.entityManager = entityManager();
        Article merged = this.entityManager.merge(article);
        this.entityManager.flush();
        return merged;
    }
}
