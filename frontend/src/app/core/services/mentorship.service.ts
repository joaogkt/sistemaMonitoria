import { Injectable } from '@angular/core';
import {HttpClient, HttpHeaders} from '@angular/common/http';
import { Observable } from 'rxjs';
import {environment} from '../../../environments/environment';
import {AuthService} from './auth.service';

export interface MentorshipDTO {
  title: string;
  description: string;
  subject: string;
  createdById: string;
  type: string;
  contactLink: string;
}

@Injectable({
  providedIn: 'root'
})
export class MentorshipService {
  private readonly API_URL = `${environment.apiUrl}/mentorships`;

  constructor(private http: HttpClient, private authService: AuthService) { }



  createMentorship(dto: MentorshipDTO): Observable<any> {
    const headers = new HttpHeaders({
      'Authorization': `Bearer ${this.authService.getToken()}`
    });

    return this.http.post(this.API_URL, dto, { headers });
  }
}
