package com.bby.ants.util;


public enum SiteType {
		site,
		errSite,
		historySite;
		
		public static SiteType getKey(String key) {
			return valueOf(key);
		}
}
