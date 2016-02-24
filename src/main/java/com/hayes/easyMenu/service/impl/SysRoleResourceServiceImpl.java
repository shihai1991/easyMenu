package com.hayes.easyMenu.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hayes.easyMenu.dao.SysRolesResourcesDao;
import com.hayes.easyMenu.service.SysRoleResourceService;


@Service("sysRoleResourceService")
public class SysRoleResourceServiceImpl implements SysRoleResourceService {

	@Autowired
	private SysRolesResourcesDao rolesResourcesDao;
	
	public List<Integer> getResources(List<Integer> roleIDs) {
		if(roleIDs.size() < 0){
			return null;
		}
		
		List<Integer> resourceIDs = new ArrayList<Integer>();

		for(Integer roleID : roleIDs){
			resourceIDs.addAll(rolesResourcesDao.getResourceIDs(roleID));
		}
		return resourceIDs;
	}

}
