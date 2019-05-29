package k300.com.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import k300.com.dao.RoomDAO;
import k300.com.entity.Room;
import k300.com.service.RoomService;

@Service
public class RoomServiceImpl implements RoomService {
	
	@Autowired
    private RoomDAO roomDAO;

	public List<Room> findAll() {
		return roomDAO.findAll();
	}

	public Room getById(Integer id) {
		return roomDAO.getById(id);
	}

	public Room add(Room room) {
		return roomDAO.add(room);
	}

	public void delete(Integer id) {
		roomDAO.remove(id);
		
	}

	public Room update(Room room) {
		return roomDAO.update(room);
	}

}
