package sn.organisation.pav.service;

import java.util.List;

import org.springframework.transaction.annotation.Transactional;

import sn.organisation.pav.entite.Article;
import sn.organisation.pav.entite.Employe;
import sn.organisation.pav.entite.RoleEmploye;
import sn.organisation.pav.entite.RoleEmployePK;

public interface ServiceCommande {

	@Transactional
	void ajouterEmploye(Employe employe);

	@Transactional
	void supprimerEmploye(Employe employe);

	@Transactional
	Employe modifierEmploye(Employe employe);

	@Transactional
	Employe obtenirEmployeParId(String codeEmploye);

	@Transactional
	void ajouterRole(RoleEmploye role);

	@Transactional
	void supprimerRole(RoleEmploye role);

	@Transactional
	RoleEmploye modifierRole(RoleEmploye role);

	@Transactional
	RoleEmploye obtenirRoleParId(RoleEmployePK id);
	
	@Transactional
	List<Article> getListeArticles();
	
	@Transactional
	Article modifierArticle(Article article);

}