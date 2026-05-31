package com.example.demo1.dto;

import jakarta.validation.Valid;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@EqualsAndHashCode(exclude = {"id"})
@AllArgsConstructor
@NoArgsConstructor
public class Book {
    @NotNull
    @Min(1)
    @Max(100)
    private Integer id;

    @NotBlank
    private String name;

    @NotNull
    @Valid
    private Author author;

    @NotBlank
    @Email(message = "Email format must be correct")
    private String email;

    @NotEmpty
    List<String> tags;
}
