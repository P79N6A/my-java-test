package priv.zc.project.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import priv.zc.project.model.SubscribeInfo;
import priv.zc.project.service.SubscribeInfoService;

@Controller
@RequestMapping("/subscribe")
public class SubscribeController {
	@Autowired
	private SubscribeInfoService subscribeInfoService;
	
	@RequestMapping("list")
	public ModelAndView list(){
		List<SubscribeInfo> list = subscribeInfoService.selectByCondition(null);
		return new ModelAndView("subscribeInfo/list","list",list);
	}
	
	@RequestMapping(path="add",method=RequestMethod.GET)
	public String add(){
		return "subscribeInfo/add";
	}
	
	@RequestMapping(path="add",method=RequestMethod.POST)
	public String addPost(@ModelAttribute("subscribeInfo")SubscribeInfo subscribeInfo){
		subscribeInfoService.insert(subscribeInfo);
		return "redirect:/subscribe/list";
	}
	
	@RequestMapping(path="delete/{id}")
	public String delete(@PathVariable Integer id){
		int result = subscribeInfoService.deleteByPrimaryKey(id);
		return "redirect:/subscribe/list";
	}
}
