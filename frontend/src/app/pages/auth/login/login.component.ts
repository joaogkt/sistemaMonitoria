import { Component, OnInit } from '@angular/core';
import { Router, ActivatedRoute } from '@angular/router';
import { AuthService } from '../../../core/services/auth.service';
import {FormsModule, NgForm} from '@angular/forms';

@Component({
  selector: 'app-login',
  standalone: true,
  imports: [FormsModule],
  styleUrls: ['./login.component.css'],
  templateUrl: './login.component.html',
})

export class LoginComponent implements OnInit  {
  email = '';
  password = '';
  errorMessage = '';
  successMessage = '';

  constructor(private authService: AuthService, private router: Router, private route: ActivatedRoute) {}

  ngOnInit() {
    this.route.queryParams.subscribe(params => {
      if (params['registered'] === 'true') {
        this.successMessage = 'Registro feito com sucesso';
      }
    })
  }
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
        this.authService.saveToken(result.token);
        this.router.navigate(['home']);
      },
      error: error => {
        this.errorMessage = 'Email ou senha inválidos.';
        console.log(error);
      }
    })
  }
}
