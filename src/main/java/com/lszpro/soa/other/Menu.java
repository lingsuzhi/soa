package com.lszpro.soa.other;

import java.util.Date;

/**
 * Admin: lingsuzhi <554600654@qq.com.com>
 * Date: 2017-09-04
 */


public class Menu {
 /** key */
private String id;
 /** 功能名称 */
private String menuName;
 /** 功能地址 */
private String menuUrl;
 /** 父菜单ID */
private String parentId;
 /** 授权（多个用逗号分割，如：user:list,user:create) */
private String perms;
 /** 类型：1目录，2菜单，3按钮 */
private String type;
 /** 图标样式 */
private String icon;
 /** 排序 */
private Integer sort;
 /** 状态：0无效，1有效 */
private boolean status;
 /** 创建时间 */
private Date createTime;
 /** 备注 */
private String remark;

public String getId(){
    return id;
}
public void setId(String id){
   this.id = id;
}
public String getMenuName(){
    return menuName;
}
public void setMenuName(String menuName){
   this.menuName = menuName;
}
public String getMenuUrl(){
    return menuUrl;
}
public void setMenuUrl(String menuUrl){
   this.menuUrl = menuUrl;
}
public String getParentId(){
    return parentId;
}
public void setParentId(String parentId){
   this.parentId = parentId;
}
public String getPerms(){
    return perms;
}
public void setPerms(String perms){
   this.perms = perms;
}
public String getType(){
    return type;
}
public void setType(String type){
   this.type = type;
}
public String getIcon(){
    return icon;
}
public void setIcon(String icon){
   this.icon = icon;
}
public Integer getSort(){
    return sort;
}
public void setSort(Integer sort){
   this.sort = sort;
}
public boolean getStatus(){
    return status;
}
public void setStatus(boolean status){
   this.status = status;
}
public Date getCreateTime(){
    return createTime;
}
public void setCreateTime(Date createTime){
   this.createTime = createTime;
}
public String getRemark(){
    return remark;
}
public void setRemark(String remark){
   this.remark = remark;
}

@Override
public String toString() {
return "Menu {\r\n"+
"\""+"id"+"\""+":"+"\""+id+"\""+",\r\n"+
"\""+"menuName"+"\""+":"+"\""+menuName+"\""+",\r\n"+
"\""+"menuUrl"+"\""+":"+"\""+menuUrl+"\""+",\r\n"+
"\""+"parentId"+"\""+":"+"\""+parentId+"\""+",\r\n"+
"\""+"perms"+"\""+":"+"\""+perms+"\""+",\r\n"+
"\""+"type"+"\""+":"+"\""+type+"\""+",\r\n"+
"\""+"icon"+"\""+":"+"\""+icon+"\""+",\r\n"+
"\""+"sort"+"\""+":"+"\""+sort+"\""+",\r\n"+
"\""+"status"+"\""+":"+"\""+status+"\""+",\r\n"+
"\""+"createTime"+"\""+":"+"\""+createTime+"\""+",\r\n"+
"\""+"remark"+"\""+":"+"\""+remark+"\""+"}";
}
}
