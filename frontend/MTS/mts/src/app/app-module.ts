import { NgModule, provideBrowserGlobalErrorListeners } from '@angular/core';
import { BrowserModule, provideClientHydration, withEventReplay } from '@angular/platform-browser';
import { FormsModule } from '@angular/forms';
import { AppRoutingModule } from './app-routing-module';
import { App } from './app';
import { GetDetails } from './get-details/get-details';
import { GetBalance } from './get-balance/get-balance';
import { Accountinfo } from './accountinfo/accountinfo';

@NgModule({
  declarations: [
    App,
    GetDetails,
    GetBalance,
    Accountinfo
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    FormsModule
  ],
  providers: [
    provideBrowserGlobalErrorListeners(),
    provideClientHydration(withEventReplay()),
  ],
  bootstrap: [App]
})
export class AppModule { }
