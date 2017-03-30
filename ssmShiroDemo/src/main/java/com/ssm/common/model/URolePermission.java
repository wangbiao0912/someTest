package com.ssm.common.model;

import java.io.Serializable;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import net.sf.json.JSONObject;

/**
 * 
 * 项目名称：ssmShiroDemo   
 * 类名称：URolePermission   
 * 类描述：   
 *		角色{@link URole}和 权限{@link UPermission}中间表
 * 创建人：wangbiao  
 * 创建时间：2017年3月30日 下午2:35:32   
 * @version
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class URolePermission  implements Serializable{
	private static final long serialVersionUID = 1L;
	/**{@link URole.id}*/
    private Long rid;
    /**{@link UPermission.id}*/
    private Long pid;

    public String toString(){
    	return JSONObject.fromObject(this).toString();
    }
}