package com.app.jdbc;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Types;
import java.util.Properties;

public class OracleStoredProcHandler {

	private Properties prop = null;

	public String callProcedureSetSpineId(String PROJ_ID, String TASK_ID) {

		CallableStatement cs = null;
		Connection con = null;
		String str = "";
		try {
			con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "system", "oracle");
			cs = con.prepareCall("{ CALL WFMT_FTTC.PKG_SPINE.GET_SPINE_NUMBER(?,?,?,?)}");
			cs.setString(1, PROJ_ID);
			cs.setString(2, TASK_ID);
			cs.setString(4, null);
			cs.registerOutParameter(3, Types.VARCHAR);
			cs.executeUpdate();
			if (cs.getObject(3) != null)
				str = cs.getObject(3).toString();
		} catch (SQLException e) {
		} finally {
			try {
				if (cs != null)
					cs.close();
				if (con != null)
					con.close();
			} catch (Exception e2) {
			}
		}
		return str;
	}
}