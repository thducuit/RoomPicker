package k300.com.dao;

import java.util.Date;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import k300.com.entities.Room;

public interface RoomDAO {

	public List<Room> findAll();
	
	public List<Object[]> findByDateAndType(Date $in, String type);
}
