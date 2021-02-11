package com.example.demo.crud;

import com.example.demo.entity.Vehicles;
import org.hibernate.Session;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.transaction.Transactional;
import java.util.*;
@Repository
public class ElectronicIMPL implements CRUD{
    private final EntityManager manager;
    @Autowired
    public ElectronicIMPL(EntityManager manager) {
        this.manager = manager;
    }

    @Override
    @Transactional
    public List<Object> searchAll() {
        Session current = manager.unwrap(Session.class);
        Query<Object> query = current.createQuery("from Electronic");
        return query.getResultList();
    }

        @Override
    public Object searchId(int theId) {
        return null;
    }

    @Override
    public void saveUpdate(Object vehicle) {

    }

    @Override
    public void deleteId(int theId) {

    }
}
