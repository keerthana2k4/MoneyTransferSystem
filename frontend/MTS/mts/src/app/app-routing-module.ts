import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { GetDetails } from './get-details/get-details';
import { GetBalance } from './get-balance/get-balance';
import { Accountinfo } from './accountinfo/accountinfo';

const routes: Routes = [
  {path:'getDetails/:id',component:GetDetails},
  {path:'getBalance/:id',component:GetBalance},
  {path:'',component:Accountinfo}
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
