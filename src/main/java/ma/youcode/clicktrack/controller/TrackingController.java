
package ma.youcode.clicktrack.controller;

import ma.youcode.clicktrack.entity.Lien;
import ma.youcode.clicktrack.entity.Publisher;
import ma.youcode.clicktrack.service.LienService;
import ma.youcode.clicktrack.service.PublisherService;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.LinkedHashMap;
import java.util.Map;

@RestController
public class TrackingController {

    private final LienService lienService;
    private final PublisherService publisherService;

    public TrackingController(LienService lienService,
                              PublisherService publisherService) {
        this.lienService = lienService;
        this.publisherService = publisherService;
    }
    @GetMapping("/test-tracking")
    public String testTracking() {
        return "TrackingController works";
    }
   @GetMapping("/t/{id}")

    public Map<String, Object> trackClick(@PathVariable("id") int id) {
        Lien lien = lienService.findById(id);

        if (lien == null) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        }

       Publisher publisher =
               publisherService.findById(lien.getPublisherId());


       if (publisher == null) {
           throw new ResponseStatusException(HttpStatus.NOT_FOUND);
       }

        lien.incrementClicks();

        Map<String, Object> response = new LinkedHashMap<>();
        response.put("urlRedirection", lien.getUrlDestination());
        response.put("publisher",
                publisher.getPrenom() + " " + publisher.getNom());
        response.put("offre", lien.getOffre());
        response.put("clicks", lien.getClicks());

        return response;
    }
}
