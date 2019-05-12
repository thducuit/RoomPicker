package k300.com.controller;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import k300.com.dao.RoomDAO;
import k300.com.entities.Room;

@Controller
public class RoomController {
	
	@Autowired
	@Qualifier("roomDAO")
    private RoomDAO roomDAO;
	
	@RequestMapping("/")
	public String index() {
		List<Room> list = roomDAO.findByDateAndType(new Date(), "deluxe");
	    for (Room customer : list) {
	      System.out.println(customer);
	    }
	    return "index";
	}
}
