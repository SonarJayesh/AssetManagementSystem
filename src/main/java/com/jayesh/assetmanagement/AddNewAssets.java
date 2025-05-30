package com.jayesh.assetmanagement;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Scanner;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import com.jayesh.assetmanagement.util.Assets;
import com.jayesh.assetmanagement.util.HibernateUtil;

import jakarta.validation.ConstraintViolationException;

public class AddNewAssets {
	
	@SuppressWarnings({ "deprecation", "resource" })
	public AddNewAssets() {
		
		try {
			
			//Validator validator = Validation.buildDefaultValidatorFactory().getValidator();
	        
	        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd-MM-yyyy");
	        
	        Assets assets = new Assets();
			Scanner scanner = new Scanner(System.in);
	        
	        Configuration configuration = new Configuration();
	        configuration.configure();
	        configuration.addAnnotatedClass(Assets.class);
	        
	        Session session = HibernateUtil.getSessionFactoryInstatce().openSession();
	        
	        
	        System.out.println("Enter the Asset Name :=");
	        assets.setAssetName(scanner.next());
	        System.out.println("Enter the Asset Type :=");
	        assets.setAssetType(scanner.next());
	        int b=0;
	        do {
	        	
	        	System.out.println("Enter the Serial Number:=");
			    String a = scanner.next(); 
			     if(a.length() >= 3  ) {
			    	  
			    	  assets.setSerialNumber(a);
			    	  b=1;
			    	  break;
			      }else {
					
			    	  System.out.println("Serial Number always star with alphabet and contain 3-10 Characters:");
			      }
			     
			} while (b==0);
		      
	        
	        System.out.println("Enter the Purchase Date :=");
	        try {
				assets.setPurchaseDate(simpleDateFormat.parse(scanner.next()));
			} catch (ParseException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
	        
	      
	        
	        
	        
//	        Set<ConstraintViolation<Assets>> violations = validator.validate(assets);
//	        Iterator<ConstraintViolation<Assets>> iterator = violations.iterator();
//	       
//	        while (iterator.hasNext()) {
//	        	
//				ConstraintViolation<Assets> obj = iterator.next();
//				System.out.println("Error:"+ obj.getPropertyPath()+" - "+obj.getMessage()+" - "+ obj.getInvalidValue());
//				
//			}
	       
	        
	        
	        Transaction transaction = session.beginTransaction();
	        
	        try {
	        	session.save(assets);
			} catch (ConstraintViolationException e) {
				
				e.getConstraintViolations()
			.forEach(v -> System.out.println("Error: "+ v.getPropertyPath() +" - " + v.getMessage()+" - "+ v.getInvalidValue()));
			}
	        
	        //session.save(assets);
	        transaction.commit();
	        session.close();
	        
	        System.out.println("Asset Record Inserted Successfully !!!");
		
		
		} catch (Exception e) {
			System.out.println("Asset Record is Not Inserted !!!");
		}
		

	}

}
