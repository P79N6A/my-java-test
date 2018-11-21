package priv.zc.spring.springboot;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class IndexController {

    @RequestMapping("/page")
    public String index(ModelMap map){
        map.addAttribute("host", "http://aiyago.tk");
        return "page";
    }
}
