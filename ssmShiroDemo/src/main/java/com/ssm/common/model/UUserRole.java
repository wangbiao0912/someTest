package com.ssm.common.model;

import java.io.Serializable;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import net.sf.json.JSONObject;

/**
 * 
 * 项目名称：ssmShiroDemo   
 * 类名称：UUserRole   
 * 类描述：   
 *		用户{@link UUser} 和角色 {@link URole} 中间表
 * 创建人：wangbiao  
 * 创建时间：2017年3月30日 下午2:36:06   
 * @version
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class UUserRole  implements Serializable{
	private static final long serialVersionUID = 1L;
	 /**{@link UUser.id}*/
    private Long uid;
    /**{@link URole.id}*/
    private Long rid;

  
    public String toString(){
    	return JSONObject.fromObject(this).toString();
    }
}