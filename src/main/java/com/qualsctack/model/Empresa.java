package com.qualsctack.model;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.Table;

import lombok.Data;

@Data
@Entity
@Table
public class Empresa implements Serializable {

	private static final long serialVersionUID = 1L;
	
	private Long id;
	private String nome;
	
}
