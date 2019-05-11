package k300.com.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import k300.com.entities.Room;

@Repository
public class RoomDAOImpl implements RoomDAO  {

	@Autowired
	private SessionFactory sessionFactory;
	
	
	public List<Room> findAll() {
	Session session = this.sessionFactory.openSession();
	List<Room> result = (List<Room>) session.createQuery("FROM Room", Room.class).getResultList();;
	    return result;
	}
}
