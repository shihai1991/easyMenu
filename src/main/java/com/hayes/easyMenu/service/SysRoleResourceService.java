package com.hayes.easyMenu.service;

import java.util.List;

public interface SysRoleResourceService {

	/**
	 * 根据角色ID集合查找资源ID集合
	 * @param roleIDs 角色ID集合
	 * @return resourceIDs 资源ID集合
	 */
	public List<Integer> getResources(List<Integer> roleIDs);
}
