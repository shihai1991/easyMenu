package com.hayes.easyMenu.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hayes.easyMenu.common.SysConst;
import com.hayes.easyMenu.common.SysResourcesTree;
import com.hayes.easyMenu.dao.SysResourcesDao;
import com.hayes.easyMenu.model.SysResources;
import com.hayes.easyMenu.service.SysResourcesService;

@Service("sysResourcesService")
public class SysResourcesServiceImpl implements SysResourcesService {

	@Autowired
	private SysResourcesDao sysResourcesDao;
	
	public void INIT_RESOURCES_TREE() {
		SysResources resource = new SysResources();
		resource.setType("user");
		List<SysResources> sysResources = sysResourcesDao.queryList(resource);
		SysConst.SYS_RESOURCES_TREE = new SysResourcesTree(sysResources);
	}

}
