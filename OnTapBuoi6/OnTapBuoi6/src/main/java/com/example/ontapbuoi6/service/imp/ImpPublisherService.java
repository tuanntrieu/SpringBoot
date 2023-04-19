package com.example.ontapbuoi6.service.imp;

import com.example.ontapbuoi6.dto.PublisherDTO;
import com.example.ontapbuoi6.model.Author;
import com.example.ontapbuoi6.model.Book;
import com.example.ontapbuoi6.model.Publisher;
import com.example.ontapbuoi6.repo.AuthorRepository;
import com.example.ontapbuoi6.repo.PublisherRepository;
import com.example.ontapbuoi6.service.IPublisherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ImpPublisherService implements IPublisherService {

    @Autowired
    private PublisherRepository publisherRepository;

    @Autowired
    private AuthorRepository authorRepository;

    @Override
    public Publisher createNewPublisher(PublisherDTO publisherDTO) {
        Optional<Author> author = authorRepository.findById(publisherDTO.getAuthor_id());
        return author.map(value -> publisherRepository.save(new Publisher(publisherDTO.getName(), publisherDTO.getFounderYer(), value))).orElse(null);
    }

    @Override
    public List<Publisher> findAllPublisher() {
       return publisherRepository.findAll();
    }
}
