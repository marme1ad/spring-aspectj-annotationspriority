package com.stackoverflow;

public class Hello {

    private Long timestamp;
    private String message;

    public Hello(String message) {
        this.timestamp = System.currentTimeMillis() / 1000;
        this.message = message;
    }

    public Long getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(Long timestamp) {
        this.timestamp = timestamp;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    @Override
    public String toString() {
        return "Hello{" +
                "timestamp=" + timestamp +
                ", message='" + message + '\'' +
                '}';
    }

}
