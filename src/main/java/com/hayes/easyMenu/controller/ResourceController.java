package com.hayes.easyMenu.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.google.gson.Gson;
import com.google.gson.JsonObject;
import com.hayes.easyMenu.common.SysConst;
import com.hayes.easyMenu.service.SysRoleResourceService;
import com.hayes.easyMenu.service.SysUserRoleService;

@Controller
@RequestMapping("/resource")
public class ResourceController {

	@Autowired
	private SysUserRoleService userRoleService;
	@Autowired
	private SysRoleResourceService roleResourceService;
	
	@RequestMapping("/easyMenu")
	public void getEasyMenu(HttpServletRequest request, HttpServletResponse response) throws IOException{
		String sRole = request.getParameter("role");
		Integer role = Integer.parseInt(sRole);
		List<Integer> roleIDs = new ArrayList<Integer>();
		// just only a demo!!!
		roleIDs.add(role);
		List<Integer> resourceIDs = roleResourceService.getResources(roleIDs);
		JsonObject menuJsonObject = SysConst.SYS_RESOURCES_TREE.buildMenuResouceTree(resourceIDs);
		response.setCharacterEncoding("UTF-8");
		PrintWriter out = response.getWriter();
		Gson gson = new Gson();
		out.write(gson.toJson(menuJsonObject));
		out.flush();
		out.close();
	}
}
