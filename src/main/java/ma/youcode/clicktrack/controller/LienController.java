package ma.youcode.clicktrack.controller;

import ma.youcode.clicktrack.entity.Lien;
import ma.youcode.clicktrack.service.LienService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/liens")
public class LienController {

    private final LienService lienService;

    public LienController(LienService lienService) {
        this.lienService = lienService;
    }

    @GetMapping
    public List<Lien> findAll() {
        System.out.println("LienController findAll called");
        return lienService.findAll();
    }
}