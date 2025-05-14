package com.jayesh.assetmamagementsystem;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

/**
 * Hello world!
 */
public class App {
    public static void main(String[] args) {
        System.out.println("Hello World!");
        
        AssetManagementInfo assetManagementInfo = new AssetManagementInfo();
        
        //assetManagementInfo.setId();
        assetManagementInfo.setAssename("Lenovo");
        assetManagementInfo.setAssettype("Laptop");
        assetManagementInfo.setSerialnumber("S201");
        assetManagementInfo.setPurchasedate("25/06/2025");
        
        
        Configuration configuration = new Configuration();
        configuration.configure();
        configuration.addAnnotatedClass(AssetManagementInfo.class);
        
        SessionFactory sessionFactory = configuration.buildSessionFactory();
        
        Session session = sessionFactory.openSession();
        session.beginTransaction();
        session.save(assetManagementInfo);
        session.getTransaction().commit();
        
        session.close();
        
        System.out.println("Asset Information Save Successfully");
        
    }
}
