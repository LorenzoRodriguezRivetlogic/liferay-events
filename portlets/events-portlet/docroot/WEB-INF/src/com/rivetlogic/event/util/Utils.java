package com.rivetlogic.event.util;

import com.rivetlogic.event.model.Event;

import java.util.StringTokenizer;

public class Utils {
	public static String generateMailtoLink(Event event, String link) {
		String result = "mailto:person@domain.com?subject="+replaceSpace(event.getName())+"&amp;body="+link;

		return result;
	}
	
	public static String replaceSpace(String value) {
		return value.replace(" ", "%20");
	}
	
	public static String addSpaceTags(String tags) {
		StringTokenizer st = new StringTokenizer(tags,",");  
		String result = "";
		while (st.hasMoreTokens()) {  
			result += st.nextToken();
			if(st.hasMoreTokens()){
				result += ", ";
			}
		} 
		
		return result;
	}
	
	public static String formatUrlForShare(String url) {
		url = url.replace(":", "%3A");
		url = url.replace("/", "%2F");
		url = url.replace("-", "%2D");
		url = url.replace("_", "%5F");
		
		return url;
	}
}
