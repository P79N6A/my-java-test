package priv.zc.example.controller;

import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/example")
public class ExampleController {

    @RequestMapping("exception")
    public void exception() {
        throw new RuntimeException("test runtimeException");
    }
    
    @ExceptionHandler(RuntimeException.class)
    public void exceptionHandler(RuntimeException e){
        e.printStackTrace();
        System.out.println("exceptionHandler executed!");
    }

    @RequestMapping("vmtest")
    public ModelAndView vmtest() {
        Map<String, String> map = new HashMap<String, String>();
        map.put("var1","你好");
        map.put("var2","行为");
        return new ModelAndView("vmtest","data",map);
    }
}
