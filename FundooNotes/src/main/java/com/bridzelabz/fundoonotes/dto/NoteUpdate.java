package com.bridzelabz.fundoonotes.dto;

import java.time.LocalDateTime;

import lombok.Data;

@Data
public class NoteUpdate {

	private String title;

	private String description;

	private LocalDateTime updateDate;

}
