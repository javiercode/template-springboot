package ubilapaz.edu.bo.template.web;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ubilapaz.edu.bo.template.domain.dto.UserDto;

import java.util.ArrayList;
import java.util.List;

@RestController
public class UsuarioController {

    @PostMapping("/create/")
    public ResponseEntity<String> create(@RequestBody UserDto userDto){
        //mucho contenido, para el tratamiento de la informacion
        String carnet= userDto.getCi() + "LP";
        return new ResponseEntity<String>("Usuario:"+userDto.getNombre()+" Creado"+" con ci:"+carnet, HttpStatus.OK);
    }

    @PutMapping("/edit/{id}")
    public ResponseEntity<String> create(@PathVariable("id") int id){
        //mucho contenido, para el tratamiento de la informacion
        return new ResponseEntity<String>("Usuario: "+id+" editado", HttpStatus.OK);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<String> edit(@PathVariable("id") int id){
        //mucho contenido, para el tratamiento de la informacion
        return new ResponseEntity<String>("Usuario: "+id+" eliminado", HttpStatus.OK);
    }

    @GetMapping("/users")
    public ResponseEntity<List<String>> lista(){
        List<String> aTest = new ArrayList<>();
        return new ResponseEntity<List<String>>(aTest, HttpStatus.OK);
    }
}
