
package ma.youcode.clicktrack.service;

import ma.youcode.clicktrack.entity.Lien;
import ma.youcode.clicktrack.repository.LienRepository;

import java.util.List;

public class LienService {

    private final LienRepository lienRepository;

    public LienService(LienRepository lienRepository) {
        this.lienRepository = lienRepository;
    }

    public List<Lien> findAll() {
        return lienRepository.findAll();
    }

    public Lien findById(int id) {
        return lienRepository.findById(id);
    }

    public List<Lien> findByPublisherId(int publisherId) {
        return lienRepository.findByPublisherId(publisherId);
    }

    public Lien create(int publisherId, String offre, String urlDestination) {
        Lien lien = new Lien(0, offre, urlDestination, 0, publisherId);
        return lienRepository.save(lien);
    }
}
