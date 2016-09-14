package priv.zc.autosign.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import priv.zc.autosign.model.SignInfo;
import priv.zc.autosign.service.SignInfoService;
import priv.zc.autosign.vo.AjaxDoneVo;
import priv.zc.autosign.vo.ResultVo;

import javax.servlet.http.HttpServletRequest;
import java.util.Date;
import java.util.List;

@Controller
@RequestMapping("/signInfo")
public class SignInfoCtrl {
    Logger logger= LoggerFactory.getLogger(SignInfoCtrl.class);
	
	@Autowired
	private SignInfoService signInfoService;

	@RequestMapping("list")
	public String list(HttpServletRequest request) {
	    logger.debug("进入list");
		List<SignInfo> list=signInfoService.select();
		request.setAttribute("list",list);
		return "signInfo/list";
	}

	@RequestMapping("add")
	public String add() {
		return "signInfo/add";
	}

	@RequestMapping(value = "addPost",method = RequestMethod.POST)
	@ResponseBody
	public AjaxDoneVo addPost(@ModelAttribute SignInfo signInfo) {
		int count = signInfoService.insert(signInfo);
		AjaxDoneVo vo;
		if(count==1) {
			 vo = AjaxDoneVo.success();
			vo.setRel("signInfo_list");
		}else{
			vo = AjaxDoneVo.error();
		}
		return vo;
	}

	@RequestMapping("update")
	public String update() {
		return "";
	}

	@RequestMapping("updatePost")
	public String updatePost() {
		return "";
	}

	@RequestMapping("exec/{id}")
	@ResponseBody
	public ResultVo exec(@PathVariable Long id) {
		return signInfoService.exec(id);
	}

}
