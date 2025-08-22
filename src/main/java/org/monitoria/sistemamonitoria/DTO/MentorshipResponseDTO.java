package org.monitoria.sistemamonitoria.DTO;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.monitoria.sistemamonitoria.Models.Mentorship;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class MentorshipResponseDTO {
    private Long id;
    private String title;
    private String subject;
    private String contactLink;
    private String createdByName;

    public MentorshipResponseDTO(Mentorship mentorship) {
        this.id = mentorship.getId();
        this.title = mentorship.getTitle();
        this.subject = mentorship.getSubject();
        this.contactLink = mentorship.getContactLink();
        this.createdByName = mentorship.getCreatedBy().getEmail();
    }
}
