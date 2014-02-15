package sn.organisation.pav.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.beans.factory.annotation.Configurable;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import sn.organisation.pav.entite.RoleEmploye;
import sn.organisation.pav.entite.RoleEmployePK;

@Repository
@Configurable
public class RoleEmployeADImpl implements RoleEmployeAD {

	@PersistenceContext
    transient EntityManager entityManager;

	public EntityManager entityManager() {
        return entityManager;
    }
	

	@Override
	public long countRoleEmployes() {
        return entityManager().createQuery("SELECT COUNT(o) FROM RoleEmploye o", Long.class).getSingleResult();
    }

	@Override
	public List<RoleEmploye> findAllRoleEmployes() {
        return entityManager().createQuery("SELECT o FROM RoleEmploye o", RoleEmploye.class).getResultList();
    }

	@Override
	public RoleEmploye findRoleEmploye(RoleEmployePK id) {
        if (id == null) return null;
        return entityManager().find(RoleEmploye.class, id);
    }

	@Override
	public List<RoleEmploye> findRoleEmployeEntries(int firstResult, int maxResults) {
        return entityManager().createQuery("SELECT o FROM RoleEmploye o", RoleEmploye.class).setFirstResult(firstResult).setMaxResults(maxResults).getResultList();
    }

	@Override
	@Transactional
    public void persist(RoleEmploye roleEmploye) {
        if (this.entityManager == null) this.entityManager = entityManager();
        this.entityManager.persist(roleEmploye);
    }

	@Override
	@Transactional
    public void remove(RoleEmploye roleEmploye) {
        if (this.entityManager == null) this.entityManager = entityManager();
        if (this.entityManager.contains(roleEmploye)) {
            this.entityManager.remove(roleEmploye);
        } else {
            RoleEmploye attached = this.findRoleEmploye(roleEmploye.getId());
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
    public RoleEmploye merge(RoleEmploye roleEmploye) {
        if (this.entityManager == null) this.entityManager = entityManager();
        RoleEmploye merged = this.entityManager.merge(roleEmploye);
        this.entityManager.flush();
        return merged;
    }
}
