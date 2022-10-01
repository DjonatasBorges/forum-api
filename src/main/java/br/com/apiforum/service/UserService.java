package br.com.apiforum.service;


import br.com.apiforum.domain.User;
import br.com.apiforum.mappers.UserMapper;
import br.com.apiforum.repository.UserRepository;
import br.com.apiforum.request.user.UserPostRequestBody;
import br.com.apiforum.request.user.UserPutRequestBody;
import br.com.apiforum.request.user.UserResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class UserService {
    private final UserRepository userRepository;

    public List<UserResponse> findAll() {
        List<User> users;
        users = userRepository.findAll();
        return UserMapper.INSTANCE.convertList(users);
    }

    public User save(UserPostRequestBody userPostRequestBody) {
        return userRepository.save(UserMapper.INSTANCE.toUserPost(userPostRequestBody));
    }
    public UserResponse findByIdOrThrowBadRequestException(long id) {
        User user;
        user = userRepository.findById(id).get();
        return UserMapper.INSTANCE.convert(user);
    }

    public User replace(UserPutRequestBody userPutRequestBody) {
        UserResponse savedUser = findByIdOrThrowBadRequestException(userPutRequestBody.getId());
        User user = UserMapper.INSTANCE.toUserPut(userPutRequestBody);
        user.setId(savedUser.getId());
        return userRepository.save(user);
    }

    public void delete(long id) {
        userRepository.deleteById(id);
    }
}
