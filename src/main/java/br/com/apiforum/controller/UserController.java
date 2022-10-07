package br.com.apiforum.controller;

import br.com.apiforum.domain.User;
import br.com.apiforum.mappers.UserMapper;
import br.com.apiforum.request.user.UserPostRequestBody;
import br.com.apiforum.request.user.UserPutRequestBody;
import br.com.apiforum.request.user.UserResponse;
import br.com.apiforum.service.UserService;
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
@RequestMapping("/users")
@Log4j2
@RequiredArgsConstructor
public class UserController extends BaseController {
    private final UserService userService;

    @GetMapping
    public ResponseEntity<List<UserResponse>> findAll() {
        List<UserResponse> response = userService.findAll();
        return ok(response);
    }

    @GetMapping(path = "/{id}")
    public ResponseEntity<UserResponse> findById(@PathVariable long id) {
        UserResponse responseById = userService.findByIdOrThrowBadRequestException(id);
        return ok(responseById);
    }

    @Transactional
    @PostMapping
    public ResponseEntity<UserResponse> save(@RequestBody @Valid UserPostRequestBody userPostRequestBody) {
        User user = userService.save(userPostRequestBody);
        return created(UserMapper.INSTANCE.convert(user));
    }

    @Transactional
    @PutMapping
    public ResponseEntity<UserResponse> replace(@RequestBody @Valid UserPutRequestBody userPutRequestBody) {
        return noContent(UserMapper.INSTANCE.convert(userService.replace(userPutRequestBody)));
    }

    @DeleteMapping(path = "/{id}")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "204", description = "Successful Operation"),
            @ApiResponse(responseCode = "400", description = "When User Does Not Exist in The Database")
    })
    public ResponseEntity<Void> delete(@PathVariable long id) {
        userService.delete(id);
        return noContent();
    }
}