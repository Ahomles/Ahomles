package com.cn.javaFrame.common.util.newInstance.Test;

import com.cn.javaFrame.common.util.newInstance.Provider;
import com.cn.javaFrame.common.util.newInstance.Service;

public class ProviderImpl2 implements Provider{

	@Override
	public Service newService() {
		
		return new ServiceImpl2();
	}

}
