package com.lenny.ncba.shared.controller;

import com.lenny.ncba.shared.dto.ResponseDto;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;


public abstract class BaseController {

    public ResponseEntity success(String message) {
        return ResponseEntity.status(HttpStatus.OK).body(new ResponseDto(message, HttpStatus.OK.value()));
    }

    public <T> ResponseEntity<T> entity(T entity) {
        return ResponseEntity.status(HttpStatus.OK).header("Content-Type", "application/json").body(entity);
    }

}
