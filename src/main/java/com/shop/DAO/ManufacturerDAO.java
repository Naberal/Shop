package com.shop.DAO;

import com.shop.model.Manufacturer;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import java.util.List;
import java.util.UUID;

public class ManufacturerDAO implements DAO<Manufacturer, UUID> {
    private SessionFactory sessionFactory;
    private Manufacturer manufacturer;

    public ManufacturerDAO() {
        sessionFactory = new Configuration().configure().buildSessionFactory();
    }

    public void save(Manufacturer manufacturer) {
        try (Session session = sessionFactory.openSession()) {
            Transaction transaction = session.beginTransaction();
            session.save(manufacturer);
            transaction.commit();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void update(Manufacturer manufacturer) {
        try (Session session = sessionFactory.openSession()) {
            Transaction transaction = session.beginTransaction();
            this.manufacturer = session.get(Manufacturer.class, manufacturer.getId());
            this.manufacturer.setName(manufacturer.getName());
            this.manufacturer.setProducts(manufacturer.getProducts());
            session.update(this.manufacturer);
            transaction.commit();
        }
    }

    public void delete(UUID UUID) {
        try (Session session = sessionFactory.openSession()) {
            Transaction transaction = session.beginTransaction();
            manufacturer = session.get(Manufacturer.class, UUID);
            session.delete(manufacturer);
            transaction.commit();
        } catch (Exception e) {
            System.out.println("Company with id " + UUID + " not exist");
        }
    }

    public Manufacturer findByID(UUID UUID) {
        try (Session session = sessionFactory.openSession()) {
            manufacturer = session.get(Manufacturer.class, UUID);
        }
        return manufacturer;
    }

    public Manufacturer findByName(String name) {
        try (Session session = sessionFactory.openSession()) {
            List<Manufacturer> list = session.createQuery("from Manufacturer where name like :name")
                    .setParameter("name", name).list();
            manufacturer = list.get(0);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return manufacturer;
    }

    public List<Manufacturer> getAll() {
        List<Manufacturer> manufacturers = null;
        try (Session session = sessionFactory.openSession()) {
            Transaction transaction = session.beginTransaction();
            manufacturers = session.createQuery("from Manufacturer ").list();
            transaction.commit();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return manufacturers;
    }

    public int getCount() {
        int lastUUID = 0;
        try (Session session = sessionFactory.openSession()) {
            List<Integer> last = session.createQuery("SELECT COUNT(*) FROM Manufacturer ").list();
            lastUUID = last.get(0);
        }
        return lastUUID;
    }
}
