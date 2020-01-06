package my.springboot.myspringmvc.ctrl;

import my.springboot.myspringmvc.pojo.User;
import my.springboot.myspringmvc.pojo.User2;
import my.springboot.myspringmvc.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

@RestController
@RequestMapping("/user")
public class UserCtrl {
    @Autowired
    private UserService userService = null;

    @RequestMapping("hello")
    public String hello() {
        return "hello";
    }

    @RequestMapping("/{id}")
    public User2 user(@PathVariable Integer id) {
        return userService.getUser2(id.longValue());
    }

    @RequestMapping("details")
    public ModelAndView details(Long id) {
        //访问模型层得到数据
        User user = userService.getUser(id);

        //模型和视图
        ModelAndView mv = new ModelAndView();
        //定义模型视图
        mv.setViewName("user/details");
        //加入数据模型
        mv.addObject("user", user);

        return mv;
    }
}
