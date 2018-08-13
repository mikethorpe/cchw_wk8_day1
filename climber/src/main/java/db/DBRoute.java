package db;

import models.Route;
import org.hibernate.Criteria;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.criterion.Restrictions;

import java.util.List;

public class DBRoute {

	private static Session session;
	private static Transaction transaction;

	public static void save(Route route){
		session = HibernateUtil.getSessionFactory().openSession();
		try {
			transaction = session.beginTransaction();
			session.save(route);
			transaction.commit();
		}
		catch (HibernateException ex) {
			transaction.rollback();
			ex.printStackTrace();
		}
		finally {
			session.close();
		}
	}


	public static List<Route> getAll(){
		List<Route> results = null;
		session = HibernateUtil.getSessionFactory().openSession();

		try {
			Criteria cr = session.createCriteria(Route.class);
			results = cr.list();
		}
		catch (HibernateException ex) {
			ex.printStackTrace();
		}
		finally {
			session.close();
		}
		return results;
	}


	public static Route findById(int id){
		session = HibernateUtil.getSessionFactory().openSession();
		Route result = null;

		try {
			Criteria cr = session.createCriteria(Route.class);
			cr.add(Restrictions.eq("id", id));
			result = (Route) cr.uniqueResult();
		}
		catch (HibernateException ex) {
			ex.printStackTrace();
		}
		catch (Exception e){
			e.printStackTrace();
		}
		finally {
			session.close();
		}
		return result;
	}
}
