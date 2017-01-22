/** 
 * 2015 UssBaseController.java
 * Created by Steven J.S Min(steven.min@utilitiessoftwareservices.com)
 *  
 * Licensed to the Utilities Software Services(USS). 
 * For use this source code, you must obtain proper permission. 
 * Or enforcement is prohibited by applicable law, you may not modify, decompile, or reverse engineer Software.
 */

package coupang.framework.system;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.context.MessageSourceAware;

import coupang.framework.attachement.AttachmentFileService;
import coupang.framework.auth.AuthService;
import coupang.framework.code.CodeService;
import coupang.framework.document.DocumentService;
import coupang.framework.role.RoleService;
import coupang.framework.user.UserService;

/**
 * @author Steven Min
 *
 */
public class BaseController implements MessageSourceAware {

	protected MessageSource messageSource;

	@Autowired
	protected AuthService authService;

	@Autowired
	protected CodeService codeService;

	@Autowired
	protected UserService userService;

	@Autowired
	protected RoleService roleService;

	@Autowired
	protected DocumentService documentService;
	
	@Autowired
	protected AttachmentFileService attachmentFileService;

	@Override
	public void setMessageSource(MessageSource messageSource) {
		this.messageSource = messageSource;
	}

	protected Integer getPageSize(HttpServletRequest request) {
		String pageSize = request.getParameter("pageSize");
		if (StringUtils.isEmpty(pageSize) || StringUtils.equalsIgnoreCase(pageSize, "null") || !StringUtils.isNumeric(pageSize)) {
			pageSize = "10";
		}

		Integer pagenationPageSize = Integer.parseInt(pageSize);

		return pagenationPageSize;
	}

	protected Integer getPage(HttpServletRequest request) {
		String page = request.getParameter("page");

		if (StringUtils.isEmpty(page) || StringUtils.equalsIgnoreCase(page, "null") || !StringUtils.isNumeric(page)) {
			page = "0";
		}
		Integer pagenationPage = (Integer.parseInt(page) - 1) * (this.getPageSize(request));

		if (pagenationPage < 0) pagenationPage = 0;

		return pagenationPage;
	}

}
