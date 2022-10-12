package ubilapaz.edu.bo.template.web;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TestController {

    @GetMapping("/test")
    public ResponseEntity<String> test(){

        return new ResponseEntity<String>("Hola mundo!!", HttpStatus.OK);
    }

    @PostMapping("/test")
    public ResponseEntity<String> test2(){
        return new ResponseEntity<String>("Ejemplo de POST", HttpStatus.OK);
    }
}
