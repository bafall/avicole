package sn.organisation.pav.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.beans.factory.annotation.Configurable;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import sn.organisation.pav.entite.Commande;

@Repository
@Configurable
public class CommandeADImpl implements CommandeAD {

	@PersistenceContext
    transient EntityManager entityManager;

	public EntityManager entityManager() {
        return entityManager;
    }
	
	@Override
	public long countCommandes() {
        return entityManager().createQuery("SELECT COUNT(o) FROM Commande o", Long.class).getSingleResult();
    }

	@Override
	public List<Commande> findAllCommandes() {
        return entityManager().createQuery("SELECT o FROM Commande o", Commande.class).getResultList();
    }

	@Override
	public Commande findCommande(Integer cmdId) {
        if (cmdId == null) return null;
        return entityManager().find(Commande.class, cmdId);
    }

	@Override
	public List<Commande> findCommandeEntries(int firstResult, int maxResults) {
        return entityManager().createQuery("SELECT o FROM Commande o", Commande.class).setFirstResult(firstResult).setMaxResults(maxResults).getResultList();
    }

	@Override
	@Transactional
    public void persist(Commande commande) {
        if (this.entityManager == null) this.entityManager = entityManager();
        this.entityManager.persist(commande);
    }

	@Override
	@Transactional
    public void remove(Commande commande) {
        if (this.entityManager == null) this.entityManager = entityManager();
        if (this.entityManager.contains(commande)) {
            this.entityManager.remove(commande);
        } else {
            Commande attached = this.findCommande(commande.getCmdId());
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
    public Commande merge(Commande commande) {
        if (this.entityManager == null) this.entityManager = entityManager();
        Commande merged = this.entityManager.merge(commande);
        this.entityManager.flush();
        return merged;
    }
}
