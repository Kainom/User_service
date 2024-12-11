package kainom.user_service.patterns;

import kainom.user_service.dto.UserDTO;
import kainom.user_service.model.User;

public interface IUserAdapter {

    UserDTO adaptToDto(User user);

    User adaptToModel(UserDTO userDto);

}
