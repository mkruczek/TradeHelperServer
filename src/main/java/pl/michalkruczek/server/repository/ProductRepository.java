package pl.michalkruczek.server.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import pl.michalkruczek.server.model.Product;

/**
 * Created by mikr on 26/08/17.
 */
public interface ProductRepository extends JpaRepository<Product, Long> {
}
