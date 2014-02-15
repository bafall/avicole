package sn.organisation.pav.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.beans.factory.annotation.Configurable;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import sn.organisation.pav.entite.LigneCommande;

@Repository
@Configurable
public class LigneCommandeADImpl implements LigneCommandeAD {

	@PersistenceContext
    transient EntityManager entityManager;

	public EntityManager entityManager() {
        return entityManager;
    }
	
	@Override
	public long countLigneCommandes() {
        return entityManager().createQuery("SELECT COUNT(o) FROM LigneCommande o", Long.class).getSingleResult();
    }

	@Override
	public List<LigneCommande> findAllLigneCommandes() {
        return entityManager().createQuery("SELECT o FROM LigneCommande o", LigneCommande.class).getResultList();
    }

	@Override
	public LigneCommande findLigneCommande(Integer ligneCmdId) {
        if (ligneCmdId == null) return null;
        return entityManager().find(LigneCommande.class, ligneCmdId);
    }

	@Override
	public List<LigneCommande> findLigneCommandeEntries(int firstResult, int maxResults) {
        return entityManager().createQuery("SELECT o FROM LigneCommande o", LigneCommande.class).setFirstResult(firstResult).setMaxResults(maxResults).getResultList();
    }

	@Override
	@Transactional
    public void persist(LigneCommande ligneCommande) {
        if (this.entityManager == null) this.entityManager = entityManager();
        this.entityManager.persist(ligneCommande);
    }

	@Override
	@Transactional
    public void remove(LigneCommande ligneCommande) {
        if (this.entityManager == null) this.entityManager = entityManager();
        if (this.entityManager.contains(ligneCommande)) {
            this.entityManager.remove(ligneCommande);
        } else {
            LigneCommande attached = this.findLigneCommande(ligneCommande.getLigneCmdId());
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
    public LigneCommande merge(LigneCommande ligneCommande) {
        if (this.entityManager == null) this.entityManager = entityManager();
        LigneCommande merged = this.entityManager.merge(ligneCommande);
        this.entityManager.flush();
        return merged;
    }
}
