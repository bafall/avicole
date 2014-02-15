package sn.organisation.pav.dao;

import java.util.List;

import org.springframework.transaction.annotation.Transactional;

import sn.organisation.pav.entite.LigneCommande;

public interface LigneCommandeAD {

	public abstract long countLigneCommandes();

	public abstract List<LigneCommande> findAllLigneCommandes();

	public abstract LigneCommande findLigneCommande(Integer ligneCmdId);

	public abstract List<LigneCommande> findLigneCommandeEntries(
			int firstResult, int maxResults);

	@Transactional
	public abstract void persist(LigneCommande ligneCommande);

	@Transactional
	public abstract void remove(LigneCommande ligneCommande);

	@Transactional
	public abstract void flush();

	@Transactional
	public abstract void clear();

	@Transactional
	public abstract LigneCommande merge(LigneCommande ligneCommande);

}