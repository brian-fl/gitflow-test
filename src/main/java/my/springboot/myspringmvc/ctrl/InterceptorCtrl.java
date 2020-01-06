package my.springboot.myspringmvc.ctrl;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/interceptor")
public class InterceptorCtrl {

    @GetMapping("/start")
    public String start() {
        System.out.println("执行处理器逻辑");
        return "/welcome";
    }
}
