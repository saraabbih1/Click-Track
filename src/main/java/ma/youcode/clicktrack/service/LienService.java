
package ma.youcode.clicktrack.service;

import ma.youcode.clicktrack.entity.Lien;
import ma.youcode.clicktrack.repository.LienRepository;

import java.util.List;
import java.util.Map;
import java.util.LinkedHashMap;
import java.util.ArrayList;

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
    public List<Map<String, Object>> getOffresByPublisherId(int publisherId) {
        List<Lien> liens = lienRepository.findByPublisherId(publisherId);

        Map<String, Map<String, Object>> offres = new LinkedHashMap<>();

        for (Lien lien : liens) {
            String offre = lien.getOffre();

            if (!offres.containsKey(offre)) {
                Map<String, Object> stats = new LinkedHashMap<>();
                stats.put("offre", offre);
                stats.put("nombreLiens", 0);
                stats.put("clicks", 0);
                offres.put(offre, stats);
            }
            Map<String, Object> stats = offres.get(offre);
            stats.put("nombreLiens", (int) stats.get("nombreLiens") + 1);
            stats.put("clicks", (int) stats.get("clicks") + lien.getClicks());
        }
        return new ArrayList<>(offres.values());
    }
}
