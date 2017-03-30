package com.ssm.permission.bo;

import java.io.Serializable;

import com.project.common.utils.StringUtils;
import com.ssm.common.model.UPermission;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * 
 * 项目名称：ssmShiroDemo   
 * 类名称：UPermissionBo   
 * 类描述：   
 *		权限选择
 * 创建人：wangbiao  
 * 创建时间：2017年3月30日 下午2:27:37   
 * @version
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class UPermissionBo extends UPermission implements Serializable {
	private static final long serialVersionUID = 1L;
	/**
	 * 是否勾选
	 */
	private String marker;
	/**
	 * role Id
	 */
	private String roleId;

	public boolean isCheck(){
		return StringUtils.equals(roleId,marker);
	}
	
}
