import { Component, OnInit } from '@angular/core';
import { CommonModule } from '@angular/common';
import { RouterModule, Router } from '@angular/router';
import { NavbarComponent } from '../navbar/navbar.component';
import { AuthService} from '../../../core/services/auth.service';
import {FormsModule, NgForm} from '@angular/forms';
import {MentorshipDTO, MentorshipService} from '../../../core/services/mentorship.service';


@Component({
  selector: 'app-createMentorship',
  templateUrl: './createMentorship.component.html',
  styleUrls: ['./createMentorship.component.css'],
  standalone: true,
  imports: [CommonModule, RouterModule, NavbarComponent, FormsModule]
})

export class CreateMentorshipComponent implements OnInit {
  constructor(
    private authService: AuthService,
    private router: Router,
    private mentorshipService: MentorshipService,
  ) {}
  userRole = ''
  mentorship: MentorshipDTO = {
    title: '',
    description: '',
    subject: '',
    type: '',
    contactLink: '',
    created_by: '',
  };
  ngOnInit() {
    const token = this.authService.getToken();
    if (token) {
      const payload: any = this.authService.decodeToken(token);
      if (!this.authService.hasAccess(payload.role)) {
        this.router.navigate(['/']);
        return;
      }
      console.log(payload);
      this.mentorship.created_by = payload.name || 'Anonymous';
      this.userRole = payload.role || 'Usuário';
    }
  }
  createMentorship()
  {

    this.mentorshipService.createMentorship(this.mentorship).subscribe({
      next: () => {
        alert('Monitoria criada com sucesso!');
        this.router.navigate(['/home']);
      },
      error: (err) => {
        console.error('Erro ao criar monitoria:', err);
        alert('Erro ao criar monitoria');
      }
    });
  }
}
