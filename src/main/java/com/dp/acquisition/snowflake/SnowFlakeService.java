package com.dp.acquisition.snowflake;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dp.acquisition.snowflake.dao.SnowFlakeDao;

@Service
public class SnowFlakeService {

	@Autowired
	private SnowFlakeDao sfDao;

	public void startLoading() {
		sfDao.useDatabase("DP_DB");
		sfDao.useWarehouse("DP_WH");
		sfDao.alterWarehouse("DP_WH", true);
		sfDao.stageFiles("C:\\Users\\Gaurav\\Downloads\\Customer_Data_01.csv", "DP_STAGE");
		sfDao.moveFromStageToTable("CUSTOMER", "DP_STAGE", "Customer_Data_01.csv.gz");
		sfDao.alterWarehouse("DP_WH", false);
	}

}
