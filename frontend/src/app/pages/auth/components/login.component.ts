import { Component } from '@angular/core';
import { Router } from '@angular/router';
import { AuthService } from '../../../core/services/auth.service';
import {FormsModule, NgForm} from '@angular/forms';

@Component({
  selector: 'app-login',
  standalone: true,
  imports: [FormsModule],
  styleUrls: ['./login.component.css'],
  templateUrl: './login.component.html',
})

export class LoginComponent  {
  email = '';
  password = '';
  errorMessage = '';

  constructor(private authService: AuthService, private router: Router) {}
  login(form: NgForm) {
    if (form.invalid) {
      return;
    }

    const credentials = {
      email: this.email,
      password: this.password
    };

    this.authService.login(credentials).subscribe({
      next: result => {
        this.router.navigate(['/']);
        console.log(result);
      },
      error: error => {
        this.errorMessage = 'Email ou senha inválidos.';
        console.log(error);
      }
    })
  }
}
