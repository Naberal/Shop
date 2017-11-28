package com.shop.DAO;

import com.shop.model.Product;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import java.util.List;
import java.util.UUID;

public class ProductDAO implements DAO<Product, UUID> {
    private SessionFactory sessionFactory;
    private Product product;

    public ProductDAO() {
        sessionFactory = new Configuration().configure().buildSessionFactory();
    }

    @Override
    public void save(Product product) {
        try (Session session = sessionFactory.openSession()) {
            Transaction transaction = session.beginTransaction();
            session.save(product);
            transaction.commit();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void update(Product product) {
        try (Session session = sessionFactory.openSession()) {
            Transaction transaction = session.beginTransaction();
            this.product = session.get(Product.class, product.getId());
            this.product.setName(product.getName());
            this.product.setPrise(product.getPrise());
            this.product.setManufacturer(product.getManufacturer());
            session.update(this.product);
            transaction.commit();
        }
    }

    @Override
    public void delete(UUID UUID) {
        try (Session session = sessionFactory.openSession()) {
            Transaction transaction = session.beginTransaction();
            product = session.get(Product.class, UUID);
            session.delete(product);
            transaction.commit();
        } catch (Exception e) {
            System.out.println("Company with id " + UUID + " not exist");
        }
    }

    @Override
    public Product findByID(UUID UUID) {
        try (Session session = sessionFactory.openSession()) {
            product = session.get(Product.class, UUID);
        }
        return product;
    }

    @Override
    public Product findByName(String name) {
        try (Session session = sessionFactory.openSession()) {
            List<Product> list = session.createQuery("from Product where name like :name")
                    .setParameter("name", name).list();
            product = list.get(0);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return product;
    }

    @Override
    public List<Product> getAll() {
        List<Product> products = null;
        try (Session session = sessionFactory.openSession()) {
            Transaction transaction = session.beginTransaction();
            products = session.createQuery("from Product").list();
            transaction.commit();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return products;
    }

    @Override
    public int getCount() {
        int lastUUID = 0;
        try (Session session = sessionFactory.openSession()) {
            List<Integer> last = session.createQuery("SELECT COUNT(*) FROM Manufacturer ").list();
            lastUUID = last.get(0);
        }
        return lastUUID;
    }
}
