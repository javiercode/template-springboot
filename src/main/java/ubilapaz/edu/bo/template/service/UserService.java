package ubilapaz.edu.bo.template.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ubilapaz.edu.bo.template.domain.User;
import ubilapaz.edu.bo.template.service.response.Response;
import ubilapaz.edu.bo.template.domain.dto.UserDto;
import ubilapaz.edu.bo.template.persistence.UserJpaRepository;
import ubilapaz.edu.bo.template.service.response.UserResponse;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class UserService {

    @Autowired
    private UserJpaRepository userJpaRepository;
    public Response save(UserDto userDto){
        Response respuesta = new Response(false,"Salio un error");

        try{
            User user = new User();
            user.setNombre(userDto.getNombre());
            user.setUsername(userDto.getUsername());
            user.setPassword(userDto.getPassword());
            user = userJpaRepository.save(user);

            respuesta = new Response(true,"Usuario Registrado");
        }catch (Exception e){

        }


        return respuesta;
    }
    public Response edit(Integer id, UserDto userDto){

        User user = userJpaRepository.getById(id);
        user.setNombre(userDto.getNombre());
        user.setUsername(userDto.getUsername());
        user.setPassword(userDto.getPassword());
        user.setFechaModificacion(LocalDateTime.now());
        user = userJpaRepository.save(user);
        return new Response(true,"Usuario Modificado");
    }

    public UserResponse list(){
        UserResponse userResponse = new UserResponse();
        List<User> userList = userJpaRepository.findAll();
        userResponse.setMensaje("");
        userResponse.setSuccess(true);
        userResponse.setUsers(userList);
        return userResponse;
    }

    public UserResponse listDto(){
        UserResponse userResponse = new UserResponse();
        List<UserDto> userList = userJpaRepository.obtenerLista();
        userResponse.setMensaje("");
        userResponse.setSuccess(true);
        userResponse.setUserDtos(userList);
        return userResponse;
    }


    public Response delete(Integer id){

        userJpaRepository.deleteById(id);
        return new Response(true,"Usuario Eliminado");
    }
}
