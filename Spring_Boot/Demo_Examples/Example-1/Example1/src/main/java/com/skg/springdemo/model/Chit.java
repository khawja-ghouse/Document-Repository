package com.skg.springdemo.model;

import javax.persistence.Entity;
import javax.persistence.Id;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Data
@Getter
@Setter
@Entity
public class Chit {
	@Id
	private long chitId;
	private int chitAmount;
}
