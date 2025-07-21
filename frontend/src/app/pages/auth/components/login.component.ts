import { Component } from '@angular/core';
import { Router } from '@angular/router';
import { AuthService } from '../../../core/services/auth.service';
import {FormsModule} from '@angular/forms';

@Component({
  selector: 'app-login',
  imports: [FormsModule],
  styleUrls: ['./login.component.css'],
  templateUrl: './login.component.html',
})

export class LoginComponent  {
  email = '';
  password = '';
  errorMessage = '';
  credentials = { email: '', password: '' };

  constructor(private authService: AuthService, private router: Router) {}
  login() {
    this.authService.login(this.credentials).subscribe({
      next: result => {
        this.router.navigate(['/']);
      },
      error: error => {
        this.errorMessage = error;
        console.log(error);
      }
    })
  }
}
