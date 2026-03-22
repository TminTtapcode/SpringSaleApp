/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.tmt.repositories.impl;

import com.mycompany.hibernatedemo.HibernateUtils;
import com.tmt.pojo.Category;
import java.util.List;
import org.hibernate.Session;
import org.hibernate.query.Query;

/**
 *
 * @author oakce
 */
public class CategoryRepositoryImpl {
    public List<Category> getCates(){
        try(Session session = HibernateUtils.getFactory().openSession()){
            Query query = session.createQuery("FROM Category", Category.class);
            return query.getResultList();
        }
    }
}
