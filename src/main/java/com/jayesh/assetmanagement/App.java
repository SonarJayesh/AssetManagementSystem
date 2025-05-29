package com.jayesh.assetmanagement;

import java.util.Scanner;


public class App {
	
	
	static Scanner scanner = new Scanner(System.in);
	

	private void addNewAsset1() {

		AddNewAssets addNewAssets = new AddNewAssets();
		addNewAssets.getClass();
	}
	
	private void viewAllAssets1() {

		ViewAllAssets viewAllAssets = new ViewAllAssets();
		viewAllAssets.getClass();
	}

	private void updateAsset() {
		
		UpdateAssets updateAssets = new UpdateAssets();
		updateAssets.getClass();
	}

	
	
	public static void main(String[] args) {
        System.out.println("*** Welcome to Assets Management System ***");
        
       
        App app = new App();
        int a;
      
        do {
			System.out.println("\n1. Add New Asset \n2. View All Assets \n3. Update Asset \n4. Exit \n Enter Your Choice Option Number:");
        	int option = scanner.nextInt();
        	
        	switch (option) {
			
	        	case 1: 
					
					app.addNewAsset1();
					break;
			
				case 2:
					app.viewAllAssets1();
					break;
					
				case 3:
					app.updateAsset();
					break;
					
				case 4:
					System.exit(0);
					break;
	        	
				default:
					throw new IllegalArgumentException("Unexpected value: " + option);
				}
			
        	 System.out.println("\n Continue to Operation Enter 1/Yes  and  0/No: ");
             a=scanner.nextInt();
        
        
        } while (a!=0); 
        
        
    }

	
	
	
}
