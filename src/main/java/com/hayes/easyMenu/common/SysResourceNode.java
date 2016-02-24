package com.hayes.easyMenu.common;

import java.util.ArrayList;
import java.util.List;

import com.hayes.easyMenu.model.SysResources;

public class SysResourceNode extends SysResources {
	
	private List<SysResourceNode> children;
	
	public void addChild(SysResourceNode node){
		if(this.children == null){
			this.children = new ArrayList<SysResourceNode>();
		}
		this.children.add(node);
	}
	
	public List<SysResourceNode> getChildren(){
		return children;
	}
}
