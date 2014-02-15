package sn.organisation.pav.dao;

import java.util.List;

import org.springframework.transaction.annotation.Transactional;

import sn.organisation.pav.entite.Article;

public interface ArticleAD {

	public abstract long countArticles();

	public abstract List<Article> findAllArticles();

	public abstract Article findArticle(Integer artId);

	public abstract List<Article> findArticleEntries(int firstResult,
			int maxResults);

	@Transactional
	public abstract void persist(Article article);

	@Transactional
	public abstract void remove(Article article);

	@Transactional
	public abstract void flush();

	@Transactional
	public abstract void clear();

	@Transactional
	public abstract Article merge(Article article);

}