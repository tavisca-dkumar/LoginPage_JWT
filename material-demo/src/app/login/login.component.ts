import { Component, OnInit } from '@angular/core';
import { AuthenticationService } from '../authentication.service';
import { Router } from '@angular/router';

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css']
})
export class LoginComponent implements OnInit {

  public username="";
  public password="";
  //public invalidLogin=false;
  public error=false;
  constructor(private loginService : AuthenticationService,private router: Router) { }

  ngOnInit() {
  }

  checkLogin(){
   // this.invalidLogin=true;
    this.loginService.authenticate(this.username,this.password).subscribe(
      data =>{
        sessionStorage.setItem('username',this.username);
        let token='Bearer ' + data["jwtToken"];
        sessionStorage.setItem('token',token);
        this.router.navigate(['home']);
        //this.invalidLogin=false
      },
      err =>{
        console.log("invalid username or password");
        this.error=true;
      }
    );
    
    
      
  }

}
