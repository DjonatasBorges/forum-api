package br.com.apiforum.controller;

import br.com.apiforum.domain.Course;
import br.com.apiforum.request.course.CoursePostRequestBody;
import br.com.apiforum.request.course.CoursePutRequestBody;
import br.com.apiforum.service.CourseService;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("courses")
@Log4j2
@RequiredArgsConstructor
public class CourseController {

    private final CourseService courseService;
    @GetMapping
    public ResponseEntity<List<Course>> findAll() {
        return ResponseEntity.ok(courseService.findAll());
    }

    @GetMapping(path = "/{id}")
    public ResponseEntity<Course> findById(@PathVariable long id) {
        return ResponseEntity.ok(courseService.findByIdOrThrowBadRequestException(id));
    }

    @Transactional
    @PostMapping
    public ResponseEntity<Course> save(@RequestBody @Valid CoursePostRequestBody coursePostRequestBody) {
        return new ResponseEntity<>(courseService.save(coursePostRequestBody), HttpStatus.CREATED);
    }

    @Transactional
    @ApiResponses(value = {
            @ApiResponse(responseCode = "204", description = "Successful Operation"),
            @ApiResponse(responseCode = "400", description = "When User Does Not Exist in The Database")
    })
    @DeleteMapping(path = "/{id}")
    public ResponseEntity<Course> delete(@PathVariable long id) {
        courseService.delete(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @Transactional
    @PutMapping
    public ResponseEntity<CoursePutRequestBody> replace(@RequestBody @Valid CoursePutRequestBody coursePutRequestBody) {
        courseService.replace(coursePutRequestBody);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }
}
