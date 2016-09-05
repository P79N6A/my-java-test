package priv.zc.autosign.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import priv.zc.autosign.service.SignInfoService;
import priv.zc.autosign.vo.ResultVo;

@Controller
@RequestMapping("/signInfo")
public class SignInfoCtrl {
	
	@Autowired
	private SignInfoService signInfoService;

	@RequestMapping("list")
	public String list() {
		return "signInfo/list";
	}

	@RequestMapping("add")
	public String add() {
		return "";
	}

	@RequestMapping("addPost")
	public String addPost() {
		return "";
	}

	@RequestMapping("update")
	public String update() {
		return "";
	}

	@RequestMapping("updatePost")
	public String updatePost() {
		return "";
	}

	@RequestMapping("exec/${id}")
	@ResponseBody
	public ResultVo exec(@PathVariable Long id) {
		return signInfoService.exec(id);
	}

}
