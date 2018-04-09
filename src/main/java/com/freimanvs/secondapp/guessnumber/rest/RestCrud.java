package com.freimanvs.secondapp.guessnumber.rest;

import javax.validation.Valid;
import javax.ws.rs.core.Response;

public interface RestCrud<T> {
    Response getALL();
    Response add(@Valid T obj);
    Response getById(Long id);
    Response delete(Long id);
    Response update(Long id, @Valid T obj);
}
