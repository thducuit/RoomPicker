package k300.com.controller;

import k300.com.dto.RoomDto;
import k300.com.entity.Room;
import k300.com.entity.RoomType;
import k300.com.response.ResponseResult;
import k300.com.response.handler.ResponseResultHandler;
import k300.com.service.RoomService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.util.CollectionUtils;
import org.springframework.web.bind.annotation.*;

import java.util.Collections;
import java.util.List;

@RestController
@RequestMapping("/room")
public class RoomController {
	
	@Autowired
    private RoomService roomService;

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
			RoomType roomType = new RoomType();
			roomType.setId(roomDto.getRoom_type_id());
			roomCreated.setRoomType(roomType);

			roomService.add(roomCreated);
		}catch (Exception ex) {
			return ResponseResultHandler.handleError(HttpStatus.INTERNAL_SERVER_ERROR , ex);
		}
		return ResponseResultHandler.handleSuccess(HttpStatus.CREATED);
	}
	

}
