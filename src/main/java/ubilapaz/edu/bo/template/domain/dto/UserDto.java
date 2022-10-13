package ubilapaz.edu.bo.template.domain.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UserDto {
    private String username;
    private String password;
    private String nombre;
    private int ci;
}
