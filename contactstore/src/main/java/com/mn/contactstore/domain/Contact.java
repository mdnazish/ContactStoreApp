package com.mn.contactstore.domain;

/**
 * @author Md Nazish
 *
 */
public class Contact {

	// private fields

	private int contactId;
	private int userId;
	private String name;
	private String phone;
	private String email;
	private String address;
	private String remark;

	// Default Constructor
	public Contact() {
		super();
	}

	// getters and setters

	public int getContactId() {
		return contactId;
	}

	public void setContactId(int contactId) {
		this.contactId = contactId;
	}

	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getRemark() {
		return remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}

	@Override
	public String toString() {
		return "Contact [contactId=" + contactId + ", userId=" + userId + ", name=" + name + ", phone=" + phone
				+ ", email=" + email + ", address=" + address + ", remark=" + remark + "]";
	}

}
