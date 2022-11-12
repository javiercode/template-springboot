package ubilapaz.edu.bo.template.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ubilapaz.edu.bo.template.domain.Libro;
import ubilapaz.edu.bo.template.domain.dto.LibroDto;
import ubilapaz.edu.bo.template.persistence.LibroJpaRepository;
import ubilapaz.edu.bo.template.domain.dto.Response;

@RestController
@RequestMapping("/libro")
public class LibroController {

    @Autowired
    private LibroJpaRepository repository;

    @PostMapping("/create/")
    public ResponseEntity<Response> create(@RequestBody LibroDto libroDto){
        Response reponse = new Response(false,"Salio un error");
        try{
            Libro libro = new Libro();
            libro.setAutor(libroDto.getAutor());
            libro.setTitulo(libroDto.getTitulo());
            libro.setFormato(libroDto.getFormato());
            libro.setEditorial(libroDto.getEditorial());
            libro = repository.save(libro);
            reponse = new Response(true,"Libro Registrado");
        }catch (Exception e){
            System.out.println(e);
        }
        return new ResponseEntity<Response>(reponse, HttpStatus.OK);
    }
/*
    @PutMapping("/edit/{id}")
    public ResponseEntity<Response> create(@PathVariable("id") int id,@RequestBody UserDto userDto){
        Response reponse = libroService.edit(id,userDto);
        return new ResponseEntity<Response>(reponse, HttpStatus.OK);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Response> edit(@PathVariable("id") int id){
        Response reponse = libroService.delete(id);
        return new ResponseEntity<Response>(reponse, HttpStatus.OK);
    }

    @GetMapping("/usersDto")
    public ResponseEntity<UserResponse> listaDto(){
        UserResponse reponse = libroService.listDto();
        return new ResponseEntity<UserResponse>(reponse, HttpStatus.OK);
    }

    @GetMapping("/users")
    public ResponseEntity<UserResponse> lista(){
        UserResponse reponse = libroService.list();
        return new ResponseEntity<UserResponse>(reponse, HttpStatus.OK);
    }*/
}
