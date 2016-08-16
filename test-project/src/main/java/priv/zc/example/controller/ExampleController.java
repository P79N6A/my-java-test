package priv.zc.example.controller;

import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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
}
