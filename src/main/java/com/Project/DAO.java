package com.Project;

import java.util.Collections;
import java.util.List;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import com.Project.Entity.Options;
import com.Project.Entity.SurveyDetails;
import com.Project.Entity.UserDetails;

public class DAO {
	private static SessionFactory sessionFactory;

    static {
        try {
            sessionFactory = new Configuration().configure("hibernate.cfg.xml").buildSessionFactory();
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
    }

    public void addNewUser(String email, String name, String password) {
    	Session session = sessionFactory.openSession();
    	Transaction t = session.beginTransaction();
    	
    	UserDetails user = new UserDetails();
    	user.setEmail(email);
    	user.setName(name);
    	user.setPassword(password);
    	session.persist(user);
    	
    	t.commit();
    	session.close();
    }
    
    public int checkCredentials(String email, String password) {
    	Session s = sessionFactory.openSession();
    	Transaction t = s.beginTransaction();
    	
    	UserDetails user = s.get(UserDetails.class, email);
    	
    	t.commit();
    	s.close();
    	
    	if (user==null) return 0;
    	if (user.getPassword().equals(password)) return 1;
    	return -1;
    	
    }
    
    public void addSurvey(List<Options> op, SurveyDetails survey) {
    	Session s = sessionFactory.openSession();
    	Transaction t = s.beginTransaction();
    	
    	s.persist(survey);
    	for (Options o : op) s.persist(o);
    	
    	t.commit();
    	s.clear();
    }
    
    public String getName(String email) {
    	Session s = sessionFactory.openSession();
    	Transaction t = s.beginTransaction();
    	
    	UserDetails user = s.get(UserDetails.class, email);
    	
    	t.commit();
    	s.close();
    	
    	return user.getName();
    }
    
    public Long getCount(String email) {
    	Session s = sessionFactory.openSession();
    	Transaction t = s.beginTransaction();
    	
    	Long count;
    	
    	try {
    		count = (Long) s.createQuery("select count(*) from SurveyDetails where email = :email").setParameter("email", email).uniqueResult();
    	}
    	catch (Exception e) {
    		return 0L;
    	}
    	
    	t.commit();
    	s.close();
    	
    	return count;
    }

	@SuppressWarnings("unchecked")
	public List<Object[]> getAllSurveyQ(String email) {
		
		Session s = sessionFactory.openSession();
    	
    	List<Object[]> list;
    	
    	try {
    		list = s.createQuery("select SurveyID, question from SurveyDetails where email = :email")
    				.setParameter("email", email)
    				.list();
    	}
    	catch (Exception e) {
    		return Collections.EMPTY_LIST;
    	}
    	
    	s.close();
    	
		return list;
	}

	@SuppressWarnings("unchecked")
	public List<String> getOptions(String id) {
		
		Session s = sessionFactory.openSession();
    	
    	List<String> list;
    	
    	try {
    		list = s.createQuery("select concat(o.Op, ' (', o.percent, '%)') from Options o where o.SurveyID = :id")
    			    .setParameter("id", id)
    			    .getResultList();

    	}
    	catch (Exception e) {
    		return Collections.EMPTY_LIST;
    	}
    	
    	s.close();
    	
    	return list;
	}
}










