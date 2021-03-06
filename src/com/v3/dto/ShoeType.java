package com.v3.dto;

// Generated Feb 22, 2014 3:49:27 PM by Hibernate Tools 3.6.0

import java.util.HashSet;
import java.util.Set;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import static javax.persistence.GenerationType.IDENTITY;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

/**
 * ShoeType generated by hbm2java
 */
@Entity
@Table(name = "shoe_type", catalog = "v3_inventory", uniqueConstraints = @UniqueConstraint(columnNames = "shoe_type"))
public class ShoeType implements java.io.Serializable {

	private Integer idShoeType;
	private String shoeType;
	private Set<Sku> skus = new HashSet<Sku>(0);

	public ShoeType() {
	}

	public ShoeType(String shoeType) {
		this.shoeType = shoeType;
	}

	public ShoeType(String shoeType, Set<Sku> skus) {
		this.shoeType = shoeType;
		this.skus = skus;
	}

	@Id
	@GeneratedValue(strategy = IDENTITY)
	@Column(name = "id_shoe_type", unique = true, nullable = false)
	public Integer getIdShoeType() {
		return this.idShoeType;
	}

	public void setIdShoeType(Integer idShoeType) {
		this.idShoeType = idShoeType;
	}

	@Column(name = "shoe_type", unique = true, nullable = false, length = 45)
	public String getShoeType() {
		return this.shoeType;
	}

	public void setShoeType(String shoeType) {
		this.shoeType = shoeType;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "shoeType")
	public Set<Sku> getSkus() {
		return this.skus;
	}

	public void setSkus(Set<Sku> skus) {
		this.skus = skus;
	}

}
