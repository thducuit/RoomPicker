package k300.com.controllers;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import k300.com.dao.RoomDAO;

@RestController
public class RoomController {
	
	@Autowired
	@Qualifier("roomDAO")
    private RoomDAO roomDAO;
	
	@RequestMapping("/")
	public String index() {
		List<Object[]> list = roomDAO.findByDateAndType(new Date(), "deluxe");
	    for (Object room : list) {
	      System.out.println(room);
	    }
	    return "index";
	}
}
