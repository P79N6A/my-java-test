package priv.zc.example.controller;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import com.alibaba.fastjson.JSON;

import priv.zc.project.model.Config;
import priv.zc.project.model.SubscribeInfo;

@Controller
@RequestMapping("/test")
public class TestController {
	@RequestMapping(value = "index", produces = "text/html;charset=UTF-8")
	@ResponseBody
	public String index(HttpServletResponse response) {
		response.setContentType("text/html;charset=utf-8");
		return "Chinese 中文能正常显示吗";
	}

	@RequestMapping("print")
	@ResponseBody
	public String print(HttpServletRequest request) {
		System.out.println(request.getParameterMap());
		return "";
	}

	@RequestMapping("post")
	@ResponseBody
	public String post(HttpServletRequest request) {
		Map<String, Object> resultMap = new HashMap<String, Object>();
		resultMap.put("param", request.getParameterMap());
		return JSON.toJSONString(resultMap);
	}

	@RequestMapping("void")
	public void testVoid(HttpServletResponse response) {
		try {
			response.getWriter().close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return;
	}

	@RequestMapping("void2")
	@ResponseBody
	public void testVoid2() {
		return;
	}

	@RequestMapping("void3")
	@ResponseBody
	public void testVoid3(HttpServletResponse response) {
		try {
			response.getWriter().write("success");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return;
	}

	@RequestMapping("object")
	@ResponseBody
	public Object object() {
		Config config = new Config();
		config.setConfigKey("key");
		config.setConfigValue("value");
		return config;
	}

	@RequestMapping("map")
	@ResponseBody
	public Map map() {
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("key", 1);
		map.put("value", "值");
		return map;
	}

	@RequestMapping("upload")
	@ResponseBody
	public String upload(@RequestParam(value = "file", required = false) MultipartFile uploadfile,
			HttpServletResponse response) {
		response.setCharacterEncoding("UTF-8");
		response.setContentType("text/html");
		String filename = uploadfile.getOriginalFilename();
		return filename;
	}

	@RequestMapping("param")
	@ResponseBody
	public String param(String id, String name) {
		System.out.println("id:" + id);
		System.out.println("name:" + id);
		return null;
	}

	@RequestMapping("param1")
	@ResponseBody
	public String param1(@RequestBody Map map) {
		System.out.println(map);
		return null;
	}

	@RequestMapping("config")
	@ResponseBody
	public Config config(Config config, SubscribeInfo subscribInfo) {
		System.out.println(JSON.toJSONString(config));
		System.out.println(JSON.toJSONString(subscribInfo));
		return config;
	}

	@RequestMapping("file")
	@ResponseBody
	public String file(MultipartFile uploadfile) {
		System.out.println(uploadfile.getContentType());
		System.out.println(uploadfile.getName());
		System.out.println(uploadfile.getOriginalFilename());
		System.out.println(uploadfile.getSize());
		return null;
	}

	@RequestMapping("setList")
	@ResponseBody
	public String setList(@RequestBody  List<String> list){
		System.out.println(list);
		return null;
	}

}
