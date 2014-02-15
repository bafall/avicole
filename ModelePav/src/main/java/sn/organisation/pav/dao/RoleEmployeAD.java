package sn.organisation.pav.dao;

import java.util.List;

import org.springframework.transaction.annotation.Transactional;

import sn.organisation.pav.entite.RoleEmploye;
import sn.organisation.pav.entite.RoleEmployePK;

public interface RoleEmployeAD {

	public abstract long countRoleEmployes();

	public abstract List<RoleEmploye> findAllRoleEmployes();

	public abstract RoleEmploye findRoleEmploye(RoleEmployePK id);

	public abstract List<RoleEmploye> findRoleEmployeEntries(int firstResult,
			int maxResults);

	@Transactional
	public abstract void persist(RoleEmploye roleEmploye);

	@Transactional
	public abstract void remove(RoleEmploye roleEmploye);

	@Transactional
	public abstract void flush();

	@Transactional
	public abstract void clear();

	@Transactional
	public abstract RoleEmploye merge(RoleEmploye roleEmploye);

}