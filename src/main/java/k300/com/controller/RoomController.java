package k300.com.controller;

import k300.com.entity.Room;
import k300.com.service.RoomService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/room")
public class RoomController {
	
	@Autowired
    private RoomService roomService;

	@RequestMapping(value = "/get-all-room", method = RequestMethod.GET)
	public List<Room> getAllRooms() {
		return roomService.findAll();
	}
	
//	@RequestMapping("/")
//	public String index() {
//		List<Object[]> list = roomService.findByDateAndType(new Date(), "deluxe");
//	    for (Object room : list) {
//	      System.out.println(room);
//	    }
//	    return "index";
//	}
}
