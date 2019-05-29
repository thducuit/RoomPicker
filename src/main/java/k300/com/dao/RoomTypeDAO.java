package k300.com.dao;

import java.util.List;

import k300.com.entity.RoomType;

public interface RoomTypeDAO {

	List<RoomType> findAll();

	RoomType add(RoomType roomType);

	RoomType update(RoomType roomType);

	void remove(Integer roomTypeId);

	RoomType getById(Integer roomTypeId);

}
