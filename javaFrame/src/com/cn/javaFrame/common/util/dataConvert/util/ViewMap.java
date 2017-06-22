package com.cn.javaFrame.common.util.dataConvert.util;

/**
 * 查看Map的工具
 * 
 * @author zhunb3 {PUB_PARAM={sys_name=znb, sys_id=123, sys_age=34},
 *         BUSI_PARAM={RULELIST={RULEINFO=[{list13=list13, list11=list11,
 *         list12=list12}, {list22=list22, list23=list23, list21=list21}]},
 *         ADDRESS=漯河市}} ====== || || \||/ \/ ====== { PUB_PARAM={ sys_name=znb,
 *         sys_id=123, sys_age=34 }, BUSI_PARAM={ RULELIST={ RULEINFO=[ {
 *         list13=list13, list11=list11, list12=list12 }, { list22=list22,
 *         list23=list23, list21=list21 } ] }, ADDRESS=漯河市 } }
 */
public class ViewMap {
	public static void main(String[] args) {

	}

	public static boolean checkMap(String mapStr) {
		boolean isMapStr = false;

		return false;
	}

	private class CharState {
		boolean mapStart = false;
		boolean setDicValue = false;
		boolean escapChar = false;
		boolean arrayStart = false;
		boolean childrenStart = false;
		
		int state=0;
		int keyStart=0;
		int valueStart=0;
		
		boolean isError=false;
		void checkIsError(char c){
			if(keyStart > 1 || valueStart > 1){
				return;
			}
			switch(c){
				case'{': //[{}]
					isError=mapStart && state==0;
					break;
				case'}': 
					isError=!mapStart && (keyStart!=0&&state==0);
					break;
				case'[': 
					isError=arrayStart && state==0;
					break;
				case']': 
					isError=!arrayStart && mapStart;
					break;
				case'"': 
				case'\'': 
					isError=!(arrayStart || mapStart);
					if(!isError){
						isError=(state==0&&keyStart==-1)||(state==1&&valueStart==-1);
					}
					if(!isError&&arrayStart&&!mapStart&&c=='\''){
						isError=true;
					}
					break;
				case ':':
					isError=!mapStart||state==1;
					break;
				case ',':
			}
		}
		
		
	}
}
