package com.lszpro.soa.model.rq;


import com.lszpro.soa.common.BaseRq;

public class CustomerTypeRq extends BaseRq {

private static final long serialVersionUID = 1L;
private String name;
	private String parentId;

	public String getParentId() {
		return parentId;
	}

	public void setParentId(String parentId) {
		this.parentId = parentId;
	}

	public String getName() {
return name;
}
public void setName(String name) {
this.name = name;
}
}