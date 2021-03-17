package com.project.User.entity;

import java.io.Serializable;
import java.util.Objects;

public class Composite implements Serializable {

    private Integer buyerid;
    private Integer prodid;

    public Composite() {
    }

    public Composite(Integer buyerid, Integer prodid) {
        this.buyerid = buyerid;
        this.prodid = prodid;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Composite wishlistId = (Composite) o;
        return buyerid.equals(wishlistId.buyerid) &&
                prodid.equals(wishlistId.prodid);
    }

    @Override
    public int hashCode() {
        return Objects.hash(buyerid, prodid);
    }
}