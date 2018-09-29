package com.stackoverflow;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

@Log
@Controller
public class HelloController {

    private static Logger logger = LoggerFactory.getLogger(HelloController.class);

    @Autowired
    HelloService helloService;

    @Log(secure = true)
    @RequestMapping(value = "/hello/{message}", method = {RequestMethod.GET})
    @ResponseBody
    public Hello hello(@PathVariable("message") String message) throws Exception {
        helloService.doNonAnnotatedCall(message);
        return helloService.doCall(message);
    }

}
