package com.v3.dto;

// Generated Mar 1, 2014 3:23:41 PM by Hibernate Tools 3.6.0

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

/**
 * Gender generated by hbm2java
 */
@Entity
@Table(name = "gender", catalog = "v3_inventory")
public class Gender implements java.io.Serializable {

	private Byte idGender;
	private String gender;
	private Set<Shoe> shoes = new HashSet<Shoe>(0);

	public Gender() {
	}

	public Gender(String gender, Set<Shoe> shoes) {
		this.gender = gender;
		this.shoes = shoes;
	}

	@Id
	@GeneratedValue(strategy = IDENTITY)
	@Column(name = "id_gender", unique = true, nullable = false)
	public Byte getIdGender() {
		return this.idGender;
	}

	public void setIdGender(Byte idGender) {
		this.idGender = idGender;
	}

	@Column(name = "gender", length = 45)
	public String getGender() {
		return this.gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "gender")
	public Set<Shoe> getShoes() {
		return this.shoes;
	}

	public void setShoes(Set<Shoe> shoes) {
		this.shoes = shoes;
	}

}
