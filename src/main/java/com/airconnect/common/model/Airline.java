package com.airconnect.common.model;

import java.io.Serializable;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.hibernate.validator.constraints.NotEmpty;

import com.airconnect.buyer.model.Buyer;

@Entity
@Table(name = "airline_master")
public class Airline implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

		@Id @GeneratedValue(strategy=GenerationType.IDENTITY)
	    private Integer id;
	 
	    @NotEmpty
	    @Column(name="airline_name", unique=true, nullable=false)
	    private String airlineName;
	    
	    @ManyToOne
	    @JoinColumn(name = "airline_country_id")
	    private Country country;
	    
	    @OneToMany(mappedBy = "airline", fetch = FetchType.LAZY)
	    private Set<Buyer> buyers;

		public Integer getId() {
			return id;
		}

		public void setId(Integer id) {
			this.id = id;
		}

		public String getAirlineName() {
			return airlineName;
		}

		public void setAirlineName(String airlineName) {
			this.airlineName = airlineName;
		}

		public Country getCountry() {
			return country;
		}

		public void setCountry(Country country) {
			this.country = country;
		}

		public Set<Buyer> getBuyers() {
			return buyers;
		}

		public void setBuyers(Set<Buyer> buyers) {
			this.buyers = buyers;
		}

		@Override
		public String toString() {
			return "Airline [id=" + id + ", airlineName=" + airlineName + ", country=" + country + ", buyers=" + buyers
					+ "]";
		}

		@Override
		public int hashCode() {
			final int prime = 31;
			int result = 1;
			result = prime * result + ((airlineName == null) ? 0 : airlineName.hashCode());
			result = prime * result + ((buyers == null) ? 0 : buyers.hashCode());
			result = prime * result + ((country == null) ? 0 : country.hashCode());
			result = prime * result + ((id == null) ? 0 : id.hashCode());
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
			Airline other = (Airline) obj;
			if (airlineName == null) {
				if (other.airlineName != null)
					return false;
			} else if (!airlineName.equals(other.airlineName))
				return false;
			if (buyers == null) {
				if (other.buyers != null)
					return false;
			} else if (!buyers.equals(other.buyers))
				return false;
			if (country == null) {
				if (other.country != null)
					return false;
			} else if (!country.equals(other.country))
				return false;
			if (id == null) {
				if (other.id != null)
					return false;
			} else if (!id.equals(other.id))
				return false;
			return true;
		}

		
  
}
