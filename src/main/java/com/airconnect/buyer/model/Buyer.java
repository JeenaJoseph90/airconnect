package com.airconnect.buyer.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.airconnect.common.model.Airline;

@Entity
@Table(name="buyer")
public class Buyer implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 3402201804509355396L;

	@Id @GeneratedValue(strategy=GenerationType.IDENTITY)
    private Integer id;
 
    @Column(name="person_name", nullable=true)
    private String buyerName;
    
    @Column(name="person_designation", nullable=true)
    private String designation;
    
    @Column(name="phone", nullable=true)
    private String phone;
    
    @Column(name="mobile", nullable=true)
    private String mobile;
    
    @Column(name="email_id", nullable=true)
    private String email;
	
    @Column(name="fax", nullable=true)
    private String fax;
    
    @ManyToOne
    @JoinColumn(name = "airline_master_id")
    private Airline airline;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getBuyerName() {
		return buyerName;
	}

	public void setBuyerName(String buyerName) {
		this.buyerName = buyerName;
	}

	public String getDesignation() {
		return designation;
	}

	public void setDesignation(String designation) {
		this.designation = designation;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getMobile() {
		return mobile;
	}

	public void setMobile(String mobile) {
		this.mobile = mobile;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getFax() {
		return fax;
	}

	public void setFax(String fax) {
		this.fax = fax;
	}

	public Airline getAirline() {
		return airline;
	}

	public void setAirline(Airline airline) {
		this.airline = airline;
	}

	@Override
	public String toString() {
		return "Buyer [id=" + id + ", buyerName=" + buyerName + ", designation=" + designation + ", phone=" + phone
				+ ", mobile=" + mobile + ", email=" + email + ", fax=" + fax + ", airline=" + airline + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((airline == null) ? 0 : airline.hashCode());
		result = prime * result + ((buyerName == null) ? 0 : buyerName.hashCode());
		result = prime * result + ((designation == null) ? 0 : designation.hashCode());
		result = prime * result + ((email == null) ? 0 : email.hashCode());
		result = prime * result + ((fax == null) ? 0 : fax.hashCode());
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + ((mobile == null) ? 0 : mobile.hashCode());
		result = prime * result + ((phone == null) ? 0 : phone.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Buyer other = (Buyer) obj;
		if (airline == null) {
			if (other.airline != null)
				return false;
		} else if (!airline.equals(other.airline))
			return false;
		if (buyerName == null) {
			if (other.buyerName != null)
				return false;
		} else if (!buyerName.equals(other.buyerName))
			return false;
		if (designation == null) {
			if (other.designation != null)
				return false;
		} else if (!designation.equals(other.designation))
			return false;
		if (email == null) {
			if (other.email != null)
				return false;
		} else if (!email.equals(other.email))
			return false;
		if (fax == null) {
			if (other.fax != null)
				return false;
		} else if (!fax.equals(other.fax))
			return false;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		if (mobile == null) {
			if (other.mobile != null)
				return false;
		} else if (!mobile.equals(other.mobile))
			return false;
		if (phone == null) {
			if (other.phone != null)
				return false;
		} else if (!phone.equals(other.phone))
			return false;
		return true;
	}
	
	
    
}
