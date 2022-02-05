package com.api.officerentalapi.entity.dto;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString

public class FacilitiesDTO {
	private Integer facilitiesid;
	public Integer getFacilitiesid() {
		return facilitiesid;
	}
	public void setFacilitiesid(Integer facilitiesid) {
		this.facilitiesid = facilitiesid;
	}
	private String name;

	private Boolean state;
	private Double price;
	private String types;

	public String getName() {
		return name;
	}
	public String getTypes() {
		return types;
	}
	public void setTypes(String types) {
		this.types = types;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Boolean getState() {
		return state;
	}
	public void setState(Boolean state) {
		this.state = state;
	}
	public Double getPrice() {
		return price;
	}
	public void setPrice(Double price) {
		this.price = price;
	}
}
