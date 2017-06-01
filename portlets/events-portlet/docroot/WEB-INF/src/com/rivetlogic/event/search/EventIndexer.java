package com.rivetlogic.event.search;

import com.liferay.portal.kernel.dao.orm.ActionableDynamicQuery;
import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.search.BaseIndexer;
import com.liferay.portal.kernel.search.Document;
import com.liferay.portal.kernel.search.Field;
import com.liferay.portal.kernel.search.SearchContext;
import com.liferay.portal.kernel.search.SearchEngineUtil;
import com.liferay.portal.kernel.search.Summary;
import com.liferay.portal.kernel.util.GetterUtil;
import com.liferay.portal.security.permission.PermissionChecker;
import com.rivetlogic.event.model.Event;
import com.rivetlogic.event.service.EventLocalServiceUtil;
import com.rivetlogic.event.service.persistence.EventActionableDynamicQuery;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Locale;

import javax.portlet.PortletURL;

public class EventIndexer extends BaseIndexer {
	public static final String[] CLASS_NAMES = { Event.class.getName() };

    public static final String PORTLET_ID = "guestbook-portlet";

    public EventIndexer() {
    	setPermissionAware(true);
    }

    @Override
    public String[] getClassNames() {
    	return CLASS_NAMES;
    }

    @Override
    public String getPortletId() {
    	return PORTLET_ID;
    }

    @Override
    public boolean hasPermission(PermissionChecker permissionChecker, String entryClassName, long entryClassPK, String actionId)
                    throws Exception {
    	return true;/*GuestbookPermission.contains(permissionChecker, entryClassPK, ActionKeys.VIEW);*/
    }

    @Override
    protected void doDelete(Object obj) throws Exception {
		Event event = (Event) obj;
		deleteDocument(event.getCompanyId(), event.getEventId());
    }

    @Override
    protected Document doGetDocument(Object obj) throws Exception {

    	Event event = (Event)obj;
		
		Document document = getBaseModelDocument(PORTLET_ID, event);
		
		document.addText(Field.CONTENT, event.getDescription());
		document.addText(Field.TITLE, event.getName());
		document.addText("location", String.valueOf(event.getLocationId()));
		document.addText("type", String.valueOf(event.getTypeId()));
		document.addText("target", String.valueOf(event.getTargetId()));
		document.addKeyword(Field.GROUP_ID, getSiteGroupId(event.getGroupId()));
		document.addKeyword(Field.SCOPE_GROUP_ID, event.getGroupId());
		
		return document;
    }

    @Override
    protected Summary doGetSummary(Document document, Locale locale, String snippet, PortletURL portletURL) throws Exception {

	    Summary summary = createSummary(document);
	    summary.setMaxContentLength(200);
	    return summary;
    }

    @Override
    protected void doReindex(Object obj) throws Exception {

        Event event = (Event)obj;
        Document document = getDocument(event);
        SearchEngineUtil.updateDocument(getSearchEngineId(), event.getCompanyId(), document, true);
    }

    @Override
    protected void doReindex(String className, long classPK) throws Exception {

        Event entry = EventLocalServiceUtil.getEvent(classPK);
        doReindex(entry);
    }

    @Override
    protected void doReindex(String[] ids) throws Exception {
    	
        long companyId = GetterUtil.getLong(ids[0]);
        reindexEntries(companyId);
    }

    @Override
    protected String getPortletId(SearchContext searchContext) {

    	return PORTLET_ID;
    }

    protected void reindexEntries(long companyId) throws PortalException, SystemException {

	    final Collection<Document> documents = new ArrayList<Document>();

	    ActionableDynamicQuery actionableDynamicQuery = new EventActionableDynamicQuery() {
	
	        @Override
	        protected void addCriteria(DynamicQuery dynamicQuery) {
	        }
	
	        @Override
	        protected void performAction(Object object) throws PortalException {
	            Event event = (Event) object;
	            Document document = getDocument(event);
	            documents.add(document);
	        }
	    };
	
	    actionableDynamicQuery.setCompanyId(companyId);
	
	    actionableDynamicQuery.performActions();
	
	    SearchEngineUtil.updateDocuments(getSearchEngineId(), companyId, documents, true);
    }
}
