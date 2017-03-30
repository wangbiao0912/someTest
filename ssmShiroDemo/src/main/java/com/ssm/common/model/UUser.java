package com.ssm.common.model;

import java.io.Serializable;
import java.util.Date;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import net.sf.json.JSONObject;

/**
 * 
 * 项目名称：ssmShiroDemo   
 * 类名称：UUser   
 * 类描述：   
 *		 用户
 * 创建人：wangbiao  
 * 创建时间：2017年3月30日 下午2:35:54   
 * @version
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class UUser implements Serializable{
	private static final long serialVersionUID = 1L;
	//0:禁止登录
	public static final Long _0 = new Long(0);
	//1:有效
	public static final Long _1 = new Long(1);
	private Long id;
	/**昵称*/
    private String nickname;
    /**邮箱 | 登录帐号*/
    private String email;
    /**密码*/
    private transient String pswd;
    /**创建时间*/
    private Date createTime;
    /**最后登录时间*/
    private Date lastLoginTime;
    /**1:有效，0:禁止登录*/
    private Long status;
    
    
    public String toString(){
    	return JSONObject.fromObject(this).toString();
    }
}