package sn.organisation.pav.dao;

import java.util.List;

import org.springframework.transaction.annotation.Transactional;

import sn.organisation.pav.entite.Employe;

public interface EmployeAD {

	public abstract long countEmployes();

	public abstract List<Employe> findAllEmployes();

	public abstract Employe findEmploye(String codeEmploye);

	public abstract List<Employe> findEmployeEntries(int firstResult,
			int maxResults);

	@Transactional
	public abstract void persist(Employe employe);

	@Transactional
	public abstract void remove(Employe employe);

	@Transactional
	public abstract void flush();

	@Transactional
	public abstract void clear();

	@Transactional
	public abstract Employe merge(Employe employe);

}