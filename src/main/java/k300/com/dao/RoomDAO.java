package k300.com.dao;

import k300.com.entity.Room;

import java.util.Date;
import java.util.List;

public interface RoomDAO {

	List<Room> findAll();
	
	Room add(Room room);
	
	Room update(Room room);
	
	void remove(Integer roomId);
	
	Room getById(Integer roomId);
	
	List<Object[]> findByDateAndType(Date $in, String type);
}
