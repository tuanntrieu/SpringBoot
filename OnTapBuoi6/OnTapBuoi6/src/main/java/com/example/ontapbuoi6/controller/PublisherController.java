package com.example.ontapbuoi6.controller;

import com.example.ontapbuoi6.dto.PublisherDTO;
import com.example.ontapbuoi6.service.IPublisherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/publisher")
public class PublisherController {

    @Autowired
    private IPublisherService publisherService;

    @PostMapping("/create_publisher")
    public ResponseEntity<?> createNewPublisher(@RequestBody PublisherDTO publisherDTO) {
        return ResponseEntity.ok(publisherService.createNewPublisher(publisherDTO));
    }


    @GetMapping("/get_all_publisher")
    public ResponseEntity<?> getAllPublisher() {
        return ResponseEntity.ok(publisherService.findAllPublisher());
    }

}
