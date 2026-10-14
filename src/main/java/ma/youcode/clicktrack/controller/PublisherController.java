package ma.youcode.clicktrack.controller;

import ma.youcode.clicktrack.entity.Publisher;
import ma.youcode.clicktrack.service.PublisherService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;
import java.util.List;

@RestController
@RequestMapping("/api/publishers")
public class PublisherController {
    private final PublisherService publisherService;
    public PublisherController(PublisherService publisherService) {
        this.publisherService = publisherService;
    }
    @GetMapping
    public List<Publisher> findAll() {
        return publisherService.findAll();
    }
//    @GetMapping
//    @ResponseStatus(HttpStatus.CREATED)
//    public Publisher create(@RequestBody Publisher publisher){
//        return publisher;
//    }
    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Publisher create(@RequestBody Publisher publisher) {
        return publisherService.save(publisher);
    }
}