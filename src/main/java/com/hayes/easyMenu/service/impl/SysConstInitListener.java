package com.hayes.easyMenu.service.impl;

import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Autowired;

import com.hayes.easyMenu.service.SysResourcesService;

/**
 * 系统资源的初始化
 * @author shih Date:2016/02/13
 * 
 */

public class SysConstInitListener implements InitializingBean{
	
	@Autowired
	private SysResourcesService resourcesService;
	
	public void afterPropertiesSet() throws Exception {
		resourcesService.INIT_RESOURCES_TREE();
	}

}
