import { Component } from '@angular/core';
import { Account } from '../account';
import { Accountservice } from '../accountservice';
import { ActivatedRoute } from '@angular/router';
import { Router } from '@angular/router';

@Component({
  selector: 'app-get-details',
  standalone: false,
  templateUrl: './get-details.html',
  styleUrl: './get-details.css',
})
export class GetDetails {

  details:Account | undefined;
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
      this.service.getDetails(numId).subscribe(
        (data) => {
          this.details = data;  
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

