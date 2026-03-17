package hello.springmvc.basic;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class LogTestController {
    private final Logger logger = LoggerFactory.getLogger(LogTestController.class);

    @RequestMapping("/log-test")
    public String logTest(){
        String logName = "logTest";

        System.out.println(logName);

        logger.trace("trace log = {} " , logName);
        logger.debug("debug log = {} " , logName);
        logger.info("info log = {} " , logName);
        logger.warn("warn log = {} " , logName);
        logger.error("error log = {} " , logName);

        // 내가 사용하는 방식은 아래와 같은데 이렇게 사용하면 안된다고 한다...
        // + 를 하면 연산을 한번 하고나서 출력을 하는거기 때문에 불필요한 메모리 낭비가 될 수 있음...
        // 이제부터 {} 방식으로 사용하자!!!
        logger.info("info log = " + logName);
        return "logTest Ok";
    }
}
