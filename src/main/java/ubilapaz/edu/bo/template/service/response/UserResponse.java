package ubilapaz.edu.bo.template.service.response;

import lombok.Getter;
import lombok.Setter;
import ubilapaz.edu.bo.template.domain.User;
import ubilapaz.edu.bo.template.domain.dto.UserDto;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
public class UserResponse extends Response{
    List<User> users = new ArrayList<>();
    List<UserDto> userDtos = new ArrayList<>();
}
