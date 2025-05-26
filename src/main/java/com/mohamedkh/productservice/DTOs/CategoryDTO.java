package com.mohamedkh.productservice.DTOs;
import lombok.Builder;
import lombok.Data;

import java.util.Set;

@Builder
@Data
public class CategoryDTO {
    private long id;
    private String name;

}
