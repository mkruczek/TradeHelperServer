package pl.michalkruczek.server.dto;

import javax.persistence.Column;

/**
 * Created by mikr on 27/08/17.
 */
public class OrderDto {

    public long id;
    public long companyId;
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
