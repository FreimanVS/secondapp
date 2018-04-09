package com.freimanvs.secondapp.rest;

import javax.ws.rs.core.Response;

public interface Calculator {
    Response calculate(int t,
                       double kr,
                       double st);
}
