import { Component } from '@angular/core';
import { Router } from '@angular/router';
import { AuthService } from '../services/auth.service';
import {FormsModule} from '@angular/forms';

@Component({
  selector: 'app-login',
  // templateUrl: './login.component.html',
  imports: [FormsModule],
  template: `
    <h2>Login</h2>
    <form (submit)="login()">
      <label>
        Email:
<input type="email" [(ngModel)]="email" name="email" required />
</label>
<br />
<label>
  Senha:
<input type="password" [(ngModel)]="password" name="password" required />
</label>
<br />
<button type="submit">Entrar</button>
</form>
    @if (errorMessage) {
      <p style="color: red">{{ errorMessage }}</p>
    }
  `,
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
