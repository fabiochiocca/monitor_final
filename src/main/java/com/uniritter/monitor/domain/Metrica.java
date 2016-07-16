package com.uniritter.monitor.domain;

import java.io.Serializable;
import java.util.Date;

public class Metrica implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -3883203541350862437L;
	private Long id;
	private String nome;
	private Date created;
	
	public Metrica() {
	}
	
	public Metrica(Long id, String nome, Date created) {
		this.id = id;
		this.nome = nome;
		this.created = created;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Date getCreated() {
		return created;
	}

	public void setCreated(Date created) {
		this.created = created;
	}
	
	
}
