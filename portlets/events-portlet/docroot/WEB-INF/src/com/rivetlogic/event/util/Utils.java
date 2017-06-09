package com.rivetlogic.event.util;

import com.rivetlogic.event.model.Event;

public class Utils {
	public static String generateMailtoLink(Event event, String link) {
		String result = "mailto:person@domain.com?subject="+replaceSpace(event.getName())+"&amp;body="+link;

		return result;
	}
	
	public static String replaceSpace(String value) {
		return value.replace(" ", "%20");
	}
}
