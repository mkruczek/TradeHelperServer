package pl.michalkruczek.server.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import pl.michalkruczek.server.model.Company;

/**
 * Created by mikr on 26/08/17.
 */
public interface CompanyRepository extends JpaRepository<Company, Long> {
}
