package com.example.demo1.dto;


import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Past;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Author {
    @NotBlank
    private String fullname;
    @Past
    private LocalDate birthDate;
}
