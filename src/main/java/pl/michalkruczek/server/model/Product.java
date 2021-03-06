package pl.michalkruczek.server.model;

import javax.persistence.*;
import java.math.BigDecimal;

/**
 * Created by mikr on 26/08/17.
 */
@Entity
@Table(name = "products")
public class Product {

    @Id
    @GeneratedValue
    private Long id;
    @Column
    private String name;
    @Column
    private String description;
    @Column
    private BigDecimal price;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }
}
