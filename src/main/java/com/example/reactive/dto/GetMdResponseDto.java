package com.example.reactive.dto;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class GetMdResponseDto {
    private String mdCurrency;
    private String mdNumber;
}
