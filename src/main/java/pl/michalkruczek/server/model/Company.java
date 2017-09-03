package pl.michalkruczek.server.model;

/**
 * Created by mikr on 25/08/17.
 */

import javax.persistence.*;

@Entity
@Table(name = "company")
public class Company {

    @GeneratedValue
    @Id
    private Long id;
    @Column
    private String name;
    @Column
    private String nip;
    @Column
    private String address;
    @Column
    private String phone;
    @Column
    private String email;
    @Column
    private Long userId;

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

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

    public String getNip() {
        return nip;
    }

    public void setNip(String nip) {
        this.nip = nip;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
