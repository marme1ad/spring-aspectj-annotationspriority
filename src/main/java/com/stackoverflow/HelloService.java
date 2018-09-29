package com.stackoverflow;

public interface HelloService {

    public Hello doCall(String message);

    public void doNonAnnotatedCall(String message);

}
