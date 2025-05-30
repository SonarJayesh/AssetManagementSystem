package com.jayesh.assetmanagement;

import java.util.Scanner;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import com.jayesh.assetmanagement.util.Assets;
import com.jayesh.assetmanagement.util.HibernateUtil;

public class DeleteAsset {

	@SuppressWarnings({ "deprecation", "resource" })
	public DeleteAsset() {
		
		try {
			
			
			Scanner scanner = new Scanner(System.in);
			Assets  assets  = null;
			
  			System.out.println("Delete Asset to Enter the Asset id := ");
  			int id = scanner.nextInt();

  			Configuration configuration = new Configuration();
  			configuration.configure();
  			configuration.addAnnotatedClass(Assets.class);
  			
			Session session = HibernateUtil.getSessionFactoryInstatce().openSession();
			
			assets = session.get(Assets.class,id);
			      
		        
		      Transaction transaction = session.beginTransaction();			
		        session.delete(assets);
		        transaction.commit();
		        session.close();
			
			System.out.println("Asset Record Delete Successfully !!!");
			
			
		}catch (Exception e) {
			System.out.println(e.getMessage()+"\n Asset Record is not Deleted !!!");
		}	
		
	}
}
