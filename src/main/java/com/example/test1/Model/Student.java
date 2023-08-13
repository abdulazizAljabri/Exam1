package com.example.test1.Model;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Student {
    @NotEmpty(message = "should not be empty")
    private String id;
    @NotEmpty(message = "should not be empty")
    private String name;
    @NotNull(message = "should not be null")
    private Integer age;
    @NotEmpty(message = "should not be empty")
    private String major;
}
