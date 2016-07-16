package com.uniritter.monitor.domain;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class ExMedicao {
	
	@Autowired
	MedicaoControl repository;
	
	public List<Medicao> getMedicoes() {
		
		return repository.getMedicoes();
		
	}
	
	public List<Medicao> getMedicao(String id) {
		
		return repository.getMedicao(id);
		
	}

	public Medicao createMedicao(String nomeMedicao) {
		
		return repository.createMedicao(nomeMedicao);
		
	}
	
	
}