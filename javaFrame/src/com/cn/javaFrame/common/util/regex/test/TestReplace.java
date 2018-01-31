package com.cn.javaFrame.common.util.regex.test;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class TestReplace {
		public static void main(String[] args) {
			File file = new File("test.sql");
			FileWriter fw = null;
			char[] citys = {'A','B','C','D','E','F'
						,'G','H','J','K','L','M'
						,'N','P','Q','R','S'};
			try {
				fw = new FileWriter(file);
				String sql = new StringBuffer()
							.append("--------------------客户交互信息表分表(replaceCode)START---------------------\n")
	                        .append("CREATE TABLE cic.replaceCode \n")
	                        .append("INFO_ID NUMBER(12), \n")
	                        .append("CUST_ID NUMBER(12),\n")
	                        .append("USER_ID NUMBER(12),\n")
	                        .append("TOUCH_TYPE VARCHAR2(2),\n")
	                        .append("TOUCH_TYPE VARCHAR2(2)\n")
	                        .append("CHANNEL_ID NUMBER(12),\n")
	                        .append("BILL_ID VARCHAR2(14),\n")
	                        .append("DONE_CODE NUMBER(12),\n")
	                        .append("CI_TYPE VARCHAR2(64),\n")
	                        .append("CI_DATE DATE,\n")
	                        .append("CREATE_DATE DATE,\n")
	                        .append("DONE_DATE DATE,\n")
	                        .append("OP_ID NUMBER(19),\n")
	                        .append("ORG_ID NUMBER(12),\n")
	                        .append("EXPIRE_DATE DATE,\n")
	                        .append("REGION_ID VARCHAR2(64),\n")
	                        .append("REMARKS VARCHAR2(1000)\n")
	                        .append(");\n")
	                        .append("ALTER TABLE cic.replaceCode ADD CONSTRAINT PK_CI_INFO_A_201711 PRIMARY KEY(INFO_ID);\n")
	                        .append("COMMENT ON TABLE cic.replaceCode IS '客户交互信息表';\n")
	                        .append("COMMENT ON COLUMN cic.replaceCode.INFO_ID IS '客户交互标识';\n")
	                        .append("COMMENT ON COLUMN cic.replaceCode.CUST_ID IS '客户编号';\n")
	                        .append("COMMENT ON COLUMN cic.replaceCode.USER_ID IS '用户编号';\n")
	                        .append("COMMENT ON COLUMN cic.replaceCode.TOUCH_TYPE IS '触点类型';\n")
	                        .append("COMMENT ON COLUMN cic.replaceCode.CHANNEL_ID IS '渠道ID';\n")
	                        .append("COMMENT ON COLUMN cic.replaceCode.BILL_ID IS '手机号码';\n")
	                        .append("COMMENT ON COLUMN cic.replaceCode.DONE_CODE IS '业务流水号';\n")
	                        .append("COMMENT ON COLUMN cic.replaceCode.CI_TYPE IS '客户交互类型';\n")
	                        .append("COMMENT ON COLUMN cic.replaceCode.CI_DATE IS '交互日期';\n")
	                        .append("COMMENT ON COLUMN cic.replaceCode.CREATE_DATE IS '创建日期';\n")
	                        .append("COMMENT ON COLUMN cic.replaceCode.DONE_DATE IS '操作日期';\n")
	                        .append("COMMENT ON COLUMN cic.replaceCode.OP_ID IS '操作员';\n")
	                        .append("COMMENT ON COLUMN cic.replaceCode.ORG_ID IS '组织编号';\n")
	                        .append("COMMENT ON COLUMN cic.replaceCode.EXPIRE_DATE IS '失效时间';\n")
	                        .append("COMMENT ON COLUMN cic.replaceCode.REGION_ID IS '地市';\n")
	                        .append("COMMENT ON COLUMN cic.replaceCode.REMARKS IS '备注';\n")
	                        .append("\n")
	                        .append("----创建索引---\n")
	                        .append("create index cic.ciDate on replaceCode (CI_DATE);\n")
	                        .append("create index cic.billId on replaceCode (BILL_ID);\n")
							.append("---------------------客户交互信息表分表(replaceCode)END---------------------\n\n")
							.toString();
				for (int i = 0; i < 17; i++) {
					for (int j = 7; j < 13; j++) {
						String replaceCode = "CI_INFO_"+citys[i]+"_"+"2018"+(j>=12?j:"0"+j);
						String ciDate="IDX_CI_DATE_"+citys[i]+"_"+"2018"+(j>=12?j:"0"+j);
						String billId="IDX_BILL_ID_"+citys[i]+"_"+"2018"+(j>=12?j:"0"+j);
						String newSql = sql.replace("ciDate", ciDate);
						 newSql = sql.replace("replaceCode", replaceCode);
						 newSql = sql.replace("billId", billId);
						
						fw.write(newSql);
						fw.flush();
					}
				}
			} catch (IOException e) {
				e.printStackTrace();
			} finally {
				if(fw!=null){
					try {
						fw.close();
					} catch (IOException e) {
						e.printStackTrace();
					}
				}
			}
		}
}
