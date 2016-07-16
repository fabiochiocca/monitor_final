package com.uniritter.monitor.persistence;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

import com.uniritter.monitor.domain.*;

@Component
public class AlertDao {

	private JdbcTemplate jdbcTemplate;

	@Autowired
	public AlertDao(JdbcTemplate jdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;
	}

	public List<Alert> getAlerts() {

		return this.jdbcTemplate.query("select * from Alert order by id", new AlertMap());
	}

	public List<Alert> getAlertBy_MetricaID(String id) {

		return this.jdbcTemplate.query("select * from Alerta where metrica_id = '" + id + "' order by id",
				new AlertMap());
	}

	public List<Alert> getAlert(String id) {

		return this.jdbcTemplate.query("select * from Alerta where id = '" + id + "' order by id",
				new AlertMap());
	}

	public List<Alert> getAlertsFull() {
		return this.jdbcTemplate.query("select * from Alert order by id", new AlertMap());
	}

	public int createAlert(Alert Alert) {
		return jdbcTemplate.update("insert into Alerta (nome,created,metrica_id, valores) values (?,?,?,?)",
				Alert.getNome(), Alert.getCreated(), Alert.getMetrica(), Alert.getValores());
	}

}