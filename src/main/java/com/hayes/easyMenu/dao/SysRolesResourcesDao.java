package com.hayes.easyMenu.dao;

import java.util.List;

import com.hayes.easyMenu.model.SysRolesResources;

public interface SysRolesResourcesDao{

	public int insertSysRolesResources(SysRolesResources sysRolesResources);

	public int deleteSysRolesResources(Integer id);

	public int updateSysRolesResources(SysRolesResources sysRolesResources);

	public SysRolesResources loadSysRolesResources(Integer id);

	public List<SysRolesResources> queryList(SysRolesResources sysRolesResources);

	public List<SysRolesResources> queryPageList(SysRolesResources sysRolesResources);

	public int queryCount(SysRolesResources sysRolesResources);

	public List<Integer> getResourceIDs(Integer roleID);
}
