package com.dp.acquisition.snowflake.dao;

public interface SnowFlakeDao {

	void useDatabase(String database);

	void useWarehouse(String warehouse);

	void alterWarehouse(String warehouse, boolean toResume);

	void stageFiles(String files, String stageName);

	void moveFromStageToTable(String tableName, String stageName, String files);

	void testDbConnection();

}
