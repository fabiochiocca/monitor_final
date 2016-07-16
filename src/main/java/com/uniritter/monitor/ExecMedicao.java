package com.uniritter.monitor;

import java.util.LinkedList;
import java.util.List;
import java.util.Random;

import com.uniritter.monitor.domain.Medicao;

public class ExecMedicao {

	public LinkedList<String> listaMedicoes = new LinkedList<>();
	public  LinkedList<Integer> listaValores = new LinkedList<>();

	public LinkedList<String> getListaMedicoes() {
		return listaMedicoes;
	}

	public void setListaMedicoes(LinkedList<String> listaMedicoes) {
		this.listaMedicoes = listaMedicoes;
	}

	public int getMedicaoByName(String nome) {
		for (int i = 0; i < listaMedicoes.size(); i++) {
			if (nome.equalsIgnoreCase(listaMedicoes.get(i))) {
				return listaValores.get(i);
			}
		}
		return -1;
	}

	public LinkedList<Integer> getMedicaoListName(LinkedList<String> listaNomes) {
		LinkedList<Integer> lista_valor = new LinkedList<>();
		
		for (int i = 0; i < listaNomes.size(); i++) {
			for (int j = 0; j < listaMedicoes.size(); j++) {
				if (listaNomes.get(i).equalsIgnoreCase(listaMedicoes.get(j))) {
					lista_valor.add(listaValores.get(j));
					break;
				}
			}
		}
		return lista_valor;
	}

	public void doMedicao(List<Medicao> medicoes) {
		Random randomGenerator = new Random();
		for (int i = 0; i < medicoes.size(); i++) {
			listaMedicoes.add(medicoes.get(i).getNome());
			listaValores.add(randomGenerator.nextInt(100));
		}
	}

}