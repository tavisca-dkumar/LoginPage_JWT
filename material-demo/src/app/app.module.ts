import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { BrowserAnimationsModule } from '@angular/platform-browser/animations';
import { MaterialModule } from './material/material.module';
import { ToolBarComponent } from './tool-bar/tool-bar.component';
import { LoginComponent } from './login/login.component';
import { RouterModule } from '@angular/router';
import { LogoutComponent } from './logout/logout.component';
import { HomeComponent } from './home/home.component';
import { FormsModule} from '@angular/forms';
import { HttpClientModule } from '@angular/common/http';

@NgModule({
  declarations: [
    AppComponent,
    ToolBarComponent,
    LoginComponent,
    LogoutComponent,
    HomeComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    HttpClientModule,
    BrowserAnimationsModule,
    MaterialModule,
    FormsModule,
    RouterModule.forRoot([
      { path: '',redirectTo:'/',pathMatch:'full'},
      { path: 'login', component: LoginComponent}
    ])
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
