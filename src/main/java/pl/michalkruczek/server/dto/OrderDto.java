package pl.michalkruczek.server.dto;

import javax.persistence.Column;

/**
 * Created by mikr on 27/08/17.
 */
public class OrderDto {

    public Long id;
    public Long companyId;
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
