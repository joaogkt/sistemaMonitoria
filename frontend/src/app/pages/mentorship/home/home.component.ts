import { Component, OnInit } from '@angular/core';
import { CommonModule } from '@angular/common';
import { RouterModule, Router } from '@angular/router';
import { NavbarComponent } from '../navbar/navbar.component';
import { AuthService} from '../../../core/services/auth.service';

@Component({
  selector: 'app-home',
  templateUrl: './home.component.html',
  styleUrls: ['./home.component.css'],
  standalone: true,
  imports: [CommonModule, RouterModule, NavbarComponent]
})

export class HomeComponent {
  constructor(private authService: AuthService, private router: Router) {}
  userRole = ''
  ngOnInit() {
    const token = this.authService.getToken();
    if (token) {
      const payload: any = this.authService.decodeToken(token);
      this.userRole = payload.role || 'Usuário';
      console.log(this.userRole);
      console.log(payload);
      console.log(payload.role);
    }
  }
}
