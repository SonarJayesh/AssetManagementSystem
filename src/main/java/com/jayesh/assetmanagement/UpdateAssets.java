package com.jayesh.assetmanagement;

import java.text.SimpleDateFormat;
import java.util.Scanner;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import com.jayesh.assetmanagement.util.Assets;
import com.jayesh.assetmanagement.util.HibernateUtil;

import jakarta.validation.ConstraintViolationException;

public class UpdateAssets {
	
	@SuppressWarnings({ "deprecation", "resource" })
	public UpdateAssets() {
		
		
		try {
			
			Scanner scanner = new Scanner(System.in);
			Assets  assets  = null;
			
			SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd-MM-yyy");
			
  			System.out.println("Update Asset to Enter the Asset id := ");
  			int id = scanner.nextInt();

  			Configuration configuration = new Configuration();
  			configuration.configure();
  			configuration.addAnnotatedClass(Assets.class);
  			
			Session session = HibernateUtil.getSessionFactoryInstatce().openSession();
			
			assets = session.get(Assets.class,id);
			
			
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
		        assets.setPurchaseDate(simpleDateFormat.parse(scanner.next()));
				
		        
		      Transaction transaction = session.beginTransaction();
		        
		        try {
		        	session.update(assets);
				} catch (ConstraintViolationException e) {
					
					e.getConstraintViolations()
				.forEach(v -> System.out.println("Error: "+ v.getPropertyPath() +" - " + v.getMessage()+" - "+ v.getInvalidValue()));
				
				}
			
		        
		        transaction.commit();
		        session.close();
			
			System.out.println("Asset Record Updated Successfully !!!");
			
			
		}catch (Exception e) {
			System.out.println(e.getMessage()+"\n Asset Record is not Updated !!!");
		}	
	
		
	}

}
