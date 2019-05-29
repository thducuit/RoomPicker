package k300.com.dao;

import java.util.Date;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import k300.com.entity.Room;

public interface RoomDAO {

	List<Room> findAll();
	
	Room add(Room room);
	
	Room update(Room room);
	
	void remove(Integer roomId);
	
	Room getById(Integer roomId);
	
	List<Object[]> findByDateAndType(Date $in, String type);
}
