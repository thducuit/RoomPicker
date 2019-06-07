package k300.com.service.impl;

import k300.com.dao.RoomDAO;
import k300.com.entity.Room;
import k300.com.service.RoomService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;


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

	@Transactional
	public void delete(Integer id) {
		roomDAO.remove(id);
		
	}

	public Room update(Room room) {
		return roomDAO.update(room);
	}

}
