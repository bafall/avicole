package sn.organisation.pav.dao;

import java.util.List;

import org.springframework.transaction.annotation.Transactional;

import sn.organisation.pav.entite.Commande;

public interface CommandeAD {

	public abstract long countCommandes();

	public abstract List<Commande> findAllCommandes();

	public abstract Commande findCommande(Integer cmdId);

	public abstract List<Commande> findCommandeEntries(int firstResult,
			int maxResults);

	@Transactional
	public abstract void persist(Commande commande);

	@Transactional
	public abstract void remove(Commande commande);

	@Transactional
	public abstract void flush();

	@Transactional
	public abstract void clear();

	@Transactional
	public abstract Commande merge(Commande commande);

}