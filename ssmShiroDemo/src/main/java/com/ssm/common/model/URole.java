package com.ssm.common.model;

import java.io.Serializable;
import java.util.LinkedList;
import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import net.sf.json.JSONObject;

/**
 * 
 * 项目名称：ssmShiroDemo   
 * 类名称：URole   
 * 类描述：   
 *		权限角色
 * 创建人：wangbiao  
 * 创建时间：2017年3月30日 下午2:35:20   
 * @version
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class URole  implements Serializable{
	private static final long serialVersionUID = 1L;
    private Long id;
    /**角色名称*/
    private String name;
    /**角色类型*/
    private String type;
    //***做 role --> permission 一对多处理
    private List<UPermission> permissions = new LinkedList<UPermission>();
    
    public String toString(){
    	return JSONObject.fromObject(this).toString();
    }
}