package ubilapaz.edu.bo.template.web;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

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

    @GetMapping("/lista")
    public ResponseEntity<List<String>> lista(){
        List<String> aTest = new ArrayList<>();
        return new ResponseEntity<List<String>>(aTest, HttpStatus.OK);
    }
}
