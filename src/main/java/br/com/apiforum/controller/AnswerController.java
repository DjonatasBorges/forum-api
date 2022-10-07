package br.com.apiforum.controller;

import br.com.apiforum.request.answer.AnswerResponse;
import br.com.apiforum.service.AnswerService;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("answer")
@Log4j2
@RequiredArgsConstructor
public class AnswerController {
//    private final AnswerService answerService;
//
//    @GetMapping
//    public ResponseEntity<List<AnswerResponse>> list() {
//        return ResponseEntity.ok(answerService.listAll());
//    }
}
