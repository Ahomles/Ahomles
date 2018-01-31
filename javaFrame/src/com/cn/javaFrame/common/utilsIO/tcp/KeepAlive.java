package com.cn.javaFrame.common.utilsIO.tcp;

import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.util.Date;

public class KeepAlive implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 8056287206991921149L;

	@Override
	public String toString() {
		return new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date())
				+ "\t维持连接包";
	}

}
