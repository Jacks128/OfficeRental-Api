package com.api.officerentalapi.entity;


import lombok.Getter;
import lombok.Setter;
import lombok.ToString;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import javax.validation.constraints.NotNull;


@Entity
@Getter
@Setter
@ToString
@Table(name = "types")

public class Types {
	
	public Types() {
    }
	
    public Types(String type) {
        this.type = type;
    }
    
    public Integer getTypesid() {
		return typesid;
	}

	public void setTypesid(Integer typesid) {
		this.typesid = typesid;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "typesid", updatable = false)
    private Integer typesid;
    
    @Column(name="type", updatable=true)
    @NotNull(message = "type is required")
    private String type;
}
