package hello.springmvc.basic.response;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class ResponseViewController {
    @RequestMapping(value = "/response-view-v1")
    public ModelAndView responseViewV1() {
        ModelAndView modelAndView = new ModelAndView("response/hello");
        modelAndView.addObject("data","hello world");
        return modelAndView;
    }

    @RequestMapping(value = "/response-view-v2")
    public String responseViewV2(Model model) {
        model.addAttribute("data","hello world");
        return "response/hello";
    }

    @RequestMapping(value="/response-view-v3")
    public void responseViewV3(Model model) {
        model.addAttribute("data","hello world");
    }

    
}
