package sn.organisation.pav.dao;

import java.util.List;

import org.springframework.transaction.annotation.Transactional;

import sn.organisation.pav.entite.Livraison;

public interface LivraisonAD {

	public abstract long countLivraisons();

	public abstract List<Livraison> findAllLivraisons();

	public abstract Livraison findLivraison(Integer livraisonId);

	public abstract List<Livraison> findLivraisonEntries(int firstResult,
			int maxResults);

	@Transactional
	public abstract void persist(Livraison livraison);

	@Transactional
	public abstract void remove(Livraison livraison);

	@Transactional
	public abstract void flush();

	@Transactional
	public abstract void clear();

	@Transactional
	public abstract Livraison merge(Livraison livraison);

}