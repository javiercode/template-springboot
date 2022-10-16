package ubilapaz.edu.bo.template.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ubilapaz.edu.bo.template.service.response.Response;
import ubilapaz.edu.bo.template.domain.dto.UserDto;
import ubilapaz.edu.bo.template.service.UserService;
import ubilapaz.edu.bo.template.service.response.UserResponse;

import java.util.ArrayList;
import java.util.List;

@RestController
public class UsuarioController {

    @Autowired
    private UserService userService;

    @PostMapping("/create/")
    public ResponseEntity<Response> create(@RequestBody UserDto userDto){
        //mucho contenido, para el tratamiento de la informacion
        Response reponse =userService.save(userDto);
        return new ResponseEntity<Response>(reponse, HttpStatus.OK);
    }

    @PutMapping("/edit/{id}")
    public ResponseEntity<Response> create(@PathVariable("id") int id,@RequestBody UserDto userDto){
        Response reponse =userService.edit(id,userDto);
        return new ResponseEntity<Response>(reponse, HttpStatus.OK);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Response> edit(@PathVariable("id") int id){
        Response reponse =userService.delete(id);
        return new ResponseEntity<Response>(reponse, HttpStatus.OK);
    }

    @GetMapping("/usersDto")
    public ResponseEntity<UserResponse> listaDto(){
        UserResponse reponse =userService.listDto();
        return new ResponseEntity<UserResponse>(reponse, HttpStatus.OK);
    }

    @GetMapping("/users")
    public ResponseEntity<UserResponse> lista(){
        UserResponse reponse =userService.list();
        return new ResponseEntity<UserResponse>(reponse, HttpStatus.OK);
    }
}
