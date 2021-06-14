package com.PhoneBook.App.DTO;

import java.io.Serializable;
import java.util.Date;

public class Contact implements Serializable {
	
	
	
	private static final long serialVersionUID=1L;
	
	private Integer contactId;
	
	private String contactName;
	
	private String contactEmail;
	
	private long contactNumber;
	
	private Date createdDate;
	
	private Date updatedDate;
	
	
	public Integer getContactId() {
		return contactId;
	}

	public void setContactId(Integer contactId) {
		this.contactId = contactId;
	}

	public String getContactName() {
		return contactName;
	}

	public void setContactName(String contactName) {
		this.contactName = contactName;
	}

	public String getContactEmail() {
		return contactEmail;
	}

	public void setContactEmail(String contactEmail) {
		this.contactEmail = contactEmail;
	}
	
	

	public long getContactNumber() {
		return contactNumber;
	}

	public void setContactNumber(long contactNumber) {
		this.contactNumber = contactNumber;
	}

	public Date getCreatedDate() {
		return createdDate;
	}

	public void setCreatedDate(Date createdDate) {
		this.createdDate = createdDate;
	}

	public Date getUpdatedDate() {
		return updatedDate;
	}

	public void setUpdatedDate(Date updatedDate) {
		this.updatedDate = updatedDate;
	}


}
