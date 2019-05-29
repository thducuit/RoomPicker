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
		Session session = sessionFactory.getCurrentSession();
		return (List<RoomType>) session.createQuery("From RoomType", RoomType.class).getResultList();
	}

	public RoomType add(RoomType roomType) {
		Session session = sessionFactory.getCurrentSession();
		session.saveOrUpdate(roomType);
		return roomType;
	}

	public RoomType update(RoomType roomType) {
		Session session = sessionFactory.getCurrentSession();
		session.update(roomType);
		return roomType;
	}

	public void remove(Integer roomTypeId) {
		Session session = sessionFactory.getCurrentSession();
		RoomType roomType = getById(roomTypeId);
		if (roomType != null) {
			session.delete(roomType);
		}
	}

	public RoomType getById(Integer roomTypeId) {
		Session session = sessionFactory.getCurrentSession();
		return (RoomType) session.get(RoomType.class, roomTypeId);		
	}

}
