package com.learning.dddbid.seller.repository.entity;

import com.learning.dddbid.seller.domain.model.Seller;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "seller")
public class SellerEntity {
    @Id
    private String email;
    @Column
    private String userName;
    @Column
    private String password;

    public SellerEntity() {
    }

    public SellerEntity(String email, String userName, String password) {
        this.email = email;
        this.userName = userName;
        this.password = password;
    }

    public SellerEntity(Seller seller) {
        this.email = seller.getEmail();
        this.userName = seller.getUserName();
        this.password = seller.getPassword();
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        SellerEntity that = (SellerEntity) o;

        return email != null ? email.equals(that.email) : that.email == null;
    }

    @Override
    public int hashCode() {
        return email != null ? email.hashCode() : 0;
    }

    public Seller toSeller() {
        return new Seller(email, userName, password);
    }
}
