package com.example.reactive.dto;


import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.validator.constraints.Length;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class GetMdRequestDto {

    @NotBlank(message = "MdNumber is required")
    @Pattern(regexp = "^[a-zA-Z0-9 ._-]*$", message = "MdNumber must not contain special character(s)")
    @Length(max = 12, message = "Max length MdNumber is 12")
    private String mdNumber;
}
