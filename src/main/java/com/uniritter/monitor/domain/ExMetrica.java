package com.uniritter.monitor.domain;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class ExMetrica {
	
	@Autowired
	MetricaControl repository;
	
	public List<Metrica> getMetricas() {
		
		return repository.getMetricas();
		
	}
	
	public Metrica getMetrica(String id) {
		return repository.getMetrica(id);
	}
	

	public Metrica createMetrica(String nomeMetrica) {
		return repository.createMetrica(nomeMetrica);
		
	}

	
	
}