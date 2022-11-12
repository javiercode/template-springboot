package ubilapaz.edu.bo.template.domain.dto;

import lombok.Getter;
import lombok.Setter;
import ubilapaz.edu.bo.template.domain.User;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
public class UserResponse extends Response{
    List<User> users = new ArrayList<>();
    List<UserDto> userDtos = new ArrayList<>();
}
