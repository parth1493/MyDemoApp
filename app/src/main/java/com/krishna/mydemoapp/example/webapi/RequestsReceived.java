package com.krishna.mydemoapp.example.webapi;

/**
 * Created by krishna on 2017-08-26.
 */

class RequestsReceived {
    private String request_state;

    public RequestsReceived(String request_state) {
        this.request_state = request_state;
    }

    public String getRequest_state() {
        return request_state;
    }

    public void setRequest_state(String request_state) {
        this.request_state = request_state;
    }
}
