package com.hayes.easyMenu.common;

/**
 * system's constant
 * @author hayes
 */
public class SysConst {
    
	// the menu tree 
	public static SysResourcesTree SYS_RESOURCES_TREE;
	
	//the resource's status
	public static enum SYS_RESOURCE_STATUS{
		Use(1,"use"),
		UnUse(0,"unUse");
		
		private int key;
		private String value;
		
		public int getKey(){
			return key;
		}
		
		public String getValue(){
			return value;
		}
		
		SYS_RESOURCE_STATUS(int key, String value){
			this.key = key;
			this.value = value;
		}
	}
	
	// menu id's length
	public static enum SYS_MENUS_DESIGN{
		//the first level's menu
		FirstLevel(3),
		//the second level's menu
		SecondLevel(5);
		
		private int length;
		
		SYS_MENUS_DESIGN(int length){
			this.length = length;
		}
		
		public int getMenuIDLength(){
			return this.length;
		}
	}
	
}
