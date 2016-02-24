package com.hayes.easyMenu.common;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.springframework.beans.BeanUtils;

import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import com.hayes.easyMenu.model.SysResources;


public class SysResourcesTree {
	private List<SysResources> sysResources;
	private Map<Integer, SysResourceNode> tree = new HashMap<Integer, SysResourceNode>();
	
	public SysResourcesTree(List<SysResources> sysResouces){
		this.sysResources = sysResouces;
		buildResourcesTree();
	}
	
	private void buildResourcesTree(){
		for(SysResources resource : sysResources){
			SysResourceNode node = new SysResourceNode();
			try {
				BeanUtils.copyProperties(resource, node);
			} catch (Exception e) {
			}
			
			if(tree.containsKey(resource.getParentid())){
				SysResourceNode parentNode = (SysResourceNode)tree.get(resource.getParentid());
				parentNode.addChild(node);
			}
			tree.put(node.getId(), node);
		}
	}
	
	/**
	 * { "menus":[{
	 * 		"menuID":xx,
	 * 		"menuName":xx,
	 * 		"icon":xx,
	 * 		"menus":[
	 *				{"menuID":xx,menuName:xx,"icon":xx, "url":xx},{...},{...}]
	 * },
	 * {...},
	 * {...}]
	 * }
	 * @param resourceIDs
	 */
	public synchronized JsonObject buildMenuResouceTree(List<Integer> resourceIDs){
		List<SysResourceNode> anceNodes = new ArrayList<SysResourceNode>();
		for(Integer resourceID : resourceIDs){
			this.getAnceNodes(this.getNode(resourceID), anceNodes);
		}
		this.removeDuplicateNodes(anceNodes);
		
		JsonObject menuJsonObject = new JsonObject();
		JsonArray menusJsonObject = new JsonArray();
		
		for(SysResourceNode resourceNode : anceNodes){
			
			//the default second level menu's length is 3
			if(resourceNode.getId().toString().length() == SysConst.SYS_MENUS_DESIGN.FirstLevel.getMenuIDLength()){
				menusJsonObject.add(this.buildFirstLevelMenuNode(resourceNode, resourceNode.getChildren()));
			}
		}
		menuJsonObject.add("menus", menusJsonObject);
		return menuJsonObject;
	}

	/**
	 * build the second level menu
	 * @param firstLevelNode the first level menu list
	 * @param childNodes children nodes
	 * @return Json object
	 */
	private JsonObject buildFirstLevelMenuNode(SysResourceNode firstLevelNode, List<SysResourceNode> childNodes){
		JsonObject firstLevelMenuNode = new JsonObject();
		JsonArray secondLevelChildMenuNodes = new JsonArray();
		
		for(SysResourceNode resourceNode : childNodes){
			
			//the default second level menu's length is 5
			if(resourceNode.getId().toString().length() == SysConst.SYS_MENUS_DESIGN.SecondLevel.getMenuIDLength()){
				secondLevelChildMenuNodes.add(this.buildSecondLevelMenuNode(resourceNode));
			}
		}
		firstLevelMenuNode.addProperty("menuID", firstLevelNode.getId());
		firstLevelMenuNode.addProperty("menuName", firstLevelNode.getText());
		firstLevelMenuNode.addProperty("icon", firstLevelNode.getIcon());
		firstLevelMenuNode.add("menus", secondLevelChildMenuNodes);
		return firstLevelMenuNode;
	}

	/**
	 * build the second level nodes
	 * @param secondLevelNode
	 * @return Json object
	 */
	private JsonObject buildSecondLevelMenuNode(SysResourceNode secondLevelNode){
		JsonObject secondLevelMenuNode = new JsonObject();
		secondLevelMenuNode.addProperty("menuID", secondLevelNode.getId());
		secondLevelMenuNode.addProperty("menuName", secondLevelNode.getText());
		secondLevelMenuNode.addProperty("icon", secondLevelNode.getIcon());
		secondLevelMenuNode.addProperty("url", secondLevelNode.getUrl());
		return secondLevelMenuNode;
	}
	
	/**
	 * remove the same parent nodes
	 * @param nodes resource node list
	 */
	private void removeDuplicateNodes(List<SysResourceNode> resourceNodes){
		Set<SysResourceNode> nodeSet = new HashSet<SysResourceNode>();
		List<SysResourceNode> tmpResourceNodes = new ArrayList<SysResourceNode>();
		for(SysResourceNode resouceNode : resourceNodes){
			if(!nodeSet.contains(resouceNode)){
				nodeSet.add(resouceNode);
				tmpResourceNodes.add(resouceNode);
			}
		}
		resourceNodes.clear();
		resourceNodes.addAll(tmpResourceNodes);
	}
	
	public SysResourceNode getNode(Integer key){
		return tree.get(key);
	}
	
	/**
	 * 
	 * @param currentNode
	 * @param anceNodes 
	 */
	private synchronized void getAnceNodes(SysResourceNode currentNode, List<SysResourceNode> anceNodes){
		if(currentNode.getParentid() == null){
			return;
		}
		
		if(this.tree.get(currentNode.getParentid()) != null 
				&& currentNode.getStatus().equals(SysConst.SYS_RESOURCE_STATUS.Use.getValue())){
			SysResourceNode parentNode = this.tree.get(currentNode.getParentid());
			anceNodes.add(parentNode);
			//recursive the ancient's node
			this.getAnceNodes(parentNode, anceNodes);
		}
	}
}
