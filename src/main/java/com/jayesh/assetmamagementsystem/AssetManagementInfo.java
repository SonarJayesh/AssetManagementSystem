package com.jayesh.assetmamagementsystem;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
@Entity
@Table(name="assetmanagementinfo")
public class AssetManagementInfo {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	Integer id;
	String assetname;
	String  assettype;
	String serialnumber;
	String purchasedate;
	
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getAssename() {
		return assetname;
	}
	public void setAssename(String assename) {
		this.assetname = assename;
	}
	public String getAssettype() {
		return assettype;
	}
	public void setAssettype(String assettype) {
		this.assettype = assettype;
	}
	public String getSerialnumber() {
		return serialnumber;
	}
	public void setSerialnumber(String serialnumber) {
		this.serialnumber = serialnumber;
	}
	public String getPurchasedate() {
		return purchasedate;
	}
	public void setPurchasedate(String purchasedate) {
		this.purchasedate = purchasedate;
	}
	
	@Override
	public String toString() {
		return "AssetManagementInfo [id=" + id + ", assetname=" + assetname + ", assettype=" + assettype
				+ ", serialnumber=" + serialnumber + ", purchasedate=" + purchasedate + "]";
	}
	
	
	

}
