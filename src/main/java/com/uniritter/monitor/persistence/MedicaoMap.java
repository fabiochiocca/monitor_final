package com.uniritter.monitor.persistence;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.uniritter.monitor.domain.*;;

public class MedicaoMap implements RowMapper<Medicao> {

	public Medicao mapRow(ResultSet rs, int rowNum) throws SQLException {
		return new Medicao(rs.getLong("id"),rs.getString("nome"),rs.getDate("created"));
	}
	
}