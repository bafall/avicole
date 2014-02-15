package sn.organisation.pav.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import sn.organisation.pav.dao.ArticleAD;
import sn.organisation.pav.dao.EmployeAD;
import sn.organisation.pav.dao.RoleEmployeAD;
import sn.organisation.pav.entite.Article;
import sn.organisation.pav.entite.Employe;
import sn.organisation.pav.entite.RoleEmploye;
import sn.organisation.pav.entite.RoleEmployePK;

@Service("serviceCommande")
public class ServiceCommandeImpl implements ServiceCommande {

	@Autowired
	EmployeAD daoEmploye;
	@Autowired
	RoleEmployeAD daoRole;
	@Autowired
	ArticleAD daoArticle;
	
	@Override
	@Transactional
	public void ajouterEmploye(Employe employe){
		daoEmploye.persist(employe);
	}
	
	@Override
	@Transactional
	public void supprimerEmploye(Employe employe){
		daoEmploye.remove(employe);
	}
	
	@Override
	@Transactional
	public Employe modifierEmploye(Employe employe){
		return daoEmploye.merge(employe);
	}
	
	@Override
	@Transactional
	public Employe obtenirEmployeParId(String codeEmploye){
		return daoEmploye.findEmploye(codeEmploye);
	}
	
	
	
	@Override
	@Transactional
	public void ajouterRole(RoleEmploye role){
		daoRole.persist(role);
	}
	
	@Override
	@Transactional
	public void supprimerRole(RoleEmploye role){
		daoRole.remove(role);
	}
	
	@Override
	@Transactional
	public RoleEmploye modifierRole(RoleEmploye role){
		return daoRole.merge(role);
	}
	
	@Override
	@Transactional
	public RoleEmploye obtenirRoleParId(RoleEmployePK id){
		return daoRole.findRoleEmploye(id);
	}

	@Override
	@Transactional
	public List<Article> getListeArticles() {
		return daoArticle.findAllArticles();
	}

	@Override
	@Transactional
	public Article modifierArticle(Article article) {
		return daoArticle.merge(article);
	}
	
	
}
