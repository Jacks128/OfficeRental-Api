package com.api.officerentalapi.entity;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;


import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Entity
@Getter
@Setter
@ToString
@Table(name = "booking")

public class Reservation {

	public Reservation() {
		
	}
	
	public Reservation(Facilities facilities, User user) {
		super();
		this.facilitiesObj=facilities;
		this.userObj=user;	
	}
	
	
	
	public Integer getBookingid() {
		return bookingid;
	}

	public void setBookingid(Integer bookingid) {
		this.bookingid = bookingid;
	}

	public Facilities getFacilitiesObj() {
		return facilitiesObj;
	}

	public void setFacilitiesObj(Facilities facilitiesObj) {
		this.facilitiesObj = facilitiesObj;
	}

	public User getUserObj() {
		return userObj;
	}

	public void setUserObj(User userObj) {
		this.userObj = userObj;
	}



		@Id
	    @Column(name = "bookingid", updatable = false)
	    @GeneratedValue(strategy = GenerationType.IDENTITY)
	    private Integer bookingid;
	 	
	    @ManyToOne(fetch = FetchType.LAZY)
	    @JoinColumn(name = "facilitiesid", nullable = false)
	    @NotNull(message = "Facility is required")
	    @JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
	    private Facilities facilitiesObj;
	    
	    @ManyToOne(fetch = FetchType.LAZY)
	    @JoinColumn(name = "userid", nullable = false)
	    @NotNull(message = "User is required")
	    @JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
	    private User userObj;
	
	
}
