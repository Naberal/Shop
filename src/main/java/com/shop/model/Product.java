package com.shop.model;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.UUID;

@Entity
@Table(name = "product")
public class Product implements Model {
    @Id
    @GeneratedValue(generator = "UUID")
    @GenericGenerator(name = "UUID", strategy = "uuid2")
    @Column(name = "product_id")
    private UUID id;
    @Column(name = "product_name")
    private String name;
    @Column(name = "prise")
    private BigDecimal prise;
    @ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JoinColumn(name = "manufacturer_id")
    private Manufacturer manufacturer;

    public Product() {
    }

    public Product(String name, BigDecimal prise, Manufacturer manufacturer) {
        this.name = name;
        this.prise = prise;
        this.manufacturer = manufacturer;
    }

    @Override
    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    @Override
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public BigDecimal getPrise() {
        return prise;
    }

    public void setPrise(BigDecimal cost) {
        this.prise = cost;
    }

    public Manufacturer getManufacturer() {
        return manufacturer;
    }

    public void setManufacturer(Manufacturer manufacturer) {
        this.manufacturer = manufacturer;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Product product = (Product) o;

        if (!name.equals(product.name)) return false;
        return manufacturer.equals(product.manufacturer);
    }

    @Override
    public int hashCode() {
        int result = name.hashCode();
        result = 31 * result + manufacturer.hashCode();
        return result;
    }

    @Override
    public String toString() {
        return "Product{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", cost=" + prise +
                ", manufacturer=" + manufacturer +
                '}';
    }
}
