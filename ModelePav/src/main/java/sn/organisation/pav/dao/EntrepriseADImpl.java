package sn.organisation.pav.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.beans.factory.annotation.Configurable;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import sn.organisation.pav.entite.Entreprise;

@Repository
@Configurable
public class EntrepriseADImpl implements EntrepriseAD {

	@PersistenceContext
    transient EntityManager entityManager;

	public EntityManager entityManager() {
        return entityManager;
    }
	
    @Override
	public long countEntreprises() {
        return entityManager().createQuery("SELECT COUNT(o) FROM Entreprise o", Long.class).getSingleResult();
    }

    @Override
	public List<Entreprise> findAllEntreprises() {
        return entityManager().createQuery("SELECT o FROM Entreprise o", Entreprise.class).getResultList();
    }

    @Override
	public Entreprise findEntreprise(Integer entrepriseId) {
        if (entrepriseId == null) return null;
        return entityManager().find(Entreprise.class, entrepriseId);
    }

    @Override
	public List<Entreprise> findEntrepriseEntries(int firstResult, int maxResults) {
        return entityManager().createQuery("SELECT o FROM Entreprise o", Entreprise.class).setFirstResult(firstResult).setMaxResults(maxResults).getResultList();
    }

    @Override
	@Transactional
    public void persist(Entreprise entreprise) {
        if (this.entityManager == null) this.entityManager = entityManager();
        this.entityManager.persist(entreprise);
    }

    @Override
	@Transactional
    public void remove(Entreprise entreprise) {
        if (this.entityManager == null) this.entityManager = entityManager();
        if (this.entityManager.contains(entreprise)) {
            this.entityManager.remove(entreprise);
        } else {
            Entreprise attached = this.findEntreprise(entreprise.getEntrepriseId());
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
    public Entreprise merge(Entreprise entreprise) {
        if (this.entityManager == null) this.entityManager = entityManager();
        Entreprise merged = this.entityManager.merge(entreprise);
        this.entityManager.flush();
        return merged;
    }

}
