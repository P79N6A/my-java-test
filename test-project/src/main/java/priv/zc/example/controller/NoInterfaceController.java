package priv.zc.example.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import priv.zc.example.service.NoInterfaceService;

@RequestMapping("/nointerface")
@RestController
public class NoInterfaceController {
	
	@Autowired
	NoInterfaceService noInterfaceSerivice;
	@RequestMapping("index")
	public Object index(){
		return noInterfaceSerivice.test();
	}
}
