package pl.michalkruczek.server.model;

import javax.persistence.*;
import java.util.List;

/**
 * Created by mikr on 26/08/17.
 */
@Entity
@Table(name = "orders")
public class Order {

    @Id
    @GeneratedValue
    public Long id;
    @Column
    public Long companyId;
    @Column
    public Long productId;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getCompanyId() {
        return companyId;
    }

    public void setCompanyId(Long companyId) {
        this.companyId = companyId;
    }

    public Long getProductId() {
        return productId;
    }

    public void setProductId(Long productId) {
        this.productId = productId;
    }
}
