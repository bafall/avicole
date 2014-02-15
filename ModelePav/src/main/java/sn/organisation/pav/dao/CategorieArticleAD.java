package sn.organisation.pav.dao;

import java.util.List;

import org.springframework.transaction.annotation.Transactional;

import sn.organisation.pav.entite.CategorieArticle;

public interface CategorieArticleAD {

	public abstract long countCategorieArticles();

	public abstract List<CategorieArticle> findAllCategorieArticles();

	public abstract CategorieArticle findCategorieArticle(String categCode);

	public abstract List<CategorieArticle> findCategorieArticleEntries(
			int firstResult, int maxResults);

	@Transactional
	public abstract void persist(CategorieArticle categorieArticle);

	@Transactional
	public abstract void remove(CategorieArticle categorieArticle);

	@Transactional
	public abstract void flush();

	@Transactional
	public abstract void clear();

	@Transactional
	public abstract CategorieArticle merge(CategorieArticle categorieArticle);

}