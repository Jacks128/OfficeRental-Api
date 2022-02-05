package com.api.officerentalapi.entity;


import lombok.Getter;
import lombok.Setter;
import lombok.ToString;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.validation.constraints.NotNull;
import org.hibernate.annotations.Type;

@Entity
@Getter
@Setter
@ToString
@Table(name = "facilities")

public class Facilities {

	public Facilities() {
		
	}
	
    public Facilities(String name, Boolean state, Double price, String types) {
        this.name = name;
        this.state = state;
        this.price = price;
        this.types=types;
    }
	
    @Id
    @Column(name = "facilitiesid", updatable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer facilitiesid;    
    
    @Column(name="name", updatable=true)
    //@NotNull(message = "name is required")
    private String name;
    
    @Column(name="state", updatable=true, columnDefinition = "TINYINT")
    @Type(type = "org.hibernate.type.NumericBooleanType")
    //@NotNull(message = "state is required")
    private Boolean state;
    
    @Column(name = "price", updatable = true)
    private Double price;
    
    @Column(name="types", updatable=true)
    //@NotNull(message = "types is required")
    private String types;
    

	
	 public String getTypes() {
		return types;
	}

	public void setTypes(String types) {
		this.types = types;
	}

	public Integer getFacilitiesid() {
			return facilitiesid;
		}

		public void setFacilitiesid(Integer facilitiesid) {
			this.facilitiesid = facilitiesid;
		}

		public String getName() {
			return name;
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
