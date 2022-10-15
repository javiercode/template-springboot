package ubilapaz.edu.bo.template.domain.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
//@AllArgsConstructor
public class UserDto {
    private String username;
    private String password;
    private String nombre;

    public UserDto(String username, String password, String nombre) {
        this.username = username;
        this.password = password;
        this.nombre = nombre;
    }
}
