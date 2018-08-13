package db;
import models.Climber;
import org.hibernate.Criteria;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.criterion.Restrictions;

import java.util.List;

public class DBClimber {

	private static Session session;
	private static Transaction transaction;

	public static void save(Climber climber){
		session = HibernateUtil.getSessionFactory().openSession();

		try {
			transaction = session.beginTransaction();
			session.save(climber);
			transaction.commit();
		} catch (HibernateException ex) {
			transaction.rollback();
			ex.printStackTrace();
		}

		finally {
			session.close();
		}
	}

	public static List<Climber> getAll(){
		List<Climber> results = null;
		session = HibernateUtil.getSessionFactory().openSession();

		try {
			Criteria cr = session.createCriteria(Climber.class);
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

	public static Climber findById(int id){
		session = HibernateUtil.getSessionFactory().openSession();
		Climber result = null;

		try {
			Criteria cr = session.createCriteria(Climber.class);
			cr.add(Restrictions.eq("id", id));
			result = (Climber) cr.uniqueResult();
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
