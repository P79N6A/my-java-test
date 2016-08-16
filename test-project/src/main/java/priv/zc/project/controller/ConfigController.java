package priv.zc.project.controller;

import java.util.List;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import priv.zc.project.model.Config;
import priv.zc.project.service.ConfigService;

@Controller
@RequestMapping("/config")
public class ConfigController {

	@Autowired
	private ConfigService configService;
	
	@RequiresPermissions("config")
	@RequestMapping("list")
	public ModelAndView list() {
		List<Config> list = configService.selectByCondition(null);
		return new ModelAndView("config/list", "list", list);
	}

	@RequestMapping(path = "add", method = RequestMethod.GET)
	public String add() {
		return "config/add";
	}

	@RequestMapping(path = "add", method = RequestMethod.POST)
	public String addPost(@ModelAttribute("config") Config config) {
		configService.insert(config);
		return "redirect:/config/list";
	}

	@RequestMapping("delete/{id}")
	public String delete(@PathVariable Integer id) {
		configService.deleteByPrimaryKey(id);
		return "redirect:/config/list";
	}

	@RequestMapping(path = "update/{id}", method = RequestMethod.GET)
	public ModelAndView update(@PathVariable Integer id) {
		Config config = configService.selectByPrimaryKey(id);
		return new ModelAndView("config/update", "config", config);
	}
	
	@RequestMapping(path="update", method=RequestMethod.POST)
	public String udpatePost(@ModelAttribute("config") Config config){
		configService.updateByPrimaryKey(config);
		return "redirect:/config/list";
	}
}
