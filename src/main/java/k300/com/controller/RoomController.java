package k300.com.controller;

import k300.com.dto.RoomDto;
import k300.com.entity.Room;
import k300.com.entity.RoomType;
import k300.com.response.ResponseResult;
import k300.com.response.handler.ResponseResultHandler;
import k300.com.service.RoomService;
import k300.com.service.RoomTypeService;
import org.apache.commons.lang3.ArrayUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.util.CollectionUtils;
import org.springframework.web.bind.annotation.*;

import java.util.Collections;
import java.util.List;

@RestController
@RequestMapping("/room")
public class RoomController {

	public static final Logger LOG = LoggerFactory.getLogger(RoomController.class);
	
	@Autowired
    private RoomService roomService;

	@Autowired
	private RoomTypeService roomTypeService;

	@GetMapping(value = "/get-all-room")
	public ResponseResult getAllRooms() {
		List<Room> listRoom;
		try {
			listRoom = roomService.findAll();
			if (CollectionUtils.isEmpty(listRoom)) {
				return ResponseResultHandler.handleSuccess(HttpStatus.NO_CONTENT ,Collections.emptyList());
			}
		} catch (Exception ex) {
			return ResponseResultHandler.handleError(HttpStatus.INTERNAL_SERVER_ERROR , ex, Collections.emptyList());
		}
		return ResponseResultHandler.handleSuccess(HttpStatus.OK ,listRoom);
	}

	@PostMapping(value = "/create")
	public ResponseResult createNewRoom(@RequestBody RoomDto roomDto) {
		Room roomCreated;
		try{
			roomCreated = new Room();

			roomCreated.setName(roomDto.getName());
			roomCreated.setSmoke(roomDto.getSmoke());
			roomCreated.setStatus(roomDto.getStatus());
			roomCreated.setNumber(roomDto.getNumber());
			RoomType roomType = new RoomType();
			roomType.setId(roomDto.getRoom_type_id());
			roomCreated.setRoomType(roomType);

			roomService.add(roomCreated);
		}catch (Exception ex) {
			return ResponseResultHandler.handleError(HttpStatus.INTERNAL_SERVER_ERROR , ex);
		}
		return ResponseResultHandler.handleSuccess(HttpStatus.CREATED);
	}

	@PutMapping(value = "/{id}")
	public ResponseResult updateRoom(@PathVariable Integer id, @RequestBody RoomDto roomDto) {
		Room roomById;
		try{
			roomById = roomService.getById(id);

			if (roomById == null) {
				LOG.debug("Not found Room by ID: {}", id);
				return ResponseResultHandler.handleSuccess(HttpStatus.NO_CONTENT, "Not found Room by id :: " + id);
			}
			roomById.setName(roomDto.getName());
			roomById.setNumber(roomDto.getNumber());
			roomById.setStatus(roomDto.getStatus());
			roomById.setSmoke(roomDto.getSmoke());
			RoomType roomTypeById = roomTypeService.getById(roomDto.getRoom_type_id());
			roomById.setRoomType(roomTypeById != null ? roomTypeById : roomById.getRoomType());

			roomService.update(roomById);
		}catch (Exception ex) {
			return ResponseResultHandler.handleError(HttpStatus.INTERNAL_SERVER_ERROR , ex);
		}
		return ResponseResultHandler.handleSuccess(HttpStatus.OK);
	}

	@DeleteMapping
	public ResponseResult deleteRoom(@RequestBody Integer[] ids) {
		if (ArrayUtils.isEmpty(ids)) {
			LOG.debug("List ID update is empty");
			return ResponseResultHandler.handleSuccess(HttpStatus.NO_CONTENT, "List ID update is empty");
		}
		try {
			for (Integer id : ids) {
				roomService.delete(id);
			}
		}catch (Exception ex) {
			return ResponseResultHandler.handleError(HttpStatus.INTERNAL_SERVER_ERROR , ex);
		}
		return ResponseResultHandler.handleSuccess(HttpStatus.OK);
	}
}
