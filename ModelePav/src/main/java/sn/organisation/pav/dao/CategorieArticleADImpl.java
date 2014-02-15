package sn.organisation.pav.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import org.springframework.beans.factory.annotation.Configurable;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import sn.organisation.pav.entite.CategorieArticle;

@Repository
@Configurable
public class CategorieArticleADImpl implements CategorieArticleAD {

	@PersistenceContext
    transient EntityManager entityManager;

	public EntityManager entityManager() {
        return entityManager;
    }
	

	@Override
	public  long countCategorieArticles() {
        return entityManager().createQuery("SELECT COUNT(o) FROM CategorieArticle o", Long.class).getSingleResult();
    }

	@Override
	public  List<CategorieArticle> findAllCategorieArticles() {
        return entityManager().createQuery("SELECT o FROM CategorieArticle o", CategorieArticle.class).getResultList();
    }

	@Override
	public  CategorieArticle findCategorieArticle(String categCode) {
        if (categCode == null || categCode.length() == 0) return null;
        return entityManager().find(CategorieArticle.class, categCode);
    }

	@Override
	public  List<CategorieArticle> findCategorieArticleEntries(int firstResult, int maxResults) {
        return entityManager().createQuery("SELECT o FROM CategorieArticle o", CategorieArticle.class).setFirstResult(firstResult).setMaxResults(maxResults).getResultList();
    }

	@Override
	@Transactional
    public void persist(CategorieArticle categorieArticle) {
        if (this.entityManager == null) this.entityManager = entityManager();
        this.entityManager.persist(categorieArticle);
    }

	@Override
	@Transactional
    public void remove(CategorieArticle categorieArticle) {
        if (this.entityManager == null) this.entityManager = entityManager();
        if (this.entityManager.contains(categorieArticle)) {
            this.entityManager.remove(categorieArticle);
        } else {
            CategorieArticle attached = this.findCategorieArticle(categorieArticle.getCategCode());
            this.entityManager.remove(attached);
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
    public CategorieArticle merge(CategorieArticle categorieArticle) {
        if (this.entityManager == null) this.entityManager = entityManager();
        CategorieArticle merged = this.entityManager.merge(categorieArticle);
        this.entityManager.flush();
        return merged;
    }
}
