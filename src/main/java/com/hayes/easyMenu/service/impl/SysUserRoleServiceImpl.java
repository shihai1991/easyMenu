package com.hayes.easyMenu.service.impl;

import java.util.List;
import java.util.Set;
import java.util.TreeSet;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hayes.easyMenu.dao.SysUsersRolesDao;
import com.hayes.easyMenu.model.SysUsersRoles;
import com.hayes.easyMenu.service.SysUserRoleService;

@Service("sysUserRoleService")
public class SysUserRoleServiceImpl implements SysUserRoleService {

	@Autowired
	private SysUsersRolesDao usersRolesDao;
	
	public List<SysUsersRoles> getRoles(Integer userID) {
		List<SysUsersRoles> userRoles = usersRolesDao.getRoles(userID);
		this.removeDuplicateUserRole(userRoles);
		return userRoles;
	}

	public List<Integer> getRoleIDs(Integer userID) {
		List<Integer> roleIDs = usersRolesDao.getRoleIDs(userID);
		this.removeDuplicateRoleIDs(roleIDs);
		return roleIDs;
	}

	/**
	 * 删除重复的角色ID
	 * @param roleIDs
	 */
	private void removeDuplicateRoleIDs(List<Integer> roleIDs){
		Set<Integer> roleIDSet = new TreeSet<Integer>();
		for(Integer roleID : roleIDs){
			if(!roleIDSet.contains(roleID)){
				roleIDSet.add(roleID);
			}
		}
		roleIDs.clear();
		roleIDs.addAll(roleIDSet);
	}

	/**
	 * 删除重复的用户角色
	 * @param roleIDs
	 */
	private void removeDuplicateUserRole(List<SysUsersRoles> userRoles){
		Set<SysUsersRoles> userRoleSet = new TreeSet<SysUsersRoles>();
		for(SysUsersRoles userRole : userRoles){
			if(!userRoleSet.contains(userRole)){
				userRoleSet.add(userRole);
			}
		}
		userRoles.clear();
		userRoles.addAll(userRoleSet);
	}
}
