package com.shop.model;


import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.util.Set;
import java.util.UUID;

@Entity
@Table(name = "manufacturer")
public class Manufacturer implements Model {
    @Id
    @GeneratedValue(generator = "UUID")
    @GenericGenerator(name = "UUID", strategy = "uuid2")//todo
    @Column(name = "manufacturer_id")
    private UUID id;
    @Column(name = "manufacturer_name")
    private String name;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "manufacturer", fetch = FetchType.EAGER)
    private Set<Product> products;

    public Manufacturer(String name, Set<Product> products) {
        this.name = name;
        this.products = products;
    }

    public Manufacturer(String name) {

        this.name = name;
    }

    public Manufacturer() {

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

    public Set<Product> getProducts() {
        return products;
    }

    public void setProducts(Set<Product> products) {
        this.products = products;
    }

    @Override
    public String toString() {
        return "Manufacturer{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", products=" + products +
                '}';
    }
}
