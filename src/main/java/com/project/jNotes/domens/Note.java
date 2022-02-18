package com.project.jNotes.domens;

import lombok.*;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "note")
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Getter
@Setter
public class Note {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String text;
    private LocalDateTime creationTime;


}
