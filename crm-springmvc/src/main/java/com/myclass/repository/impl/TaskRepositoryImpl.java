package com.myclass.repository.impl;

import java.util.List;
import javax.transaction.Transactional;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Repository;
import com.myclass.entity.Task;
import com.myclass.repository.TaskRepository;

@Repository
@Scope("prototype")
@Transactional(rollbackOn = Exception.class)
public class TaskRepositoryImpl implements TaskRepository {

	private SessionFactory sessionFactory;
	
	public TaskRepositoryImpl(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	@Override
	public List<Task> findAll() {
		Session session = sessionFactory.getCurrentSession();
		Query<Task> query = session.createQuery("FROM Task", Task.class);
		return query.getResultList();
	}

}
