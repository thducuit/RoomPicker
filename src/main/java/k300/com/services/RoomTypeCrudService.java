package k300.com.services;

import java.util.List;

import k300.com.entities.RoomType;

public interface RoomTypeCrudService {

	public List<RoomType> roomTypes();
	
	public boolean createRoomType();
	
	public boolean updateRoomType();
	
	public boolean deleteRoomTypes();
}
