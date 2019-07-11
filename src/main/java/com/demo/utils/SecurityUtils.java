package com.demo.utils;


import org.apache.commons.lang.StringEscapeUtils;
import org.springframework.web.util.HtmlUtils;
import org.springframework.web.util.JavaScriptUtils;

import javax.servlet.http.HttpServletRequest;

/**
 * 安全参数过滤
 * @author  renshuai
 * @version 1.0
 */
public class SecurityUtils {
	/**
	 * 防止SQL注入
	 * @param name
	 * @return
	 */
	public static String getPara(HttpServletRequest request,String name){
		String s1 = request.getParameter(name);
		s1 = StringEscapeUtils.escapeSql(s1);
	    s1 = HtmlUtils.htmlEscape(s1);
	    s1 = JavaScriptUtils.javaScriptEscape(s1);
		return s1;
	}
}
