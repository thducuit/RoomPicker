package k300.com.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import k300.com.dao.RoomTypeDAO;
import k300.com.entity.RoomType;
import k300.com.service.RoomTypeService;

@Service
public class RoomTypeServiceImpl implements RoomTypeService {
	
	@Autowired
	private RoomTypeDAO roomTypeDAO;

	public List<RoomType> findAll() {
		return roomTypeDAO.findAll();
	}

	public RoomType getById(Integer id) {
		return roomTypeDAO.getById(id);
	}

	public RoomType add(RoomType roomType) {
		return roomTypeDAO.add(roomType);
	}

	public void delete(Integer id) {
		roomTypeDAO.remove(id);
	}

	public RoomType update(RoomType roomType) {
		return roomTypeDAO.update(roomType);
	}
	
	
} 
