import { Routes } from '@angular/router';
import { LoginComponent } from './pages/auth/components/login.component';

export const routes: Routes = [
  { path: 'login', component: LoginComponent },
  { path: '', redirectTo: '/login', pathMatch: 'full' },
];
