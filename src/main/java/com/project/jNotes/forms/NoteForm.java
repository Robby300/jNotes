package com.project.jNotes.forms;

import lombok.Data;
import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.NotEmpty;

@Data
public class NoteForm {
    @NotEmpty
    @Length(max = 511)
    private String text;

}
