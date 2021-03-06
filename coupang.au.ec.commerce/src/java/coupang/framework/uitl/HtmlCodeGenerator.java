/** 
 * 2015 HtmlCodeGenerator.java
 * Created by Steven J.S Min(steven.min@utilitiessoftwareservices.com)
 *  
 * Licensed to the Utilities Software Services(USS). 
 * For use this source code, you must obtain proper permission. 
 * Or enforcement is prohibited by applicable law, you may not modify, decompile, or reverse engineer Software.
 */

package coupang.framework.uitl;

import java.util.List;

import org.apache.commons.lang.StringUtils;

import coupang.framework.code.Code;

/**
 * @author Steven J.S Min(steven.min@utilitiessoftwareservices.com)
 *
 */
public final class HtmlCodeGenerator {

	static public String generateComboboxForCodeInfo(String cssClass, String objId, String objName, List<Code> list) {
		return HtmlCodeGenerator.generateComboboxForCodeInfo(cssClass, objId, objName, null, list);
	}

	static public String generateComboboxForCodeInfo(String cssClass, String objId, String objName, String cssStyle, List<Code> list) {
		return HtmlCodeGenerator.generateComboboxForCodeInfo(cssClass, objId, objName, cssStyle, list, null);
	}

	static public String generateComboboxForCodeInfo(String cssClass, String objId, String objName, String cssStyle, String event, List<Code> list) {
		return HtmlCodeGenerator.generateComboboxForCodeInfo(cssClass, objId, objName, cssStyle, event, list, null);
	}
	
	static public String generateComboboxForCodeInfo(String cssClass, String objId, String objName, String cssStyle, List<Code> list, String defaultSelect) {
		return HtmlCodeGenerator.generateComboboxForCodeInfo(cssClass, objId, objName, cssStyle, null, list, defaultSelect);
	}
	
	
	static public String generateComboboxForCodeInfo(String cssClass, String objId, String objName, String cssStyle, String event, List<Code> list, String defaultSelect) {
		
		StringBuffer html = new StringBuffer("<select ");
		if (StringUtils.isNotBlank(cssClass)) html.append("class='" + cssClass + "' ");
		if (StringUtils.isNotBlank(objName)) html.append("name='" + objName + "' ");
		if (StringUtils.isNotBlank(objId)) html.append("id='" + objId + "' ");
		if (StringUtils.isNotBlank(cssStyle)) html.append("style='" + cssStyle + "' ");
		if (StringUtils.isNotBlank(event)) html.append(" " + event + " ");
		html.append(">");
		
		html.append("<option value=''> - Select - </option>");
		for (Code code : list) {

			if (StringUtils.equalsIgnoreCase(code.getValue(), defaultSelect)) {
				html.append("<option value='" + code.getValue() + "' selected>" + code.getLabel() + "</option>");
			} else {
				html.append("<option value='" + code.getValue() + "'>" + code.getLabel() + "</option>");
			}
		}
		html.append("</select>");
		return html.toString();
	}
}
