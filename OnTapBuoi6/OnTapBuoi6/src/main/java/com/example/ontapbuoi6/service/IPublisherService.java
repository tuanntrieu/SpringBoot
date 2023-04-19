package com.example.ontapbuoi6.service;

import com.example.ontapbuoi6.dto.PublisherDTO;
import com.example.ontapbuoi6.model.Publisher;

import java.util.List;

public interface IPublisherService {

    Publisher createNewPublisher(PublisherDTO publisherDTO);

    List<Publisher> findAllPublisher();
}
