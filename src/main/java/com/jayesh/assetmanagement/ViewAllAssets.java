package com.jayesh.assetmanagement;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;


import com.jayesh.assetmanagement.util.Assets;
import com.jayesh.assetmanagement.util.HibernateUtil;

public class ViewAllAssets {
	
	public ViewAllAssets() {
		
		Configuration configuration = new Configuration();
		configuration.configure();
		configuration.addAnnotatedClass(Assets.class);
	
		
		Session session = HibernateUtil.getSessionFactoryInstatce().openSession();
		
	
		List<Assets> assetRecord = session.createQuery("from Assets", Assets.class).getResultList();
		
		for (int i =0; i< assetRecord.size(); i++) {
			
			Assets assets = assetRecord.get(i);
			System.out.println("\tAsset ID: "+ assets.getAssetId()+ " \tAsset Name: "+assets.getAssetName()+ " \tAsset Type: "+assets.getAssetType()+ " \tSerial Number: "+assets.getSerialNumber()+ " \tPurchase Date: "+assets.getPurchaseDate());
			
		}
		Transaction transaction = session.beginTransaction();
		
		transaction.commit();
		session.close();
		System.out.println("View All Asset Details Succesfully");
		
	}

}
