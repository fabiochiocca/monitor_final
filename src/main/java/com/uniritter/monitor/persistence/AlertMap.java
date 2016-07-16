package com.uniritter.monitor.persistence;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.uniritter.monitor.domain.*;;

public class AlertMap implements RowMapper<Alert> {

	public Alert mapRow(ResultSet rs, int rowNum) throws SQLException {
		
		return new Alert(rs.getLong("id"),rs.getString("nome"),rs.getDate("created"),rs.getString("metrica_id"),rs.getString("valores"));
	}
	
}