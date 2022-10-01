package br.com.apiforum.mappers;

import br.com.apiforum.domain.User;
import br.com.apiforum.request.user.UserPostRequestBody;
import br.com.apiforum.request.user.UserPutRequestBody;
import br.com.apiforum.request.user.UserResponse;
import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper(componentModel = "spring")
public abstract class UserMapper {

    public static final UserMapper INSTANCE = Mappers.getMapper(UserMapper.class);;

    public abstract UserResponse convert(User user);

    @InheritInverseConfiguration
    public abstract User convert(UserResponse useResponse);
    public abstract User toUserPost(UserPostRequestBody userPostRequestBody);
    public abstract User toUserPut(UserPutRequestBody userPutRequestBody);
    public abstract List<UserResponse> convertList(List<User> users);
}
