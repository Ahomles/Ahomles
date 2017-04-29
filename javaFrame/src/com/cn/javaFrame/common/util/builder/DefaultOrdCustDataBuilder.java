package com.cn.javaFrame.common.util.builder;

import java.util.ArrayList;
import java.util.List;

import com.cn.javaFrame.common.util.builder.bean.OrdBusi;
import com.cn.javaFrame.common.util.builder.bean.OrdBusiData;
import com.cn.javaFrame.common.util.builder.bean.OrdCust;
import com.cn.javaFrame.common.util.builder.bean.OrdCustData;
import com.cn.javaFrame.common.util.builder.bean.OrdUser;
import com.cn.javaFrame.common.util.builder.impl.AbstractOrdBusiDataBuilder;
import com.cn.javaFrame.common.util.builder.impl.AbstractOrdCustDataBuilder;
import com.cn.javaFrame.common.util.builder.impl.AbstractOrdUserBuilder;
import com.cn.javaFrame.common.util.builder.interfaces.OrdBusiDataBuilder;
import com.cn.javaFrame.common.util.builder.interfaces.OrdUserBuilder;

public class DefaultOrdCustDataBuilder extends AbstractOrdCustDataBuilder{

	List<OrdBusiDataBuilder> ordBusiDataBuilders=new ArrayList<OrdBusiDataBuilder>();
	
	
	public DefaultOrdCustDataBuilder() throws Exception{
		this.initOrdCustDateBuilder();
	}
	//初始化数据
	public void initOrdCustDateBuilder() throws Exception{
		this.setState(1);
	}
	//构建大对象
	@Override
	public OrdCustData builder() throws Exception{
		OrdCustData ordCustData =new OrdCustData();
		OrdCust ordCust=ordCustBuilder();
		ordCustData.setOrdCust(ordCust);
		List<OrdBusiData> ordBusiDatas=new ArrayList<OrdBusiData>();
		ordCustData.setOrdBusiDatas(ordBusiDatas);
		for(OrdBusiDataBuilder ordBusiDataBuilder:ordBusiDataBuilders){
			ordBusiDatas.add(ordBusiDataBuilder.builder());
		}
		return  ordCustData;
	}
	public OrdCust ordCustBuilder() throws Exception{
		OrdCust ordCust=new OrdCust();
		ordCust.setCustOrderId(this.getCustOrderId());
		ordCust.setCreateDate(this.getCreateDate());
		ordCust.setState(this.getState());
		return ordCust;
	}

	@Override
	public OrdBusiDataBuilder ordBusiDataBuilder() throws Exception {
		return new DefaultOrdBusiDataBuilder();
	}

	public class DefaultOrdBusiDataBuilder extends AbstractOrdBusiDataBuilder{
		List<OrdUserBuilder> ordUserBuilders=new ArrayList<OrdUserBuilder>();
		
		public List<OrdUserBuilder> getOrdUserBuilders() {
			return ordUserBuilders;
		}

		public void setOrdUserBuilders(List<OrdUserBuilder> ordUserBuilders) {
			this.ordUserBuilders = ordUserBuilders;
		}

		public DefaultOrdBusiDataBuilder(){
			this.initOrdBusiDateBuilder();
			DefaultOrdCustDataBuilder.this.ordBusiDataBuilders.add(this);
		}
		
		private void initOrdBusiDateBuilder() {
			this.setState(1);
		}


		@Override
		public OrdBusiData builder() throws Exception {
			OrdBusiData ordBusiData = new OrdBusiData();
			OrdBusi ordBusi=ordBusiBuilder();
			ordBusiData.setOrdBusi(ordBusi);
			List<OrdUser> ordUsers=new ArrayList<OrdUser>();
			ordBusiData.setOrdUsers(ordUsers);
			for(OrdUserBuilder ordUserBuilder:ordUserBuilders){
				ordUsers.add(ordUserBuilder.builder());
			}
			return ordBusiData;
		}
		public OrdBusi ordBusiBuilder(){
			OrdBusi ordBusi=new OrdBusi();
			ordBusi.setBusiOrderId(this.getBusiOrderId());
			ordBusi.setCreateDate(this.getCreateDate());
			ordBusi.setState(this.getState());
			return ordBusi;
		}
		
		@Override
		public OrdUserBuilder ordUserBuilder() throws Exception {
			DefaultOrdUserBuilder ordUserBuilder=new DefaultOrdUserBuilder();
			ordUserBuilders.add(ordUserBuilder);
			return ordUserBuilder;
		}
		public class DefaultOrdUserBuilder extends AbstractOrdUserBuilder{

			public DefaultOrdUserBuilder(){
				this.initOrdUserBuilder();
			}
			private void initOrdUserBuilder() {
				this.setState(1);
			}
			@Override
			public OrdUser builder() {
				return ordUserBuilder();
			}
			public OrdUser ordUserBuilder(){
				OrdUser ordUser=new OrdUser();
				ordUser.setUserOrderId(this.getUserOrderId());
				ordUser.setCreateDate(this.getCreateDate());
				ordUser.setState(this.getState());
				return ordUser;
			}
		}
	}
	
}
