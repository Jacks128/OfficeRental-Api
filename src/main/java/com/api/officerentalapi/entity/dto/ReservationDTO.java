package com.api.officerentalapi.entity.dto;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString

public class ReservationDTO {
	private Integer bookingid;

	public Integer getBookingid() {
		return bookingid;
	}

	public void setBookingid(Integer bookingid) {
		this.bookingid = bookingid;
	}

	private Integer facilitiesid;
	private Integer userid;

	public Integer getFacilitiesid() {
		return facilitiesid;
	}

	public void setFacilitiesid(Integer facilitiesid) {
		this.facilitiesid = facilitiesid;
	}

	public Integer getUserid() {
		return userid;
	}

	public void setUserid(Integer userid) {
		this.userid = userid;
	}
}
