package com.mohamedkh.productservice.DTOs;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor @Data
public class ErrorResponse {

    private String code;
    private String message;

}
