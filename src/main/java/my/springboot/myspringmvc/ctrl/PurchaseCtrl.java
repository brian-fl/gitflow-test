package my.springboot.myspringmvc.ctrl;

import lombok.Getter;
import lombok.Setter;
import my.springboot.myspringmvc.service.PurchaseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

@RestController
public class PurchaseCtrl {
    @Autowired
    private PurchaseService purchaseService;

    @GetMapping("/test")
    public ModelAndView testPage() {
        ModelAndView mv = new ModelAndView("test");
        return mv;
    }

    @PostMapping("/purchase")
    public Result purchase(@RequestParam("userId") Integer userId, @RequestParam("productId") Integer productId, @RequestParam("quantity") int quantity) {
        boolean success = purchaseService.purchase(userId, productId, quantity);
        String msg = success ? "抢购成功" : "抢购失败";
        Result result = new Result(success, msg);
        return result;
    }

    //响应结果
    @Getter
    @Setter
    class Result {
        private boolean success = false;
        private String msg = null;

        public Result() {

        }

        public Result(boolean success, String msg) {
            this.success = success;
            this.msg = msg;
        }
    }
}
