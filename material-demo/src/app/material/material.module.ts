import { NgModule } from '@angular/core';
import { MatButtonModule } from '@angular/material/button';
import {MatToolbarModule} from '@angular/material/toolbar';
import {MatCardModule} from '@angular/material/card';
import {MatFormFieldModule} from '@angular/material/form-field';
import {MatInputModule} from '@angular/material/input';
import {MatCheckboxModule} from '@angular/material/checkbox';
import {MatMenuModule} from '@angular/material/menu';

const materialComponent=[MatButtonModule,
                         MatToolbarModule,
                         MatCardModule,
                         MatFormFieldModule,
                         MatInputModule,
                         MatCheckboxModule,
                         MatMenuModule];
@NgModule({

  
  imports: [
    materialComponent
  ],
  exports:[
    materialComponent
  ]
})
export class MaterialModule { }
