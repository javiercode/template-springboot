package ubilapaz.edu.bo.template.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ubilapaz.edu.bo.template.domain.User;
import ubilapaz.edu.bo.template.persistence.UserJpaRepository;
import ubilapaz.edu.bo.template.domain.dto.Response;
import ubilapaz.edu.bo.template.domain.dto.UserDto;
import ubilapaz.edu.bo.template.domain.dto.UserResponse;

import java.time.LocalDateTime;
import java.util.List;

@RestController
@RequestMapping("/user")
public class UsuarioController {

    @Autowired
    private UserJpaRepository userJpaRepository;

    @PostMapping("/create/")
    public ResponseEntity<Response> create(@RequestBody UserDto userDto){
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
        return new ResponseEntity<Response>(respuesta, HttpStatus.OK);
    }

    @PutMapping("/edit/{id}")
    public ResponseEntity<Response> create(@PathVariable("id") int id,@RequestBody UserDto userDto){
        User user = userJpaRepository.getById(id);
        user.setNombre(userDto.getNombre());
        user.setUsername(userDto.getUsername());
        user.setPassword(userDto.getPassword());
        user.setFechaModificacion(LocalDateTime.now());
        user = userJpaRepository.save(user);
        Response reponse = new Response(true,"Usuario Modificado");
        return new ResponseEntity<Response>(reponse, HttpStatus.OK);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Response> edit(@PathVariable("id") int id){
        userJpaRepository.deleteById(id);
        Response reponse = new Response(true,"Usuario Eliminado");
        return new ResponseEntity<Response>(reponse, HttpStatus.OK);
    }

    @GetMapping("/usersDto")
    public ResponseEntity<UserResponse> listaDto(){
        UserResponse reponse = new UserResponse();
        List<UserDto> userList = userJpaRepository.obtenerLista();
        reponse.setMensaje("");
        reponse.setSuccess(true);
        reponse.setUserDtos(userList);
        return new ResponseEntity<UserResponse>(reponse, HttpStatus.OK);
    }

    @GetMapping("/users")
    public ResponseEntity<UserResponse> lista(){
        UserResponse reponse = new UserResponse();
        List<User> userList = userJpaRepository.findAll();
        reponse.setMensaje("Registros obtenidos");
        reponse.setSuccess(true);
        reponse.setUsers(userList);
        return new ResponseEntity<UserResponse>(reponse, HttpStatus.OK);
    }
}
