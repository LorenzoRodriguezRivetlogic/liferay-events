<%--
/** 
* Copyright (C) 2005-2014 Rivet Logic Corporation. 
* 
* This program is free software; you can redistribute it and/or 
* modify it under the terms of the GNU General Public License 
* as published by the Free Software Foundation; version 3 
* of the License. 
* 
* This program is distributed in the hope that it will be useful, 
* but WITHOUT ANY WARRANTY; without even the implied warranty of 
* MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE. See the 
* GNU General Public License for more details. 
* 
* You should have received a copy of the GNU General Public License 
* along with this program; if not, write to the Free Software 
* Foundation, Inc., 51 Franklin Street, Fifth Floor, 
* Boston, MA 02110-1301, USA. 
*/
--%>

<%@ taglib uri="http://java.sun.com/portlet_2_0" prefix="portlet" %>
<%@ taglib uri="http://java.sun.com/jstl/core_rt" prefix="c" %>
<%@ taglib uri="http://liferay.com/tld/aui" prefix="aui" %>
<%@ taglib uri="http://liferay.com/tld/ui" prefix="liferay-ui" %>
<%@ taglib uri="http://liferay.com/tld/theme" prefix="liferay-theme" %>

<%@ page import="java.text.Format" %>
<%@ page import="java.util.Calendar" %>
<%@ page import="java.util.List" %>

<%@ page import="javax.portlet.PortletPreferences" %>

<%@ page import="com.liferay.portal.kernel.language.LanguageUtil" %>
<%@ page import="com.liferay.portal.kernel.util.GetterUtil" %>
<%@ page import="com.liferay.portal.kernel.bean.BeanParamUtil" %>
<%@ page import="com.liferay.portal.kernel.util.HtmlUtil" %>
<%@ page import="com.liferay.portal.kernel.util.ParamUtil" %>
<%@ page import="com.liferay.portal.kernel.util.StringPool" %>
<%@ page import="com.liferay.portal.kernel.util.PropsUtil"%>
<%@ page import="com.liferay.portal.kernel.log.Log" %>
<%@ page import="com.liferay.portal.kernel.util.CalendarFactoryUtil" %>
<%@ page import="com.liferay.portal.kernel.util.FastDateFormatFactoryUtil" %>
<%@ page import="com.liferay.portal.theme.ThemeDisplay" %>
<%@ page import="com.liferay.portal.util.PortalUtil" %>
<%@ page import="com.liferay.portal.kernel.util.UnicodeFormatter" %>
<%@ page import="com.liferay.portal.kernel.util.Validator" %>
<%@ page import="com.liferay.portal.kernel.dao.search.ResultRow" %>
<%@ page import="com.liferay.portal.kernel.portlet.LiferayWindowState"%>

<%@ page import="com.rivetlogic.event.util.WebKeys" %>
<%@ page import="com.rivetlogic.event.model.Event" %>
<%@ page import="com.rivetlogic.event.model.Location" %>
<%@ page import="com.rivetlogic.event.model.Participant" %>
<%@ page import="com.rivetlogic.event.model.Type" %>
<%@ page import="com.rivetlogic.event.model.Target" %>
<%@ page import="com.rivetlogic.event.service.EventLocalServiceUtil" %>
<%@ page import="com.rivetlogic.event.service.ParticipantLocalServiceUtil" %>
<%@ page import="com.rivetlogic.event.util.EventConstant" %>
<%@ page import="com.rivetlogic.event.notification.constant.NotificationConstants" %>
<%@ page import="com.rivetlogic.event.notification.constant.PreferencesConstants" %>
<%@ page import="com.rivetlogic.event.notification.constant.EmailTemplateVariables" %>
<%@ page import="com.rivetlogic.event.beans.EventsPrefsBean" %>
<%@ page import="com.rivetlogic.event.beans.ManagementPrefsBean" %>
<%@ page import="com.rivetlogic.event.notification.constant.EventPortletConstants" %>


<portlet:defineObjects />
<liferay-theme:defineObjects />
<c:set var="pns"><portlet:namespace/></c:set>

<%
String redirect = ParamUtil.getString(request, WebKeys.REDIRECT);
String currentURL = PortalUtil.getCurrentURL(request);
%>