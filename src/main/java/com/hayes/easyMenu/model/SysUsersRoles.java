package com.hayes.easyMenu.model;

/**
 * SysUsersRoles
 *
 */
public class SysUsersRoles{
	
	/**ID**/
	private Integer id;
	/**用户ID**/
	private Integer uid;
	/**角色ID**/
	private Integer rid;
	/**状态**/
	private String status;
	
	public void setId(Integer id) {
		this.id = id;
	}
	
	public Integer getId() {
		return this.id;
	}
	
	public void setUid(Integer uid) {
		this.uid = uid;
	}
	
	public Integer getUid() {
		return this.uid;
	}
	
	public void setRid(Integer rid) {
		this.rid = rid;
	}
	
	public Integer getRid() {
		return this.rid;
	}
	
	public void setStatus(String status) {
		this.status = status;
	}
	
	public String getStatus() {
		return this.status;
	}
}

