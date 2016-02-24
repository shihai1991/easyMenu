package com.hayes.easyMenu.model;

/**
 * SysRolesResources
 *
 */
public class SysRolesResources{
	
	/**ID**/
	private Integer id;
	/**ID**/
	private Integer sysId;
	/**角色ID**/
	private Integer rid;
	/**资源ID**/
	private Integer resid;
	/**组织ID**/
	private Integer organizationId;
	/**状态**/
	private String status;
	
	public void setId(Integer id) {
		this.id = id;
	}
	
	public Integer getId() {
		return this.id;
	}
	
	public void setSysId(Integer sysId) {
		this.sysId = sysId;
	}
	
	public Integer getSysId() {
		return this.sysId;
	}
	
	public void setRid(Integer rid) {
		this.rid = rid;
	}
	
	public Integer getRid() {
		return this.rid;
	}
	
	public void setResid(Integer resid) {
		this.resid = resid;
	}
	
	public Integer getResid() {
		return this.resid;
	}
	
	public void setOrganizationId(Integer organizationId) {
		this.organizationId = organizationId;
	}
	
	public Integer getOrganizationId() {
		return this.organizationId;
	}
	
	public void setStatus(String status) {
		this.status = status;
	}
	
	public String getStatus() {
		return this.status;
	}
}

