import { NgModule } from '@angular/core';
import { FormsModule } from '@angular/forms';
import { BrowserModule } from '@angular/platform-browser';
import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { HomepageComponent } from './components/homepage/homepage.component';
import { ArticoliComponent } from './components/articoli/articoli.component';
import { TariffeComponent } from './components/tariffe/tariffe.component';
import { OrdiniComponent } from './components/ordini/ordini.component';

@NgModule({
  declarations: [
    AppComponent,
    HomepageComponent,
    ArticoliComponent,
    TariffeComponent,
    OrdiniComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    FormsModule,
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
