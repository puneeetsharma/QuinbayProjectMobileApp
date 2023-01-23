package com.example.quinbayprojectmobileapp.model;

import java.io.Serializable;
import java.util.List;

public class Products implements Serializable {
	private int productId;
	private int merchantId;
	private List<String> imageUrl;
	private int productStock;
	private int algoValue;
	private int productRating;
	private String productDescription;
	private String productName;
	private int productPrice;
	private String merchantName;
	private String productCategory;

	public void setProductId(int productId){
		this.productId = productId;
	}

	public int getProductId(){
		return productId;
	}

	public void setMerchantId(int merchantId){
		this.merchantId = merchantId;
	}

	public int getMerchantId(){
		return merchantId;
	}

	public void setImageUrl(List<String> imageUrl){
		this.imageUrl = imageUrl;
	}

	public List<String> getImageUrl(){
		return imageUrl;
	}

	public void setProductStock(int productStock){
		this.productStock = productStock;
	}

	public int getProductStock(){
		return productStock;
	}

	public void setAlgoValue(int algoValue){
		this.algoValue = algoValue;
	}

	public int getAlgoValue(){
		return algoValue;
	}

	public void setProductRating(int productRating){
		this.productRating = productRating;
	}

	public int getProductRating(){
		return productRating;
	}

	public void setProductDescription(String productDescription){
		this.productDescription = productDescription;
	}

	public String getProductDescription(){
		return productDescription;
	}

	public void setProductName(String productName){
		this.productName = productName;
	}

	public String getProductName(){
		return productName;
	}

	public void setProductPrice(int productPrice){
		this.productPrice = productPrice;
	}

	public int getProductPrice(){
		return productPrice;
	}

	public void setMerchantName(String merchantName){
		this.merchantName = merchantName;
	}

	public String getMerchantName(){
		return merchantName;
	}

	public void setProductCategory(String productCategory){
		this.productCategory = productCategory;
	}

	public String getProductCategory(){
		return productCategory;
	}

	@Override
 	public String toString(){
		return 
			"ProductsPgjo{" + 
			"productId = '" + productId + '\'' + 
			",merchantId = '" + merchantId + '\'' + 
			",imageUrl = '" + imageUrl + '\'' + 
			",productStock = '" + productStock + '\'' + 
			",algoValue = '" + algoValue + '\'' + 
			",productRating = '" + productRating + '\'' + 
			",productDescription = '" + productDescription + '\'' + 
			",productName = '" + productName + '\'' + 
			",productPrice = '" + productPrice + '\'' + 
			",merchantName = '" + merchantName + '\'' + 
			",productCategory = '" + productCategory + '\'' + 
			"}";
		}
}