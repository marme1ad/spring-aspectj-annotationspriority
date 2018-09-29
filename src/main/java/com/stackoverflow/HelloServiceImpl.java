package com.stackoverflow;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

@Log
@Service
public class HelloServiceImpl implements HelloService {

    private static Logger logger = LoggerFactory.getLogger(HelloServiceImpl.class);

    @Log(secure = true)
    @Override
    public Hello doCall(String message) {
        return new Hello(message);
    }

    @Override
    public void doNonAnnotatedCall(String message) {
        // do nothing
    }

}
