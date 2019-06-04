package k300.com.controller;

import k300.com.dto.RoomTypeDto;
import k300.com.entity.RoomType;
import k300.com.response.ResponseResult;
import k300.com.response.handler.ResponseResultHandler;
import k300.com.service.RoomTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.util.CollectionUtils;
import org.springframework.web.bind.annotation.*;

import java.util.Collections;
import java.util.List;

@RestController
@RequestMapping("/room-type")
public class RoomTypeController {

	@Autowired
	private RoomTypeService roomTypeService;

	@GetMapping(value = "/get-all-room-type")
	public ResponseResult getAllRoomType() {
		List<RoomType> listRoomType;
		try {
			listRoomType = roomTypeService.findAll();
			if (CollectionUtils.isEmpty(listRoomType)) {
				return ResponseResultHandler.handleSuccess(HttpStatus.NO_CONTENT , Collections.emptyList());
			}
		} catch (Exception ex) {
			return ResponseResultHandler.handleError(HttpStatus.INTERNAL_SERVER_ERROR , ex, Collections.emptyList());
		}
		return ResponseResultHandler.handleSuccess(HttpStatus.OK);
	}

	@PostMapping(value = "/create")
	public ResponseResult createNewRoom(@RequestBody RoomTypeDto roomTypeDto) {
		RoomType roomTypeCreated;
		try{
			roomTypeCreated = new RoomType();
			roomTypeCreated.setDescription(roomTypeDto.getDescription());
			roomTypeCreated.setMaxCapacity(roomTypeDto.getMax_capacity());

			roomTypeService.add(roomTypeCreated);
		}catch (Exception ex) {
			return ResponseResultHandler.handleError(HttpStatus.INTERNAL_SERVER_ERROR , ex);
		}
		return ResponseResultHandler.handleSuccess(HttpStatus.CREATED);
	}
}
