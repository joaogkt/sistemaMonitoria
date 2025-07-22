import { Injectable } from '@angular/core';
import {
  ActivatedRouteSnapshot,
  CanActivate, GuardResult, MaybeAsync,
  Router, RouterStateSnapshot,
  UrlTree
} from '@angular/router';
import { AuthService } from '../services/auth.service';

@Injectable({providedIn: 'root'})
export class AuthGuard implements CanActivate {
  constructor(private authService: AuthService, private router: Router) { }

  canActivate(): boolean | UrlTree {
    if (this.authService.isAuthenticated()) {
      return true;
    }
    console.log("Nao autenticado")
    return this.router.parseUrl('/login');
  }

}
