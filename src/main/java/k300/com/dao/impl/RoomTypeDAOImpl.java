package k300.com.dao.impl;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import k300.com.dao.RoomTypeDAO;
import k300.com.entity.RoomType;

@Repository
public class RoomTypeDAOImpl implements RoomTypeDAO {
	
	@Autowired
	private SessionFactory sessionFactory;

	public List<RoomType> findAll() {
		Session session = sessionFactory.openSession();
		return session.createQuery("From RoomType", RoomType.class).getResultList();
	}

	public RoomType add(RoomType roomType) {
		Session session = sessionFactory.openSession();
		session.saveOrUpdate(roomType);
		return roomType;
	}

	public RoomType update(RoomType roomType) {
		Session session = sessionFactory.openSession();
		session.update(roomType);
		return roomType;
	}

	public void remove(Integer roomTypeId) {
		Session session = sessionFactory.openSession();
		RoomType roomType = getById(roomTypeId);
		if (roomType != null) {
			session.delete(roomType);
		}
	}

	public RoomType getById(Integer roomTypeId) {
		Session session = sessionFactory.openSession();
		return session.get(RoomType.class, roomTypeId);
	}

}
