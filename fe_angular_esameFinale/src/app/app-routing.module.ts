import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { ProvaComponent } from './components/prova/prova.component';

const routes: Routes = [
    {path:'', redirectTo:'/homepage', pathMatch:'full'},
    {path:'homepage', component: ProvaComponent},
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
