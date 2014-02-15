package sn.organisation.pav.dao;

import java.util.List;

import org.springframework.transaction.annotation.Transactional;

import sn.organisation.pav.entite.Entreprise;

public interface EntrepriseAD {

	public abstract long countEntreprises();

	public abstract List<Entreprise> findAllEntreprises();

	public abstract Entreprise findEntreprise(Integer entrepriseId);

	public abstract List<Entreprise> findEntrepriseEntries(int firstResult,
			int maxResults);

	@Transactional
	public abstract void persist(Entreprise entreprise);

	@Transactional
	public abstract void remove(Entreprise entreprise);

	@Transactional
	public abstract void flush();

	@Transactional
	public abstract void clear();

	@Transactional
	public abstract Entreprise merge(Entreprise entreprise);

}