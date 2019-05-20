package k300.com.services;

import java.util.List;

import k300.com.entities.Room;

public interface RoomCrudService {

	public List<Room> rooms();
	
	public boolean createRoom();
	
	public boolean updateRoom();
	
	public boolean deleteRooms();
}
