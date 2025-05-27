package com.jayesh.assetmanagement;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Iterator;
import java.util.Set;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import com.jayesh.assetmanagement.util.Assets;

import jakarta.validation.ConstraintViolation;
import jakarta.validation.Validation;
import jakarta.validation.Validator;



public class App {

	@SuppressWarnings("deprecation")
	public static void main(String[] args) {
        System.out.println("*** Welcome to Assets Management System ***");
        
        
        Validator validator = Validation.buildDefaultValidatorFactory().getValidator();
        
        SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy");
        Assets assets = new Assets();
        
        Configuration configuration = new Configuration();
        configuration.configure();
        configuration.addAnnotatedClass(Assets.class);
        
        SessionFactory sessionFactory = configuration.buildSessionFactory();
        
        Session session = sessionFactory.openSession();
        
        assets.setAssetName("Dell");
        assets.setAssetType("Laptop");
        assets.setSerialNumber("DL101");
        
        try {
			assets.setPurchaseDate(sdf.parse("10-06-2025"));
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        
        
        
        Set<ConstraintViolation<Assets>> violations = validator.validate(assets);
        Iterator<ConstraintViolation<Assets>> iterator = violations.iterator();
       
        while (iterator.hasNext()) {
        	
			ConstraintViolation<Assets> obj = iterator.next();
			System.out.println("Error:"+ obj.getPropertyPath()+" - "+obj.getMessage()+" - "+ obj.getInvalidValue());
			
		}
       
        
        
        Transaction transaction = session.beginTransaction();
        
//        try {
//        	session.save(assets);
//		} catch (ConstraintViolationException e) {
//			
//			e.getConstraintViolations()
//		.forEach(validator -> System.out.println(validator.getMessage()));
//		}
        
        session.save(assets);
        transaction.commit();
        session.close();
        System.out.println("Asset Inserted Successfully!!!");
        
    }
}
