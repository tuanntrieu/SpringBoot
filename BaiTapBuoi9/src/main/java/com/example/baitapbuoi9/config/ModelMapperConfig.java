package com.example.baitapbuoi9.config;

import com.example.baitapbuoi9.dto.CategoryDTO;
import com.example.baitapbuoi9.dto.ProductDTO;
import com.example.baitapbuoi9.dto.UserDTO;
import com.example.baitapbuoi9.model.Category;
import com.example.baitapbuoi9.model.Product;
import com.example.baitapbuoi9.model.User;
import org.modelmapper.ModelMapper;

import org.modelmapper.PropertyMap;
import org.modelmapper.TypeMap;
import org.modelmapper.convention.MatchingStrategies;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ModelMapperConfig {
    @Bean
    public ModelMapper modelMapper() {
        // Tạo object và cấu hình
        ModelMapper modelMapper = new ModelMapper();
        modelMapper.getConfiguration()
                .setMatchingStrategy(MatchingStrategies.STRICT);

        modelMapper.addMappings(new PropertyMap<ProductDTO, Product>() {
            @Override
            protected void configure() {
                skip(destination.getImage()); // Bỏ qua thuộc tính "id" trong đối tượng đích (DestinationClass)
            }
        });

        return modelMapper;
    }
}
