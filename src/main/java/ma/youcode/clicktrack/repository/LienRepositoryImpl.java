
package ma.youcode.clicktrack.repository;

import ma.youcode.clicktrack.entity.Lien;
import java.util.ArrayList;
import java.util.List;

public class LienRepositoryImpl implements LienRepository {

    private final List<Lien> liens = new ArrayList<>();
    public LienRepositoryImpl() {
        liens.add(new Lien(
                1,
                "Offre Test",
                "https://www.google.com",
                0,
                1
        ));
    }

    @Override
    public synchronized List<Lien> findAll() {
        return new ArrayList<>(liens);
    }

    @Override
    public synchronized List<Lien> findByPublisherId(int publisherId) {
        return liens.stream()
                .filter(lien -> lien.getPublisherId() == publisherId)
                .toList();
    }
    @Override
    public synchronized Lien findById(int id) {
        return liens.stream()
                .filter(lien -> lien.getId() == id)
                .findFirst()
                .orElse(null);
    }
    @Override
    public synchronized Lien save(Lien lien) {
        int nextId = liens.stream()
                .mapToInt(Lien::getId)
                .max()
                .orElse(0) + 1;

        Lien savedLien = new Lien(
                nextId,
                lien.getOffre(),
                lien.getUrlDestination(),
                0,
                lien.getPublisherId()
        );

        liens.add(savedLien);
        return savedLien;
    }
}
