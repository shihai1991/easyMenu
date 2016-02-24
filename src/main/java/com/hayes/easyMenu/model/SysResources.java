package com.hayes.easyMenu.model;


/**
 * SysResources
 *
 */
public class SysResources{
	
	/**ID**/
	private Integer id;
	/**标题**/
	private String text;
	/**资源类型**/
	private String type;
	/**URL**/
	private String url;
	/**父ID**/
	private Integer parentid;
	/**备注**/
	private String remark;
	/**状态**/
	private String status;
	/**标志图片**/
	private String icon;
	
	public void setId(Integer id) {
		this.id = id;
	}
	
	public Integer getId() {
		return this.id;
	}
	
	public void setText(String text) {
		this.text = text;
	}
	
	public String getText() {
		return this.text;
	}
	
	public void setType(String type) {
		this.type = type;
	}
	
	public String getType() {
		return this.type;
	}
	
	public void setUrl(String url) {
		this.url = url;
	}
	
	public String getUrl() {
		return this.url;
	}
	
	public void setParentid(Integer parentid) {
		this.parentid = parentid;
	}
	
	public Integer getParentid() {
		return this.parentid;
	}
	
	public void setRemark(String remark) {
		this.remark = remark;
	}
	
	public String getRemark() {
		return this.remark;
	}
	
	public void setStatus(String status) {
		this.status = status;
	}
	
	public String getStatus() {
		return this.status;
	}
	
	public void setIcon(String icon) {
		this.icon = icon;
	}
	
	public String getIcon() {
		return this.icon;
	}
}

