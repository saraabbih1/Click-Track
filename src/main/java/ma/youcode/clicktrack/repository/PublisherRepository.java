package ma.youcode.clicktrack.repository;
import ma.youcode.clicktrack.entity.Publisher;
import java.util.List;
import ma.youcode.clicktrack.entity.Publisher;

public interface PublisherRepository {
    List<Publisher> findAll();
//   Publisher findBy(int id );
    Publisher save(Publisher publisher);
}
