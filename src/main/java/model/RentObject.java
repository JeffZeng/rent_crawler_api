package model;



public class RentObject {
	String picture = null;
	String title = null;
	String type = null;
	String address = null;
	String contact = null;
	String detail = null;
	int price = 0;
	String mark = null;
	
	public RentObject(String picture,String title, String type, String address, String contact, int price,String detail,String mark) {
		this.setPicture(picture);
		this.setTitle(title);
		this.setType(type);
		this.setAddress(address);
		this.setContact(contact);
		this.setPrice(price);
		this.setMark(mark);
	}
	
	public void setPicture(String picture) {
		this.picture =picture;
	}
	
	public String getPicture() {
		return this.picture;
	}
	
	public void setTitle(String title) {
		this.title =title;
	}
	
	public String getTitle() {
		return this.title;
	}
	
	
	public void setType(String type) {
		this.type = type;
	}
	
	public String getType() {
		return this.type;
	}
	
	
	public void setAddress(String address) {
		this.address = address;
	}
	
	public String getAddress() {
		return this.address;
	}
	
	
	public void setContact(String contact) {
		this.contact =contact;
	}
	
	public String getContact() {
		return this.contact;
	}
	
	public void setPrice(int price) {
		this.price = price;
	}
	
	public int getPrice() {
		return this.price;
	}
	
	public void setMark(String mark) {
		this.mark = mark;
	}
	
	public String getMark() {
		return this.mark;
	}
	
}
