import { Component } from '@angular/core';
import { Accountservice } from '../accountservice';
import { ActivatedRoute } from '@angular/router';
import { Router } from '@angular/router';

@Component({
  selector: 'app-get-balance',
  standalone: false,
  templateUrl: './get-balance.html',
  styleUrl: './get-balance.css',
  
})
export class GetBalance {
  
  balance:number = 0;
  errorMessage: string = '';
  showBackButton: boolean = false;
  constructor(
    private service: Accountservice,
    private route: ActivatedRoute,
    private router: Router
  ) {}

  ngOnInit(): void {
    const id = this.route.snapshot.paramMap.get('id');
    if (id) {
      const numId = Number(id);
      this.service.getBalance(numId).subscribe(
        (data) => {
          this.balance = data.balance;  
          this.showBackButton = true;
        }
      );
    } else {
      alert("No account with such Id Found.")
      console.error('No ID provided');
    }

    
  }

  navigate():void{
    this.router.navigate(['']); 
  }
  



}


