import { Component, OnInit } from '@angular/core';
import { AuthenticationService } from '../authentication.service';

@Component({
  selector: 'app-tool-bar',
  templateUrl: './tool-bar.component.html',
  styleUrls: ['./tool-bar.component.css']
})
export class ToolBarComponent implements OnInit {
  username: string;
  loggedIn: boolean = false;
  constructor(private loginService : AuthenticationService) {
   }
  

  ngOnInit() {
    this.username= this.loginService.getUser();
    this.loggedIn = this.loginService.isUserLoggedIn();
    console.log(this.loggedIn);
  }

}
