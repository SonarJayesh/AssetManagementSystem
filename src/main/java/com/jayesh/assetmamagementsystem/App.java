package com.jayesh.assetmamagementsystem;

import java.util.List;
import java.util.Scanner;

import javax.sound.midi.Soundbank;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.jayesh.assetmamagementsystem.util.HibernateUtil;

import jakarta.transaction.Transaction;


public class App {
	
	
		AssetManagementInfo assetManagementInfo = new AssetManagementInfo();
		static Scanner scanner = new Scanner(System.in);
		
		
		public Session sessionObject() {
			
			Configuration configuration = new Configuration();
			configuration.configure();
			configuration.addAnnotatedClass(AssetManagementInfo.class);
			
			SessionFactory sessionFactory = configuration.buildSessionFactory();
			
			Session session = sessionFactory.openSession();
			
			return session;
		}
		
		public void addNewAsset() {
			
			System.out.println("Please Enter the Asset Name:");
	        assetManagementInfo.setAssename(scanner.next());
	        
	        System.out.println("Please Enter the Asset Type:");
	        assetManagementInfo.setAssettype(scanner.next());
	        
	        System.out.println("Please Enter the Serial Number:");
	        assetManagementInfo.setSerialnumber(scanner.next());
	        
	        System.out.println("Please Enter the Purchase date:");
	        assetManagementInfo.setPurchasedate(scanner.next());
	        
	        
	        Session session = sessionObject();
	        
	        session.beginTransaction();
	        session.save(assetManagementInfo);
	        session.getTransaction().commit();
	        
	        session.close();
	        
	        System.out.println("Asset Information Inserted Succesfully !!");
	        
		}
	
	
	
	 
    public static void main(String[] args) {
			
        System.out.println("*** Welcome to Asset Management System ***");
        App app = new App();
        int a = 0;
      
        do {
			System.out.println("\n1. Add New Asset ");
        	int option = scanner.nextInt();
        	
        	switch (option) {
			case 1: {
				
				app.addNewAsset();
				break;
				
			
			}
			default:
				throw new IllegalArgumentException("Unexpected value: " + option);
			}
			
        
        
        } while (a==1);
        
        System.out.println("\n Continue to Operation Enter 1/Yes  and  2/No: ");
        a=scanner.nextInt();
    }
    
}
