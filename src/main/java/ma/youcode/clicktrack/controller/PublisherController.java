package ma.youcode.clicktrack.controller;

import ma.youcode.clicktrack.entity.Publisher;
import ma.youcode.clicktrack.service.PublisherService;
import ma.youcode.clicktrack.service.LienService;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import ma.youcode.clicktrack.entity.Lien;

import java.util.List;

@RestController
@RequestMapping("/api/publishers")
public class PublisherController {

    private final PublisherService publisherService;
    private final LienService lienService;

    public PublisherController(PublisherService publisherService,
                               LienService lienService) {
        this.publisherService = publisherService;
        this.lienService = lienService;
    }

    @GetMapping
    public List<Publisher> findAll() {
        return publisherService.findAll();
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Publisher create(@RequestBody Publisher publisher) {
        return publisherService.save(publisher);
    }

    @GetMapping("/{id}")
    public Publisher findById(@PathVariable("id") int id) {
        return publisherService.findById(id);
    }

    @GetMapping("/{id}/liens")
    public List<Lien> findLiensByPublisherId(
            @PathVariable("id") int id) {
        return lienService.findByPublisherId(id);
    }


    @PostMapping("/{id}/liens")
    @ResponseStatus(HttpStatus.CREATED)
    public Lien createLien(
            @PathVariable("id") int publisherId,
            @RequestBody Lien lien) {

        return lienService.create(
                publisherId,
                lien.getOffre(),
                lien.getUrlDestination()
        );
    }

}