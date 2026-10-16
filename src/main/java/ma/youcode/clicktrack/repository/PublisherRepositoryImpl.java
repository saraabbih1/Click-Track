package ma.youcode.clicktrack.repository;
import ma.youcode.clicktrack.entity.Publisher;

import java.util.ArrayList;
import java.util.List;
import ma.youcode.clicktrack.entity.Categorie;
public class PublisherRepositoryImpl implements PublisherRepository {

    private final List<Publisher> publishers = new ArrayList<>();

    public PublisherRepositoryImpl() {
        publishers.add(new Publisher(
                1,
                "Alami",
                "Sara",
                "sara@test.com",
                Categorie.INFLUENCEUR
        ));
    }

    @Override
    public synchronized List<Publisher> findAll() {
        return new ArrayList<>(publishers);
    }

    @Override
    public synchronized Publisher save(Publisher publisher) {
        publishers.add(publisher);
        return publisher;
    }
    @Override
    public synchronized Publisher findById(int id ){
        return publishers.stream().filter(p->p.getId() == id).findFirst().orElse(null);
    }

}
