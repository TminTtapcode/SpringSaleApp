/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.hibernatedemo;

import com.tmt.pojo.Category;
import com.tmt.pojo.Comment;
import com.tmt.pojo.OrderDetail;
import com.tmt.pojo.ProdTag;
import com.tmt.pojo.Product;
import com.tmt.pojo.SaleOrder;
import com.tmt.pojo.Tag;
import com.tmt.pojo.User;
import java.util.Properties;
import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.cfg.Environment;
import org.hibernate.service.ServiceRegistry;


/**
 *
 * @author oakce
 */
public class HibernateUtils {
   private static final SessionFactory factory;

   static{
       Configuration conf = new Configuration();
       Properties props = new Properties();
       props.put(Environment.DIALECT,"org.hibernate.dialect.MySQLDialect");
       props.put(Environment.JAKARTA_JDBC_DRIVER,"com.mysql.cj.jdbc.Driver");
       props.put(Environment.JAKARTA_JDBC_URL, "jdbc:mysql://localhost/saledb?characterEncoding=UTF-8");
       props.put(Environment.JAKARTA_JDBC_USER,"root");
       props.put(Environment.JAKARTA_JDBC_PASSWORD, "root");
       props.put(Environment.SHOW_SQL, "true");
       
       conf.setProperties(props);
       
       conf.addAnnotatedClass(Category.class);
       conf.addAnnotatedClass(Product.class);
       conf.addAnnotatedClass(User.class);
       conf.addAnnotatedClass(OrderDetail.class);
       conf.addAnnotatedClass(Comment.class);
       conf.addAnnotatedClass(SaleOrder.class);
       conf.addAnnotatedClass(Tag.class);
       conf.addAnnotatedClass(ProdTag.class);
       ServiceRegistry serviceRegistry = new StandardServiceRegistryBuilder()
               .applySettings(conf.getProperties()).build();
       
       factory = conf.buildSessionFactory(serviceRegistry);
   }
   
   
    /**
     * @return the factory
     */
    public static SessionFactory getFactory() {
        return factory;
    }
   
   
   
}
