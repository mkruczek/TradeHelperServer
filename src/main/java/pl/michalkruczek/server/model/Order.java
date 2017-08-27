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
    public long id;
    @Column
    public long companyId;
    @Column
    public long productId;


    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public long getCompanyId() {
        return companyId;
    }

    public void setCompanyId(long companyId) {
        this.companyId = companyId;
    }

    public long getProductId() {
        return productId;
    }

    public void setProductId(long productId) {
        this.productId = productId;
    }
}
