package sn.organisation.pav.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import org.springframework.beans.factory.annotation.Configurable;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import sn.organisation.pav.entite.Client;

@Repository
@Configurable
public class ClientADImpl implements ClientAD {
	
	@PersistenceContext
    transient EntityManager entityManager;

	public EntityManager entityManager() {
        return entityManager;
    }
	
	@Override
	public long countClients() {
        return entityManager().createQuery("SELECT COUNT(o) FROM Client o", Long.class).getSingleResult();
    }

	@Override
	public List<Client> findAllClients() {
        return entityManager().createQuery("SELECT o FROM Client o", Client.class).getResultList();
    }

	@Override
	public Client findClient(String clientCodeUti) {
        if (clientCodeUti == null || clientCodeUti.length() == 0) return null;
        return entityManager().find(Client.class, clientCodeUti);
    }

	@Override
	public List<Client> findClientEntries(int firstResult, int maxResults) {
        return entityManager().createQuery("SELECT o FROM Client o", Client.class).setFirstResult(firstResult).setMaxResults(maxResults).getResultList();
    }

	@Override
	@Transactional
    public void persist(Client client) {
        if (this.entityManager == null) this.entityManager = entityManager();
        this.entityManager.persist(client);
    }

	@Override
	@Transactional
    public void remove(Client client) {
        if (this.entityManager == null) this.entityManager = entityManager();
        if (this.entityManager.contains(client)) {
            this.entityManager.remove(client);
        } else {
            Client attached = this.findClient(client.getClientCodeUti());
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
    public Client merge(Client client) {
        if (this.entityManager == null) this.entityManager = entityManager();
        Client merged = this.entityManager.merge(client);
        this.entityManager.flush();
        return merged;
    }


}
