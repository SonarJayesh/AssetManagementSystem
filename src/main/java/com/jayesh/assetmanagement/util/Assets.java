package com.jayesh.assetmanagement.util;



import java.util.Date;


import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;

@Entity
@Table(name = "assets")
public class Assets {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long assetId;
	
	@NotBlank(message = "Please Enter the Valid Asset Name:")
	String assetName;
	
	@NotBlank(message = "Please Enter the Valid Asset Type:")
	String assetType;
	
	@NotBlank(message = "Please Enter the Serial Number:")
	@Pattern(regexp = "^[A-Za-z0-9]{3,10}$", message = "Serial Number always star with alphabet and contain 3-10 Characters:")
	String serialNumber;
	

	Date purchaseDate;
	
	public Long getAssetId() {
		return assetId;
	}
	public void setAssetId(Long assetId) {
		this.assetId = assetId;
	}
	public String getAssetName() {
		return assetName;
	}
	public void setAssetName(String assetName) {
		this.assetName = assetName;
	}
	public String getAssetType() {
		return assetType;
	}
	public void setAssetType(String assetType) {
		this.assetType = assetType;
	}
	public String getSerialNumber() {
		return serialNumber;
	}
	public void setSerialNumber(String serialNumber) {
		this.serialNumber = serialNumber;
	}
	public Date getPurchaseDate() {
		return purchaseDate;
	}
	public void setPurchaseDate(Date purchaseDate) {
		this.purchaseDate = purchaseDate;
	}
	
	@Override
	public String toString() {
		return "Assets [assetId=" + assetId + ", assetName=" + assetName + ", assetType=" + assetType
				+ ", serialNumber=" + serialNumber + ", purchaseDate=" + purchaseDate + "]";
	
	}
}
