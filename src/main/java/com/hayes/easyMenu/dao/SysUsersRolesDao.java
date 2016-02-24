package com.hayes.easyMenu.dao;

import java.util.List;

import com.hayes.easyMenu.model.SysUsersRoles;


public interface SysUsersRolesDao{

	public int insertSysUsersRoles(SysUsersRoles sysUsersRoles);

	public int deleteSysUsersRoles(Integer id);

	public int updateSysUsersRoles(SysUsersRoles sysUsersRoles);

	public SysUsersRoles loadSysUsersRoles(Integer id);

	public List<SysUsersRoles> queryList(SysUsersRoles sysUsersRoles);

	public List<SysUsersRoles> queryPageList(SysUsersRoles sysUsersRoles);

	public int queryCount(SysUsersRoles sysUsersRoles);

	public List<SysUsersRoles> getRoles(Integer userID);
	
	public List<Integer> getRoleIDs(Integer userID);
}
