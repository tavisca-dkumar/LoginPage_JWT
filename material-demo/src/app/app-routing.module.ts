import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import { LoginComponent } from './login/login.component';
import { LogoutComponent } from './logout/logout.component';
import { HomeComponent } from './home/home.component';
import { AuthGaurdService } from './auth-gaurd.service';


const routes: Routes = [
  {path:"login",component:LoginComponent},
  {path:"logout",component:LogoutComponent,canActivate:[AuthGaurdService]},
  {path:"home",component:HomeComponent,canActivate:[AuthGaurdService]}
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
