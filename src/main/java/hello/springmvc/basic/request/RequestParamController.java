package hello.springmvc.basic.request;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.io.IOException;
import java.util.Map;

@Slf4j
@Controller
public class RequestParamController {
    @RequestMapping("/request-param-v1")
    public void requestParamV1(HttpServletRequest request, HttpServletResponse response) throws IOException {
        String username = request.getParameter("username");
        int age = Integer.parseInt(request.getParameter("age"));

        log.info("username={}, age={}",username,age);
        response.getWriter().write("ok");
    }

    /**
     * @RequestParam 사용
     * - 파라미터 이름으로 바인딩
     * @ResponseBody 추가
     * - View 조회를 무시하고, HTTP message body에 직접 해당 내용 입력
     * - return "ok" -> view화면으로 return 하는것이 아님
     */
    @ResponseBody
    @RequestMapping("/request-param-v2")
    public String requsetParamV2(@RequestParam("username") String memberName,
                                 @RequestParam("age") int memberAge){

        log.info("username={}, age={}",memberName, memberAge);
        return "ok";
    }

    /**
     * @RequestParam 사용
     * - 파라메타 이름이 변수명과 같으면 (...) 생략 가능하다
     */
    @ResponseBody
    @RequestMapping("/request-param-v3")
    public String requestParamV3(@RequestParam String username,
                                 @RequestParam int age){

        log.info("username={}, age={}",username, age);
        return "ok";

    }

    /**
     * @RequestParam 사용
     * String, int 와 같은 단순 타입일 경우에는 @RequestParam도 생략가능
     */
    @ResponseBody
    @RequestMapping("/request-param-v4")
    public String requestParamV4(String username, int age){
        log.info("username={}, age={}",username, age);
        return "ok";
    }

    /**
     * @RequestParam 사용
     * - required = true -> 값이 없으면 예외
     *            = false -> 값이 없으면 빈문자로 통과
     * ※ 주의 int의 경우에는 null이 불가능 하므로 Integer로 변경해야됨
     */
    @ResponseBody
    @RequestMapping("/request-param-required")
    public String requestParamRequired(@RequestParam(required = true) String username,
                                       @RequestParam(required = false) Integer age){
        log.info("username={}, age={}", username, age);
        return "ok";
    }

    /**
     * @RequestParam 사용
     * - defaultValue
     *
     * 값이 없을 경우 디폴트 값 정의
     */
    @ResponseBody
    @RequestMapping("/request-param-default")
    public String requestParamDefault(@RequestParam(required = true, defaultValue = "guest") String username,
                                      @RequestParam(required = false, defaultValue = "-1") int age){
        log.info("username={}, age={}", username, age);

        return "ok";
    }

    /**
     * @RequestParam 사용
     * - Map, MultiValueMap
     * Map(key,value)
     * MultiValueMap(key=[val1,val2]....) ex) (key=userIds, value=[id1, id2])
     * 값이 없을 경우 디폴트 값 정의
     */
    @ResponseBody
    @RequestMapping("/request-param-map")
    public String requestParamMap(@RequestParam Map<String, Object> paramMap){
        log.info("username={}, age={}", paramMap.get("username"), paramMap.get("age"));
        return "ok";
    }
}
