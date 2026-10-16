package ma.youcode.clicktrack.repository;
import ma.youcode.clicktrack.entity.Publisher;

import java.util.ArrayList;
import java.util.List;
public class
PublisherRepositoryImpl implements PublisherRepository {
    private final List<Publisher> publishers = new ArrayList<>();

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
