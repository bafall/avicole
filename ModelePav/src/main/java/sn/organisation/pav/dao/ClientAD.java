package sn.organisation.pav.dao;

import java.util.List;

import org.springframework.transaction.annotation.Transactional;

import sn.organisation.pav.entite.Client;

public interface ClientAD {

	public abstract long countClients();

	public abstract List<Client> findAllClients();

	public abstract Client findClient(String clientCodeUti);

	public abstract List<Client> findClientEntries(int firstResult,
			int maxResults);

	@Transactional
	public abstract void persist(Client client);

	@Transactional
	public abstract void remove(Client client);

	@Transactional
	public abstract void flush();

	@Transactional
	public abstract void clear();

	@Transactional
	public abstract Client merge(Client client);

}