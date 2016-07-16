package com.uniritter.monitor.domain;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.uniritter.monitor.persistence.*;

@Component
public class AlertControl {
	
	@Autowired
	AlertDao AlertDao;
	
	public List<Alert> getAlerts() {
		return this.AlertDao.getAlerts();
	}
	
	public List<Alert> getAlert(String id) {
		return this.AlertDao.getAlert(id);
	}
	public List<Alert> getAlertBy_MetricaID(String id) {
		return this.AlertDao.getAlertBy_MetricaID(id);
	}
	

	public Alert createAlert(String nomeAlert, String idMetrica, String valores) {
		Alert nova = new Alert(null,nomeAlert, new Date(), idMetrica, valores );
		AlertDao.createAlert(nova);
		return nova;
	}

}