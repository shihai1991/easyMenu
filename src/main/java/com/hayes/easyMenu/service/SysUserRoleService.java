package com.hayes.easyMenu.service;

import java.util.List;

import com.hayes.easyMenu.model.SysUsersRoles;

/**
 * 用户角色服务
 * @author shih Date:2016/02/17
 *
 */
public interface SysUserRoleService {
	
	/**
	 * 根据用户ID查询角色集
	 * @param userID
	 * @return
	 */
	public List<SysUsersRoles> getRoles(Integer userID);
	
	/**
	 * 根据用户ID查找角色ID集合
	 * @param userID
	 * @return roleIDs 
	 */
	public List<Integer> getRoleIDs(Integer userID);
}
