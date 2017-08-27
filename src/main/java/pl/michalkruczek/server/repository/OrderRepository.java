package pl.michalkruczek.server.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import pl.michalkruczek.server.model.Order;

import java.util.List;

/**
 * Created by mikr on 27/08/17.
 */
public interface OrderRepository extends JpaRepository<Order, Long> {

    public List<Order> findByCompanyId(long id);


}
