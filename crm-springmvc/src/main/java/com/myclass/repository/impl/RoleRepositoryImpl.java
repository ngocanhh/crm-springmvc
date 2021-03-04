package com.myclass.repository.impl;

import java.util.ArrayList;
import java.util.List;

import javax.transaction.Transactional;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Repository;

import com.myclass.entity.Role;
import com.myclass.repository.RoleRepository;

@Repository
@Scope("prototype")
@Transactional(rollbackOn = Exception.class)
public class RoleRepositoryImpl implements RoleRepository {
	
	private SessionFactory sessionFactory;
	
	public RoleRepositoryImpl(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}
	
	@Override
	public List<Role> findAll() {
		List<Role> roles = new ArrayList<>();
		Session session = sessionFactory.getCurrentSession();
		Query<Role> query = session.createQuery("FROM Role", Role.class);
		roles = query.getResultList();
		return roles;
	}

	@Override
	public void saveOrUpdate(Role role) {
		Session session = sessionFactory.getCurrentSession();
		session.saveOrUpdate(role);
	}

	@Override
	public Role findById(int id) {
		Session session = sessionFactory.getCurrentSession();
		Role role = session.find(Role.class, id);
		return role;
	}

	@Override
	public void delete(int id) {
		Session session = sessionFactory.getCurrentSession();
		Role role = session.find(Role.class, id);
		session.remove(role);
	}

}
