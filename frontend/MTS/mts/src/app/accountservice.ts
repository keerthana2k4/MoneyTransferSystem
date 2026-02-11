import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Account } from './account';

@Injectable({
  providedIn: 'root',
})
export class Accountservice {

  EMPURI = "http://localhost:8080/api/v1/account"

  constructor(private http:HttpClient){}

  getDetails(id: number) {
    const url = `${this.EMPURI}/${id}`; 
    return this.http.get<Account>(url); 
  }

  getBalance(id:number){
    const url = `${this.EMPURI}/${id}`; 
    return this.http.get<any>(url);
  }

  
}
