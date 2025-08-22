import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { environment } from '../../../environments/environment';
import { jwtDecode } from 'jwt-decode';

@Injectable({ providedIn: 'root' })
export class AuthService {
  private tokenKey = 'auth_token';

  constructor(private http: HttpClient) {}

  login(credentials: { email: string; password: string }) {
    return this.http.post<{ token: string }>(`${environment.apiUrl}/auth/login`, credentials);
  }

  register(credentials: { name:string, email: string, password: string, role: string }) {
    return this.http.post(`${environment.apiUrl}/users`, credentials);
  }

  saveToken(token: string) {
    localStorage.setItem(this.tokenKey, token);
  }

  getToken() {
    return localStorage.getItem(this.tokenKey);
  }

  decodeToken(token: string): any {
    return jwtDecode(token);
  }

  hasAccess(role: string): boolean {
    return ['TEACHER', 'ADMIN'].includes(role);
  }

  isAuthenticated(): boolean {
    const token = this.getToken();
    if (!token) return false;
    const { exp }: any = jwtDecode(token);
    return Date.now() < exp * 1000;
  }

  logout() {
    localStorage.removeItem(this.tokenKey);
  }

}
