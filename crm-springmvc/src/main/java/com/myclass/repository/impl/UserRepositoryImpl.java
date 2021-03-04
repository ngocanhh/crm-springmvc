package com.myclass.repository.impl;

import java.util.List;

import javax.transaction.Transactional;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Repository;

import com.myclass.entity.User;
import com.myclass.repository.UserRepository;

@Repository
@Scope("prototype")
@Transactional(rollbackOn = Exception.class)
public class UserRepositoryImpl implements UserRepository{
	
	private SessionFactory sessionFactory;

	public UserRepositoryImpl(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	@Override
	public List<User> findAll() {
		Session session = sessionFactory.getCurrentSession();
		Query<User> query = session.createQuery("FROM User", User.class);
		return query.getResultList();
	}

	@Override
	public void saveOrUpdate(User user) {
		Session session = sessionFactory.getCurrentSession();
		session.saveOrUpdate(user);
	}

	@Override
	public User findById(int id) {
		Session session = sessionFactory.getCurrentSession();
		User user = session.find(User.class, id);
		return user;
	}

	@Override
	public void delete(int id) {
		Session session = sessionFactory.getCurrentSession();
		User user = session.find(User.class, id);
		session.remove(user);
	}
	
}
