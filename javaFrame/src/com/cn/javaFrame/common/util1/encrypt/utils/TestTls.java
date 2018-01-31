package com.cn.javaFrame.common.util1.encrypt.utils;

import java.util.Map;

import com.cn.javaFrame.common.util1.encrypt.utils.util.RSASecurityUtils;
import com.cn.javaFrame.common.util1.encrypt.utils.util.RSAUtils;

public class TestTls {
	public static void main(String[] args) throws Exception {
		String trans= new TestTls().client();
//		new TestTls().getKey();
//		System.out.println(AESUtil.getKey());
//		System.out.println(AESUtil.getKEYUUID());
//		SYSTEM.OUT.PRINTLN(AESUTIL.GETKEYBYPass("znb"));
		String repose="";
		new TestTls().server(trans, repose);
	}
	/**
	 * @return 
	 * @throws Exception 
	 */
	public String client() throws Exception
	{
		//RSA密钥
		String publicKey="65537";
		String modulus="135675786889243825751685450073645957916723225800534534012078858541497176233672522058992612444409268969650773716376030994492020348693148188863360944895289770239796245979281465969501391251848011668365710846507942370233740977610553782004147071993884867854495956964329588303034652067584741273292360760811677609829";
		
		//随机生产AES密钥
		String key = AESUtil.getKeyUUID();
		
		String jsonData="{'name':'znb','pwd':'123'}";
		System.out.println("AES="+key);
		String miwen=AESUtil.encrypt(jsonData, key);
		String keyMiwen = new String(RSASecurityUtils.encryptByPublicKey(
				key, publicKey,modulus));
		//网络传输数据
		String trans = miwen + "@" + keyMiwen;
		return trans;
	}
	
	//服务端进行解密
	public void server(String req,String repose) throws Exception{
		System.out.println("req="+req);
		String privateKey="55322398844031047432172517544563238070228951021067249834517651659435571364152018050604385039778276312250753406819303237343947079941513939469240193027401741044468434480416449191153755311650254624902687046404235641576140872332066372329306031158035276501156955950051511248950332832687842277592345514719054395653";
		String modulus="135675786889243825751685450073645957916723225800534534012078858541497176233672522058992612444409268969650773716376030994492020348693148188863360944895289770239796245979281465969501391251848011668365710846507942370233740977610553782004147071993884867854495956964329588303034652067584741273292360760811677609829";
		String[] spliStr = req.split("@");
		String miwen = spliStr[0];
		String keyMiwen = spliStr[1];
		System.out.println("miwen="+miwen);
		System.out.println("keyMiwen="+keyMiwen);
		String key = new String(RSASecurityUtils.decryptByprivateKey(keyMiwen, privateKey,modulus));
		String mingwen=AESUtil.decrypt(miwen, key);
		System.out.println("key="+key);
		System.out.println(mingwen);
	}
}
