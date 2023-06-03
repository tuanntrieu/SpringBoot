package com.example.baitapbuoi9.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.web.multipart.MultipartFile;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class ProductDTO {
    @NotEmpty(message = "name is not empty")
    private String product_name;

    @Min(1)
    private int count;

    MultipartFile multipartFile;

    private String description;

    private int category_id;
}
