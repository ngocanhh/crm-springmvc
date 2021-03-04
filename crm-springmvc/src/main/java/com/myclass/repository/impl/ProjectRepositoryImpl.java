package com.myclass.repository.impl;

import java.util.List;
import javax.transaction.Transactional;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Repository;
import com.myclass.entity.Project;
import com.myclass.repository.ProjectRepository;

@Repository
@Scope("prototype")
@Transactional(rollbackOn = Exception.class)
public class ProjectRepositoryImpl implements ProjectRepository {
	
	private SessionFactory sessionFactory;
	
	public ProjectRepositoryImpl(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	@Override
	public List<Project> findAll() {
		Session session = sessionFactory.getCurrentSession();
		Query<Project> query = session.createQuery("FROM Project", Project.class);
		return query.getResultList();
	}

	@Override
	public void saveOrUpdate(Project project) {
		Session session = sessionFactory.getCurrentSession();
		session.saveOrUpdate(project);
	}

	@Override
	public Project findById(int id) {
		Session session = sessionFactory.getCurrentSession();
		return session.find(Project.class, id);
	}

}
