package com.ssm.common.model;

import java.io.Serializable;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import net.sf.json.JSONObject;

/**
 * 
 * 项目名称：ssmShiroDemo   
 * 类名称：UPermission   
 * 类描述：   
 *		权限实体
 * 创建人：wangbiao  
 * 创建时间：2017年3月30日 下午2:35:07   
 * @version
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class UPermission implements Serializable {
	private static final long serialVersionUID = 1L;
	private Long id;
	/** 操作的url */
	private String url;
	/** 操作的名称 */
	private String name;

	public String toString() {
		return JSONObject.fromObject(this).toString();
	}
}