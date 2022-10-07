package br.com.apiforum.controller;

import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.util.List;

public abstract class BaseController<T> {

    public ResponseEntity<Void> created(Long id){
        return ResponseEntity.status(HttpStatus.CREATED)
                .header("id", id.toString())
                .build();
    }

    public ResponseEntity<T> created(T body){
        return ResponseEntity.status(HttpStatus.CREATED).body(body);
    }

    public ResponseEntity<Void> created(){
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }

    public ResponseEntity<T> ok(T body){
        return ResponseEntity.ok(body);
    }

    public ResponseEntity<List<T>> ok(List<T> body){
        return ResponseEntity.ok(body);
    }

    public ResponseEntity<List<T>> partialContent(Page<T> page){
        return ResponseEntity.status(HttpStatus.PARTIAL_CONTENT)
                .header("content-range", String.valueOf(page.getTotalElements()))
                .header("content-page", String.valueOf(page.getTotalPages()))
                .body(page.getContent());
    }

    public ResponseEntity<Void> noContent(){
        return ResponseEntity.noContent().build();
    }

    public ResponseEntity<T> noContent(T body){
        return ResponseEntity.status(HttpStatus.NO_CONTENT).body(body);
    }

    public ResponseEntity<Void> accepted(){
        return ResponseEntity.accepted().build();
    }



}
