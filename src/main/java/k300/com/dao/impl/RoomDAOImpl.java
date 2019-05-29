package k300.com.dao.impl;

import java.util.Date;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import k300.com.dao.RoomDAO;
import k300.com.entity.Room;

@Repository("roomDAO")
public class RoomDAOImpl implements RoomDAO  {

	@Autowired
	private SessionFactory sessionFactory;
	
	
	public List<Room> findAll() {
	Session session = this.sessionFactory.openSession();
	List<Room> result = (List<Room>) session.createQuery("FROM Room", Room.class).getResultList();
	    return result;
	}	

	public Room add(Room room) {
		Session session = this.sessionFactory.getCurrentSession();
		session.saveOrUpdate(room);
		return room;
		
	}


	public Room update(Room room) {
		Session session = this.sessionFactory.getCurrentSession();
		session.update(room);
		return room;
	}


	public void remove(Integer roomId) {
		Room room = getById(roomId);
		if (room != null) {
			Session session = this.sessionFactory.getCurrentSession();
			session.delete(room);
		}		
	}


	public Room getById(Integer roomId) {
		  Session session = sessionFactory.getCurrentSession();
		  return (Room) session.get(Room.class, roomId);
	}
	
public List<Object[]> findByDateAndType(Date $in, String type) {
		
		Session session = this.sessionFactory.openSession();
		List<Object[]> resultList = session.createNativeQuery("select rooms.* from rooms \r\n" + 
				"join room_type on rooms.room_type_id = room_type.id \r\n" + 
				"where rooms.id not  in\r\n" + 
				" (select room_id  from occupied_rooms \r\n" + 
				"Join reservation on occupied_rooms.reservation_id = reservation.id\r\n" + 
				"Where date_out >  \"2019-05-17 12:30:00\") and room_type.description = 'deluxe'").getResultList();
		
		return resultList;
	}
}
