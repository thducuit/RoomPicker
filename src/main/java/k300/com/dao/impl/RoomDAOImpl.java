package k300.com.dao.impl;

import k300.com.dao.RoomDAO;
import k300.com.entity.Room;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.List;

@Repository("roomDAO")
public class RoomDAOImpl implements RoomDAO {

	@Autowired
	private SessionFactory sessionFactory;

	public List<Room> findAll() {
		Session session = this.sessionFactory.openSession();
		return session.createQuery("FROM Room", Room.class).getResultList();
	}

	public Room add(Room room) {
		Session session = this.sessionFactory.openSession();
		session.saveOrUpdate(room);
		return room;

	}

	public Room update(Room room) {
		Session session = this.sessionFactory.openSession();
		session.update(room);
		return room;
	}

	public void remove(Integer roomId) {
		Session session = this.sessionFactory.openSession();
		Transaction tx = session.beginTransaction();
		//		Room room = getById(roomId);
//		Room room = session.get(Room.class, roomId);
//		if (room != null) {
			session.delete(session.get(Room.class, roomId));
//			session.flush();
//		}
	}

	public Room getById(Integer roomId) {
		Session session = sessionFactory.openSession();
		return session.get(Room.class, roomId);
	}

	public List<Object[]> findByDateAndType(Date $in, String type) {

		Session session = this.sessionFactory.openSession();
		List<Object[]> resultList = session.createNativeQuery(
				"select rooms.* from rooms \r\n" + "join room_type on rooms.room_type_id = room_type.id \r\n"
						+ "where rooms.id not  in\r\n" + " (select room_id  from occupied_rooms \r\n"
						+ "Join reservation on occupied_rooms.reservation_id = reservation.id\r\n"
						+ "Where date_out >  \"2019-05-17 12:30:00\") and room_type.description = 'deluxe'")
				.getResultList();

		return resultList;
	}
}
