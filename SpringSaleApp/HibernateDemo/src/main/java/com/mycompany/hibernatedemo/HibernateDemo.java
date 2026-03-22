/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.hibernatedemo;

import com.tmt.repositories.impl.CategoryRepositoryImpl;
import com.tmt.repositories.impl.ProductRepositoryImpl;
import com.tmt.repositories.impl.StatsRepositoryImpl;
import java.util.HashMap;
import java.util.Map;

/**
 *
 * @author oakce
 */
public class HibernateDemo {

    public static void main(String[] args) {
        CategoryRepositoryImpl s = new CategoryRepositoryImpl();
        s.getCates().forEach(c -> System.out.println(c.getName()));
        
        System.out.println("---");
        Map<String,String> params = new HashMap<>();
        params.put("kw","a");
        params.put("page", "2");
        
        ProductRepositoryImpl s2 = new ProductRepositoryImpl();
        s2.getProducts(params).forEach(p -> System.out.printf("%d - %s - %d\n",
                p.getId(), p.getName(),p.getPrice()));
        System.out.println("---");
        StatsRepositoryImpl s3 = new StatsRepositoryImpl();
        s3.statsRevenueByProduct().forEach(o-> System.out.printf("%d - %s: - %d\n",o[0],o[1],o[2]));
        System.out.println("---");
        s3.statsRevenueByTimeinYear("MONTH", 2020).forEach(o->System.out.printf("%d: %d\n", o[0],o[1]));
    }
}
