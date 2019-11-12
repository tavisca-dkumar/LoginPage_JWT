import { Injectable } from '@angular/core';
import { AuthenticationService } from './authentication.service';
import { CanActivate, Router,ActivatedRouteSnapshot,RouterStateSnapshot} from '@angular/router';

@Injectable({
  providedIn: 'root'
})
export class AuthGaurdService implements CanActivate {
 
  constructor(
    private loginService:AuthenticationService,
    private route:Router
  ) { }

  canActivate(route: ActivatedRouteSnapshot, state: RouterStateSnapshot) {
    if(this.loginService.isUserLoggedIn())
      return true;
    this.route.navigate(['login']);
    return false;
  }

  

}
