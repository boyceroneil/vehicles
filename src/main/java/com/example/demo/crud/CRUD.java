package com.example.demo.crud;

import java.util.*;
public interface CRUD {
    List<Object> searchAll();
    Object searchId(int theId);
    void saveUpdate(Object vehicle);
    void deleteId(int theId);
}
