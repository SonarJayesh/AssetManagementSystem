package com.jayesh.assetmanagement;

import java.text.ParseException;
import java.text.SimpleDateFormat;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import com.jayesh.assetmanagement.util.Assets;
import com.jayesh.assetmanagement.util.HibernateUtil;

import jakarta.validation.ConstraintViolationException;

public class AddNewAssets {
	
	@SuppressWarnings("deprecation")
	public AddNewAssets() {
		
//Validator validator = Validation.buildDefaultValidatorFactory().getValidator();
        
        SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy");
        Assets assets = new Assets();
        
        Configuration configuration = new Configuration();
        configuration.configure();
        configuration.addAnnotatedClass(Assets.class);
        
        Session session = HibernateUtil.getSessionFactoryInstatce().openSession();
        
        assets.setAssetName("Cannon");
        assets.setAssetType("Printer");
        assets.setSerialNumber("CN301");
        
        try {
			assets.setPurchaseDate(sdf.parse("17-06-2025"));
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        
        
        
//        Set<ConstraintViolation<Assets>> violations = validator.validate(assets);
//        Iterator<ConstraintViolation<Assets>> iterator = violations.iterator();
//       
//        while (iterator.hasNext()) {
//        	
//			ConstraintViolation<Assets> obj = iterator.next();
//			System.out.println("Error:"+ obj.getPropertyPath()+" - "+obj.getMessage()+" - "+ obj.getInvalidValue());
//			
//		}
       
        
        
        Transaction transaction = session.beginTransaction();
        
        try {
        	session.save(assets);
		} catch (ConstraintViolationException e) {
			
			e.getConstraintViolations()
		.forEach(v -> System.out.println("Error: "+ v.getPropertyPath() +" - " + v.getMessage()+" - "+ v.getInvalidValue()));
		}
        
       // session.save(assets);
        transaction.commit();
        session.close();
        System.out.println("Asset Inserted Successfully!!!");
	}

}
