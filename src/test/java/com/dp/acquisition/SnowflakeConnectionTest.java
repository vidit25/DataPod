package com.dp.acquisition;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.jdbc.core.JdbcTemplate;

@SpringBootTest
public class SnowflakeConnectionTest {
	private static final Logger LOGGER=LoggerFactory.getLogger(SnowflakeConnectionTest.class);

	@Autowired
	private JdbcTemplate jdbcTemplate;

	@Test
	public void shouldReturnTrueOnValidConnection() throws Exception {
		LOGGER.info("Query test");
		List<String> res = jdbcTemplate.query("select '1' as C from dual", this::printResult);
		assertEquals(1, res.size());
	}

	private List<String> printResult(ResultSet rs) throws SQLException {
		LOGGER.info("Metadata:");
		LOGGER.info("================================");

		// fetch metadata
		ResultSetMetaData resultSetMetaData = rs.getMetaData();
		LOGGER.info("Number of columns=" + resultSetMetaData.getColumnCount());
		for (int colIdx = 0; colIdx < resultSetMetaData.getColumnCount(); colIdx++) {
			LOGGER.info("Column " + colIdx + ": type=" + resultSetMetaData.getColumnTypeName(colIdx + 1));
		}

		// fetch data
		List<String> result = new ArrayList<>();
		LOGGER.info("\nData:");
		LOGGER.info("================================");
		int rowIdx = 0;
		while (rs.next()) {
			String val = rs.getString(1);
			LOGGER.info("row " + rowIdx + ", column 0: " + val);
			result.add(val);
		}
		return result;
	}
}