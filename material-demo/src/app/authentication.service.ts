import { Injectable } from '@angular/core';
import {HttpClient} from '@angular/common/http';

@Injectable({
  providedIn: 'root'
})
export class AuthenticationService {

  constructor(private http:HttpClient) { }

  authenticate(username,password){
    // if(username === "siva546" && password === "siva@546"){
    //   sessionStorage.setItem('username',username);
    //   return true;
    // }
    // else
    //   return false;
    return this.http.post('http://localhost:8080/authenticate',{
      username:username,
      password:password
    })

  }

getUser(){
  return sessionStorage.getItem('username');
}

  isUserLoggedIn(){
    let user = sessionStorage.getItem('username');
    return !(user === null);
  }

  logOut(){
    sessionStorage.removeItem('username');
    sessionStorage.removeItem('token');
  }

}
