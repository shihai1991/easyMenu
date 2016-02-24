package com.hayes.easyMenu.dao;

import java.util.List;
import com.hayes.easyMenu.model.SysResources;

public interface SysResourcesDao{

	public int insertSysResources(SysResources sysResources);

	public int deleteSysResources(Integer id);

	public int updateSysResources(SysResources sysResources);

	public SysResources loadSysResources(Integer id);

	public List<SysResources> queryList(SysResources sysResources);

	public List<SysResources> queryPageList(SysResources sysResources);

	public int queryCount(SysResources sysResources);

}
