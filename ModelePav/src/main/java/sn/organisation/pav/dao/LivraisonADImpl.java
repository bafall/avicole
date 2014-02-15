package sn.organisation.pav.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.beans.factory.annotation.Configurable;

import sn.organisation.pav.entite.Livraison;

@Repository
@Configurable
public class LivraisonADImpl implements LivraisonAD {

	@PersistenceContext
    transient EntityManager entityManager;

	public EntityManager entityManager() {
        return entityManager;
    }
	
	@Override
	public long countLivraisons() {
        return entityManager().createQuery("SELECT COUNT(o) FROM Livraison o", Long.class).getSingleResult();
    }

	@Override
	public List<Livraison> findAllLivraisons() {
        return entityManager().createQuery("SELECT o FROM Livraison o", Livraison.class).getResultList();
    }

	@Override
	public Livraison findLivraison(Integer livraisonId) {
        if (livraisonId == null) return null;
        return entityManager().find(Livraison.class, livraisonId);
    }

	@Override
	public List<Livraison> findLivraisonEntries(int firstResult, int maxResults) {
        return entityManager().createQuery("SELECT o FROM Livraison o", Livraison.class).setFirstResult(firstResult).setMaxResults(maxResults).getResultList();
    }

	@Override
	@Transactional
    public void persist(Livraison livraison) {
        if (this.entityManager == null) this.entityManager = entityManager();
        this.entityManager.persist(livraison);
    }

	@Override
	@Transactional
    public void remove(Livraison livraison) {
        if (this.entityManager == null) this.entityManager = entityManager();
        if (this.entityManager.contains(livraison)) {
            this.entityManager.remove(livraison);
        } else {
            Livraison attached = this.findLivraison(livraison.getLivraisonId());
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
    public Livraison merge(Livraison livraison) {
        if (this.entityManager == null) this.entityManager = entityManager();
        Livraison merged = this.entityManager.merge(livraison);
        this.entityManager.flush();
        return merged;
    }
}
