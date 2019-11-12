package login.web;

import login.entity.UserDao;
//import login.service.LoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class LoginController {

    @Autowired
    //LoginService service;
    
    @GetMapping("/hello")
    public String abc() {
    	return "hello";
    }
    
//    @PostMapping("/login")
//    public ResponseEntity<Boolean> AdminValidation(@RequestBody UserDao admin){
//
//        return new ResponseEntity<>(service.validation(admin), HttpStatus.OK);
//
//    }
}
