package com.ssm.permission.bo;

import java.io.Serializable;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * 
 * 项目名称：ssmShiroDemo   
 * 类名称：RolePermissionAllocationBo   
 * 类描述：   
 *			权限分配 查询列表BO
 * 创建人：wangbiao  
 * 创建时间：2017年3月30日 下午2:27:03   
 * @version
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class RolePermissionAllocationBo implements Serializable {
	private static final long serialVersionUID = 1L;
	//角色ID
	private Long id;
	//角色type
	private String type;
	//角色Name
	private String name;
	//权限Name列转行，以,分割
	private String permissionNames;
	//权限Id列转行，以‘,’分割
	private String permissionIds;


	
	
}
