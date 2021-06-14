package com.PhoneBook.App.Entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import lombok.Data;

@Entity
@Table(name="CONTACT_ENTITY")
@Data
public class ContactEntity {
	
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator="seq")
	@SequenceGenerator(name="seq", sequenceName="CONTACT_ID", initialValue=1, allocationSize=1)
	@Column(name="CONTACT_ID")
	private Integer contactId;
	@Column(name="CONTACT_NAME")
	private String contactName;
	@Column(name="CONTACT_EMAIL")
	private String contactEmail;
	@Column(name="CONTACT_NUMBER")
	private long contactNumber;
	
	@CreationTimestamp
	@Temporal(TemporalType.DATE)
	@Column(updatable=false)
	private Date createdDate;
	
	@UpdateTimestamp
	@Temporal(TemporalType.DATE)
	@Column(insertable=false)
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
