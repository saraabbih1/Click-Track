package ma.youcode.clicktrack.repository;

import ma.youcode.clicktrack.entity.Lien;
import java.util.List;

public interface LienRepository {
    List<Lien> findAll();
Lien save(Lien lien);
  Lien findById(int id);
List<Lien> findByPublisherId(int publisherId);
}