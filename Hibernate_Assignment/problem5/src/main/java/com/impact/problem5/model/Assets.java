package com.impact.problem5.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;

@Entity
@NamedQueries(@NamedQuery(name = "findAvgPriceByLocation", 
query = "select avg(a.assetPrice),a.assetLocation from Assets a group by a.assetLocation"))
public class Assets {

	@Id
	private int assetId;

	@Column
	private int serialNo;

	@Column
	private int prNo;

	@Column
	private String assetType;

	@Column
	private int assetPrice;

	@Column
	private String assetLocation;

	public Assets(int assetId, int serialNo, int prNo, String assetType, int assetPrice, String assetLocation) {
		this.assetId = assetId;
		this.serialNo = serialNo;
		this.prNo = prNo;
		this.assetType = assetType;
		this.assetPrice = assetPrice;
		this.assetLocation = assetLocation;
	}

	public Assets() {
		super();
	}

	public int getAssetId() {
		return assetId;
	}

	public void setAssetId(int assetId) {
		this.assetId = assetId;
	}

	public int getSerialNo() {
		return serialNo;
	}

	public void setSerialNo(int serialNo) {
		this.serialNo = serialNo;
	}

	public int getPrNo() {
		return prNo;
	}

	public void setPrNo(int prNo) {
		this.prNo = prNo;
	}

	public String getAssetType() {
		return assetType;
	}

	public void setAssetType(String assetType) {
		this.assetType = assetType;
	}

	public int getAssetPrice() {
		return assetPrice;
	}

	public void setAssetPrice(int assetPrice) {
		this.assetPrice = assetPrice;
	}

	public String getAssetLocation() {
		return assetLocation;
	}

	public void setAssetLocation(String assetLocation) {
		this.assetLocation = assetLocation;
	}

	@Override
	public String toString() {
		return "Assets [assetId=" + assetId + ", serialNo=" + serialNo + ", prNo=" + prNo + ", assetType=" + assetType
				+ ", assetPrice=" + assetPrice + ", assetLocation=" + assetLocation + "]";
	}
}
