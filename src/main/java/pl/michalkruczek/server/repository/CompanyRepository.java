package pl.michalkruczek.server.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import pl.michalkruczek.server.model.Company;

import java.util.List;

/**
 * Created by mikr on 26/08/17.
 */
public interface CompanyRepository extends JpaRepository<Company, Long> {

    public List<Company> findByUserId(Long id);
}
