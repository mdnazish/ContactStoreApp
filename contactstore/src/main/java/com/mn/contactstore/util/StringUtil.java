package com.mn.contactstore.util;

/*
 * This class contain utility methods related to String operations.
 * @author Md Nazish
 */

public class StringUtil {

	public static String commaSepratedString(Object[] items) {
		StringBuilder sb = new StringBuilder();
		// adding all the item
		for (Object item : items) {
			sb.append(item).append(",");
		}
		// Recommanded : here we have to delete last comma of the items to execute SQL
		// Query properly.
		if (sb.length() > 0) {
			sb.deleteCharAt(sb.length() - 1);
		}
		return sb.toString();
	}
}
