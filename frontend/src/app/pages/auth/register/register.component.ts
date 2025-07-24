import { Component } from '@angular/core';
import { Router } from '@angular/router';
import { AuthService } from '../../../core/services/auth.service';
import {FormsModule, NgForm} from '@angular/forms';
import { ROLE_TYPE } from '../../../core/enums/role-type.enum';

@Component({
  selector: 'app-login',
  standalone: true,
  imports: [FormsModule],
  styleUrls: ['./register.component.css'],
  templateUrl: './register.component.html',
})

export class RegisterComponent  {
  name = '';
  email = '';
  password = '';
  role = '';
  errorMessage = '';

  constructor(private authService: AuthService, private router: Router) {}
  register(form: NgForm) {
    if (form.invalid) {
      return;
    }
    if (this.role == 'teacher') {
      this.role = ROLE_TYPE.teacher;
    } else if (this.role == 'student') {
      this.role = ROLE_TYPE.student;
    } else {
      this.role = ROLE_TYPE.admin;
    }
    const credentials = {
      name: this.name,
      email: this.email,
      password: this.password,
      role: this.role,
    };

    console.log(credentials);

    this.authService.register(credentials).subscribe({
      next: result => {
        this.router.navigate(['login'], { queryParams: { registered: 'true' } });
        console.log(result);
      },
      error: error => {
        this.errorMessage = 'Algo deu errado.';
        console.log(error);
      }
    })
  }
}
