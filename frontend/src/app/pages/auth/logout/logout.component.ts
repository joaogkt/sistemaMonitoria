// src/app/auth/components/logout.component.ts
import { Component, inject } from '@angular/core';
import { Router } from '@angular/router';
import { AuthService} from '../../../core/services/auth.service';

@Component({
  standalone: true,
  template: ''
})
export default class LogoutComponent {
  private authService = inject(AuthService);
  private router = inject(Router);

  constructor() {
    this.authService.logout();
    this.router.navigate(['/login']);
  }
}
