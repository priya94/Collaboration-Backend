package com.niit.collaborationwebsite.DAOImpl;

import java.util.List;

import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;


import com.niit.collaborationwebsite.DAO.RoleDAO;
import com.niit.collaborationwebsite.model.Role;

@Repository("roleDAO")
public class RoleDAOImpl implements RoleDAO{

	@Autowired
	SessionFactory sessionFactory;
	
	public RoleDAOImpl(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	@Transactional
	public void saveOrUpdateRole(Role role) {
		sessionFactory.getCurrentSession().saveOrUpdate(role);

	}
	
	@Transactional
	public void deleteRole(String Id) {
		Role roleToDelete = new Role();
		roleToDelete.setId(Id);
		sessionFactory.getCurrentSession().delete(roleToDelete);

	}
	
	@Transactional
	public Role getRole(String Id) {
		String hql = "from Role where Id=:Id";
		Query query = sessionFactory.getCurrentSession().createQuery(hql).setParameter("Id", Id);
		List<Role> gotRole = query.getResultList();
		if (gotRole != null && !gotRole.isEmpty())
			return gotRole.get(0);
		return null;
}
	
	@Transactional
	public List<Role> listRoles() {
		String hql = "from Role";
		Query query = sessionFactory.getCurrentSession().createQuery(hql);
		List<Role> listOfRoles = query.getResultList();
		return listOfRoles;
	}
	
}
