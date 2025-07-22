import { Routes } from '@angular/router';
import { LoginComponent } from './pages/auth/login/login.component';
import {RegisterComponent} from './pages/auth/register/register.component';
import {HomeComponent} from './pages/mentorship/home/home.component';
import { AuthGuard } from './core/guard/auth.guard';

export const routes: Routes = [
  { path: 'login', component: LoginComponent },
  { path: '', redirectTo: '/home', pathMatch: 'full' },
  { path: 'register', component: RegisterComponent },
  { path: 'home', component: HomeComponent, canActivate: [AuthGuard] },
];
