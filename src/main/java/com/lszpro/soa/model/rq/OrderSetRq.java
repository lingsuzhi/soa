package com.lszpro.soa.model.rq;


import com.lszpro.soa.common.BaseRq;

/**
 * Admin: lingsuzhi <554600654@qq.com.com>
 * 时间: 2018-1-19
 * 单据配置
 */

public class OrderSetRq extends BaseRq {

private static final long serialVersionUID = 1L;
private String name;
private String diseasescode;

public String getDiseasescode() {
	return diseasescode;
}
public void setDiseasescode(String diseasescode) {
	this.diseasescode = diseasescode;
}
public static long getSerialversionuid() {
	return serialVersionUID;
}
public String getName() {
return name;
}
public void setName(String name) {
this.name = name;
}
}