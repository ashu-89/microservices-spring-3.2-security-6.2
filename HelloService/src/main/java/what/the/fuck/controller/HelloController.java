package what.the.fuck.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/home")
public class HelloController {

    @GetMapping
    public ResponseEntity<String> hello(){
        return new ResponseEntity<>("hello wrlD", HttpStatus.OK);
    }
}
