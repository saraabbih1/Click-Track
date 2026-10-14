
package ma.youcode.clicktrack.service;

import ma.youcode.clicktrack.entity.Publisher;
import ma.youcode.clicktrack.repository.PublisherRepository;

import java.util.List;

public class PublisherService {

    private final PublisherRepository publisherRepository;

    public PublisherService(PublisherRepository publisherRepository) {

        this.publisherRepository = publisherRepository;
    }

    public List<Publisher> findAll() {
        return publisherRepository.findAll();}
        public Publisher save(Publisher publisher){
           return publisherRepository.save(publisher);
        }
    }

