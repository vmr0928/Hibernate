import java.util.List;

import javax.persistence.Query;
import javax.persistence.criteria.CriteriaBuilder;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.criterion.Restrictions;


public class Application {
	
	
	public static void main(String [] args) {
		
		//Creating the configuration object and reading the hibernate.cfg config file
		Configuration config = new Configuration();
		config = config.configure();
		
		//Building a sessionfactory
		SessionFactory sf = config.buildSessionFactory();
		
		//Opening a session with the help of sessionfactory object
		Session session = sf.openSession();
		
//		//Begining the trsnsaction
//		Transaction tx = session.beginTransaction();
//		
//		User user = new User();
//		
//		user.setUser_id(5);
//		user.setFirst_name("vinay");
//		user.setLast_name("Bathula");
//		user.setEmail("vb@gmail.com");
//		user.setPassword("vinay");
//		
//		session.save(user);
//		
//		//Commiting the transaction
//		tx.commit();
		
//		String query = "from User";
//		Query selectQuery = session.createQuery(query);
		
		Criteria criteria = session.createCriteria(User.class).add(Restrictions.gt("user_id", 2));
		List<User> results = criteria.list();
		
		
		for(User user: results) {
			System.out.println("ID: " + user.getUser_id() + ", firstName: " + user.getFirst_name() + ", lastName: " + user.getLast_name() +
					", email: " + user.getEmail() + ", password: " + user.getPassword());
		}
		//Closing the session
		session.close();
		//Closing the sessionfactory
		sf.close();
	}

}
