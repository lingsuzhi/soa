package com.lszpro.soa.common;
import com.github.pagehelper.Page;

import java.beans.PropertyDescriptor;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;

import com.lszpro.soa.exception.ServiceException;
import org.apache.commons.beanutils.PropertyUtilsBean;
import org.springframework.http.ResponseEntity;
import org.springframework.util.StringUtils;


public class LszUtil {
public static ResponseEntity returnList(List list){
	

	return ResponseEntity.ok( toMap("data", list,"count",((Page) list).getTotal(),"msg","","code",0) );
}
/**获取一位随机数 0到9**/
public static int getRand0to9(){
	Random r = new Random();
	//r.setSeed(System.currentTimeMillis());
	return r.nextInt(10);
}
//将javabean实体类转为map类型，然后返回一个map类型的值
public static Map<String, Object> beanToMap(Object obj) { 
        Map<String, Object> params = new HashMap<String, Object>(0); 
        try { 
            PropertyUtilsBean propertyUtilsBean = new PropertyUtilsBean(); 
            PropertyDescriptor[] descriptors = propertyUtilsBean.getPropertyDescriptors(obj); 
            for (int i = 0; i < descriptors.length; i++) { 
                String name = descriptors[i].getName(); 
                if (!"class".equals(name)) { 
                    params.put(name, propertyUtilsBean.getNestedProperty(obj, name)); 
                } 
            } 
        } catch (Exception e) { 
            e.printStackTrace(); 
        } 
        return params; 
}
    //将javabean实体类转为map类型，然后返回一个map类型的值
    public static Map<String, Object> beanToMapEmpty(Object obj) {
        Map<String, Object> params = new HashMap<String, Object>(0);
        try {
            PropertyUtilsBean propertyUtilsBean = new PropertyUtilsBean();
            PropertyDescriptor[] descriptors = propertyUtilsBean.getPropertyDescriptors(obj);
            for (int i = 0; i < descriptors.length; i++) {
                String name = descriptors[i].getName();
                if (!"class".equals(name)) {
                    Object value = propertyUtilsBean.getNestedProperty(obj, name);
                    if (!StringUtils.isEmpty(value)){
                        params.put(name,value );
                    }

                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return params;
    }
/**
 * 返回Map形式的对象，参数必须为偶数个
 *
 * @param kvs 键值对
 * @return Map
 */
public static Map toMap(Object... kvs) {

    Map<Object, Object> map = new HashMap<>();

    if (kvs.length % 2 != 0) {
        throw new RuntimeException("Params must be key, value pairs.");
    }
    for (int i = 0; i < kvs.length; i += 2) {
    	Object obj = kvs[i + 1];
	    	map.put(kvs[i], obj);
    }
    return map;
}
public static Date dateDay(Date date){
    //时间删除时分秒
    SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd");
   String str = df.format(date);

    Date date1 = null;
    try {
        date1 = df.parse(str);
    } catch (ParseException e) {
        e.printStackTrace();
    }
    return date1;


}

    public static String  yyyyMMdd(Date date){
        //时间删除时分秒
        SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd");
        String str = df.format(date);
return str;


    }
	public static String createToken(String id) {
	 
	if (id ==null || id.isEmpty()){
		  throw new ServiceException("9999","用户 id 错误");
	}
	Date date = new Date();
	long l = date.getTime() / (1000*60*60*24*7L);
	String tokenStr =  id + String.valueOf(l);

		try {
			tokenStr = Utils.md5(tokenStr);
			return tokenStr;
			 
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
		return null;
}
}
