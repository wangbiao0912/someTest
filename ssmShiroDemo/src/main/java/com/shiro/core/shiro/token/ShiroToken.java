package com.shiro.core.shiro.token;

import org.apache.shiro.authc.UsernamePasswordToken;

/**
 * 
 * 项目名称：ssmShiroDemo   
 * 类名称：ShiroToken   
 * 类描述：   
 *		Shiro token
 * 创建人：wangbiao  
 * 创建时间：2017年3月31日 下午4:38:06   
 * @version
 */
public class ShiroToken extends UsernamePasswordToken  implements java.io.Serializable{
	
	private static final long serialVersionUID = -6451794657814516274L;

	public ShiroToken(String username, String pswd) {
		super(username,pswd);
		this.pswd = pswd ;
	}
	
	
	/** 登录密码[字符串类型] 因为父类是char[] ] **/
	private String pswd ;

	public String getPswd() {
		return pswd;
	}


	public void setPswd(String pswd) {
		this.pswd = pswd;
	}
	
	
	
	
	
}
