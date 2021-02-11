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
public class VehicleIMPL implements CRUD{

    private final EntityManager manager;

    @Autowired
    public VehicleIMPL(EntityManager manager) {
        this.manager = manager;
    }

    @Override
    @Transactional
    public List<Object> searchAll(){
        Session current = manager.unwrap(Session.class);
        Query<Object> query = current.createQuery("from Vehicles");
        return query.getResultList();

    }

    @Override
    @Transactional
    public Object searchId(int theId) {
        Session currentSession = manager.unwrap(Session.class);
        return currentSession.get(Vehicles.class, theId);
    }

    @Override
    @Transactional
    public void saveUpdate(Object vehicle) {
        Session currentSession = manager.unwrap(Session.class);
        currentSession.saveOrUpdate(vehicle);
    }

    @Override
    @Transactional
    public void deleteId(int theId) {
        Session currentSession = manager.unwrap(Session.class);
        Vehicles veh = currentSession.get(Vehicles.class, theId);
        currentSession.delete(veh);
    }

}
