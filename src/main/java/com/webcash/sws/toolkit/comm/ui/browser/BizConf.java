package com.webcash.sws.toolkit.comm.ui.browser;


public class BizConf {
	public static final String PAGE_CNT			= "20";				// ÃƒÂ«Ã‚Â©Ã¢â‚¬ï¿½ÃƒÂ«Ã‚ÂªÃ‚Â¨ÃƒÂ«Ã‚Â¦Ã‚Â¬ÃƒÂ¬Ã…Â Ã‚Â¤ÃƒÂ­Ã…Â Ã‚Â¸ ÃƒÂ­Ã…Â½Ã‹Å“ÃƒÂ¬Ã¯Â¿Â½Ã‚Â´ÃƒÂ¬Ã‚Â§Ã¢â€šÂ¬ ÃƒÂ¬Ã‚Â¹Ã‚Â´ÃƒÂ¬Ã…Â¡Ã‚Â´ÃƒÂ­Ã…Â Ã‚Â¸
	public static final int GRID_ITEM_CNT_PER_PAGE	= 9;		// ÃƒÂ«Ã‚Â©Ã¢â‚¬ï¿½ÃƒÂ¬Ã¯Â¿Â½Ã‚Â¸ ÃƒÂªÃ‚Â·Ã‚Â¸ÃƒÂ«Ã‚Â¦Ã‚Â¬ÃƒÂ«Ã¢â‚¬Å“Ã…â€œ ÃƒÂ­Ã…Â½Ã‹Å“ÃƒÂ¬Ã¯Â¿Â½Ã‚Â´ÃƒÂ¬Ã‚Â§Ã¢â€šÂ¬ÃƒÂ«Ã¢â‚¬Â¹Ã‚Â¹ ÃƒÂ«Ã‚Â©Ã¢â‚¬ï¿½ÃƒÂ«Ã¢â‚¬Â°Ã‚Â´ ÃƒÂªÃ‚Â°Ã‚Â¯ÃƒÂ¬Ã‹â€ Ã‹Å“
	
//	public static final String MASTER_ID		= "A_C_G_1";
	public static final String MASTER_ID		= "A_B_G_1";
	public static final String MENU_ID			= "AWG_GATE1";
	public static final String NEW_LINE 		= "\r\n";
	public static final String DATE_DELIMITER 	= "-";
	public static final String MEMO_VERSION_OLD = "O";
	public static final String MEMO_VERSION_NEW = "N";
	public static final String DB_NAME 			= "admin.db";
	public static final String KEY_TRAN_REQ_DOMN = "BIZWARE";
	public static final Long MAX_AMOUNT 		= 999999999999L;
	public static final String MAIL_DOMAIN 		= "@webcash.co.kr";
	public static final String RESOURCE_TYPE_DRAWABLE = "drawable";
	public static final String RESOURCE_TYPE_ID = "id";
	public static final String LOCALE_KO  = "DF";
	public static final String LOCALE_ENG = "EN";
	public static final String AUTH_APP = "Y";
	public static final String WAIT_APP = "N";
	public static final String ALL_APP = "";
	public static final String MEMO_NEW_MENU_URL = "com.webcash.wesmart.ui.memo.Memo_0101";
	public static final String MEMO_OLD_MENU_URL = "com.webcash.wesmart.ui.wrk.Wrk_0101";
	public static final String PACKAGE_NAME		= "com.kosign.woori_1";

	public static final String PUSH_YN = "PUSH_YN";
	public static final String MAIL_PUSH = "MAIL_PUSH";
	public static final String APP_PUSH = "APP_PUSH";
	public static final String WRK_PUSH = "WRK_PUSH";
	public static final String SAVE_VER = "SAVE_VER";
	
	
	public static long AUTO_LOGOUT_TIME = 24 * 60 * 60 * 1000;		// ÃƒÂ¬Ã…Â¾Ã¯Â¿Â½ÃƒÂ«Ã¯Â¿Â½Ã¢â€žÂ¢ÃƒÂ«Ã‚Â¡Ã…â€œÃƒÂªÃ‚Â·Ã‚Â¸ÃƒÂ¬Ã¢â‚¬Â¢Ã¢â‚¬Å¾ÃƒÂ¬Ã¢â‚¬ÂºÃ†â€™ ÃƒÂ¬Ã¢â‚¬Â¹Ã…â€œÃƒÂªÃ‚Â°Ã¢â‚¬Å¾
	public static long LAST_TRAN_TIME	= AUTO_LOGOUT_TIME;	// ÃƒÂ«Ã‚Â§Ã‹â€ ÃƒÂ¬Ã‚Â§Ã¢â€šÂ¬ÃƒÂ«Ã‚Â§Ã¢â‚¬Â° ÃƒÂªÃ‚Â±Ã‚Â°ÃƒÂ«Ã…Â¾Ã‹Å“ÃƒÂ­Ã¢â‚¬ÂºÃ¢â‚¬Å¾ ÃƒÂªÃ‚Â²Ã‚Â½ÃƒÂªÃ‚Â³Ã‚Â¼ÃƒÂ¬Ã¢â‚¬Â¹Ã…â€œÃƒÂªÃ‚Â°Ã¢â‚¬Å¾
	public static String WON	        = " ÃƒÂ¬Ã¢â‚¬ÂºÃ¯Â¿Â½";	            // (ÃƒÂ¬Ã¢â€žÂ¢Ã‚Â¸ÃƒÂ­Ã¢â€žÂ¢Ã‹Å“ ÃƒÂ¬Ã‚Â Ã…â€œÃƒÂ¬Ã¢â€žÂ¢Ã‚Â¸) ÃƒÂªÃ‚Â¸Ã‹â€ ÃƒÂ¬Ã¢â‚¬Â¢Ã‚Â¡ ÃƒÂ«Ã¢â‚¬â„¢Ã‚Â¤ÃƒÂ¬Ã¢â‚¬â€�Ã¯Â¿Â½ ÃƒÂ¬Ã¢â‚¬Å¡Ã‚Â¬ÃƒÂ¬Ã…Â¡Ã‚Â©
	public static String PERCENT	    = " %";	            // ÃƒÂ¬Ã…â€œÃ‚Â¨ ÃƒÂ«Ã¢â‚¬â„¢Ã‚Â¤ÃƒÂ¬Ã¢â‚¬â€�Ã¯Â¿Â½ ÃƒÂ¬Ã¢â‚¬Å¡Ã‚Â¬ÃƒÂ¬Ã…Â¡Ã‚Â©
	
	public static int LAST_MAIN_MENU = -1;					// ÃƒÂ«Ã‚Â©Ã¢â‚¬ï¿½ÃƒÂ¬Ã¯Â¿Â½Ã‚Â¸ÃƒÂ«Ã‚Â©Ã¢â‚¬ï¿½ÃƒÂ«Ã¢â‚¬Â°Ã‚Â´ÃƒÂ¬Ã¢â‚¬â€�Ã¯Â¿Â½ÃƒÂ¬Ã¢â‚¬Å¾Ã…â€œ ÃƒÂ¬Ã¢â‚¬â€�Ã¢â‚¬Â¦ÃƒÂ«Ã‚Â¬Ã‚Â´ ÃƒÂ­Ã¢â€žÂ¢Ã¢â‚¬ï¿½ÃƒÂ«Ã‚Â©Ã‚Â´ÃƒÂ¬Ã…â€œÃ‚Â¼ÃƒÂ«Ã‚Â¡Ã…â€œ ÃƒÂ¬Ã‚Â§Ã¯Â¿Â½ÃƒÂ¬Ã‚Â Ã¢â‚¬Ëœ ÃƒÂ«Ã¢â‚¬Å“Ã‚Â¤ÃƒÂ¬Ã¢â‚¬â€œÃ‚Â´ÃƒÂªÃ‚Â°Ã¢â‚¬Å¾ ÃƒÂªÃ‚Â²Ã‚Â½ÃƒÂ¬Ã…Â¡Ã‚Â° ÃƒÂ¬Ã¢â‚¬Å¾Ã‚Â¸ÃƒÂ¬Ã¢â‚¬Â¦Ã‹Å“(mLastSubMenuPos)ÃƒÂ¬Ã¢â‚¬â€�Ã¯Â¿Â½ ÃƒÂ¬Ã‚Â Ã¢â€šÂ¬ÃƒÂ¬Ã…Â¾Ã‚Â¥ÃƒÂ­Ã¢â‚¬Â¢Ã‹Å“ÃƒÂ«Ã…Â Ã¢â‚¬ï¿½ ÃƒÂªÃ‚Â°Ã¢â‚¬â„¢
		
	public static String USEFAC_SEQ_NO = "10";
	
	public static String USEFAC_NO = "";
	
	public static String SPLITTER = ":";
	
	public static int LIST_LINE_NUMBER = 20;
	
	public static int LIST_MEMBER_NUMBER = 5;
	
	public static int LIST_BBS_LINE_NUMBER = 15;
	
	// ÃƒÂ¬Ã‚Â£Ã‚Â¼ÃƒÂ¬Ã¢â‚¬Â Ã…â€™ÃƒÂ«Ã‚Â¡Ã¯Â¿Â½ ÃƒÂªÃ‚Â²Ã¢â€šÂ¬ÃƒÂ¬Ã†â€™Ã¢â‚¬Â° ÃƒÂ­Ã¢â‚¬Å¡Ã‚Â¤ÃƒÂ¬Ã¢â‚¬ÂºÃ…â€™ÃƒÂ«Ã¢â‚¬Å“Ã…â€œ ÃƒÂªÃ‚ÂµÃ‚Â¬ÃƒÂ«Ã‚Â¶Ã¢â‚¬Å¾
	public static final String SEARCH_GB1_NAME = "1";
	public static final String SEARCH_GB1_CORP = "2";
	public static final String SEARCH_GB1_GROUP = "3";
	
	// ÃƒÂ¬Ã¯Â¿Â½Ã‚Â¼ÃƒÂ¬Ã‚Â Ã¢â‚¬Â¢ ÃƒÂ«Ã‚Â°Ã‹Å“ÃƒÂ«Ã‚Â³Ã‚ÂµÃƒÂ¬Ã‚Â£Ã‚Â¼ÃƒÂªÃ‚Â¸Ã‚Â° ÃƒÂªÃ‚ÂµÃ‚Â¬ÃƒÂ«Ã‚Â¶Ã¢â‚¬Å¾
	public static final String REPEAR_KIND_WEEK = "3";		// ÃƒÂ¬Ã‚Â£Ã‚Â¼ÃƒÂ«Ã¢â‚¬Â¹Ã‚Â¨ÃƒÂ¬Ã…â€œÃ¢â‚¬Å¾
	public static final String REPEAR_KIND_MONTH = "4";		// ÃƒÂ¬Ã¢â‚¬ÂºÃ¢â‚¬ï¿½ÃƒÂ«Ã¢â‚¬Â¹Ã‚Â¨ÃƒÂ¬Ã…â€œÃ¢â‚¬Å¾
	
	// ÃƒÂ«Ã‚Â©Ã¢â‚¬ï¿½ÃƒÂ«Ã¢â‚¬Â°Ã‚Â´ÃƒÂ¬Ã¢â‚¬Â¢Ã¢â‚¬Å¾ÃƒÂ¬Ã¯Â¿Â½Ã‚Â´ÃƒÂ«Ã¢â‚¬ï¿½Ã¢â‚¬ï¿½
	public static final String MENU_ID_MAIL = "AWG_MENU2";	// ÃƒÂ«Ã‚Â©Ã¢â‚¬ï¿½ÃƒÂ¬Ã¯Â¿Â½Ã‚Â¼ÃƒÂ­Ã¢â‚¬Â¢Ã‚Â¨ ÃƒÂ«Ã‚Â©Ã¢â‚¬ï¿½ÃƒÂ«Ã¢â‚¬Â°Ã‚Â´ÃƒÂ¬Ã¢â‚¬Â¢Ã¢â‚¬Å¾ÃƒÂ¬Ã¯Â¿Â½Ã‚Â´ÃƒÂ«Ã¢â‚¬ï¿½Ã¢â‚¬ï¿½
	public static final String MENU_ID_SAN 	= "AWG_MENU3";	// ÃƒÂªÃ‚Â²Ã‚Â°ÃƒÂ¬Ã…Â¾Ã‚Â¬ÃƒÂ­Ã¢â‚¬Â¢Ã‚Â¨ ÃƒÂ«Ã‚Â©Ã¢â‚¬ï¿½ÃƒÂ«Ã¢â‚¬Â°Ã‚Â´ÃƒÂ¬Ã¢â‚¬Â¢Ã¢â‚¬Å¾ÃƒÂ¬Ã¯Â¿Â½Ã‚Â´ÃƒÂ«Ã¢â‚¬ï¿½Ã¢â‚¬ï¿½
	public static final String MENU_ID_PRS 	= "AWG_MENU4";	// ÃƒÂ¬Ã¯Â¿Â½Ã‚Â¼ÃƒÂ¬Ã‚Â Ã¢â‚¬Â¢ÃƒÂªÃ‚Â´Ã¢â€šÂ¬ÃƒÂ«Ã‚Â¦Ã‚Â¬ ÃƒÂ«Ã‚Â©Ã¢â‚¬ï¿½ÃƒÂ«Ã¢â‚¬Â°Ã‚Â´ÃƒÂ¬Ã¢â‚¬Â¢Ã¢â‚¬Å¾ÃƒÂ¬Ã¯Â¿Â½Ã‚Â´ÃƒÂ«Ã¢â‚¬ï¿½Ã¢â‚¬ï¿½
	
	public static final String MENU_ID_WEBMAIL = "AWG_MENU9";	// ÃƒÂ¬Ã¢â‚¬ÂºÃ‚Â¹ÃƒÂ«Ã‚Â©Ã¢â‚¬ï¿½ÃƒÂ¬Ã¯Â¿Â½Ã‚Â¼ ÃƒÂ«Ã‚Â©Ã¢â‚¬ï¿½ÃƒÂ«Ã¢â‚¬Â°Ã‚Â´ÃƒÂ¬Ã¢â‚¬Â¢Ã¢â‚¬Å¾ÃƒÂ¬Ã¯Â¿Â½Ã‚Â´ÃƒÂ«Ã¢â‚¬ï¿½Ã¢â‚¬ï¿½
	
	// ÃƒÂªÃ‚Â²Ã‚Â°ÃƒÂ¬Ã…Â¾Ã‚Â¬ÃƒÂ«Ã‚Â©Ã¢â‚¬ï¿½ÃƒÂ¬Ã¯Â¿Â½Ã‚Â¸ÃƒÂ«Ã‚Â©Ã¢â‚¬ï¿½ÃƒÂ«Ã¢â‚¬Â°Ã‚Â´
	public static String PERSONAL_APPROVAL	= "ÃƒÂªÃ‚Â°Ã…â€œÃƒÂ¬Ã¯Â¿Â½Ã‚Â¸ÃƒÂªÃ‚Â²Ã‚Â°ÃƒÂ¬Ã…Â¾Ã‚Â¬ÃƒÂ­Ã¢â‚¬Â¢Ã‚Â¨";	// ÃƒÂªÃ‚Â°Ã…â€œÃƒÂ¬Ã¯Â¿Â½Ã‚Â¸ÃƒÂªÃ‚Â²Ã‚Â°ÃƒÂ¬Ã…Â¾Ã‚Â¬ÃƒÂ­Ã¢â‚¬Â¢Ã‚Â¨
	public static String DEPT_APPROVAL		= "ÃƒÂ«Ã‚Â¶Ã¢â€šÂ¬ÃƒÂ¬Ã¢â‚¬Å¾Ã…â€œÃƒÂªÃ‚Â²Ã‚Â°ÃƒÂ¬Ã…Â¾Ã‚Â¬ÃƒÂ­Ã¢â‚¬Â¢Ã‚Â¨";	// ÃƒÂ«Ã‚Â¶Ã¢â€šÂ¬ÃƒÂ¬Ã¢â‚¬Å¾Ã…â€œÃƒÂªÃ‚Â²Ã‚Â°ÃƒÂ¬Ã…Â¾Ã‚Â¬ÃƒÂ­Ã¢â‚¬Â¢Ã‚Â¨
	public static String RECEIPT_APPROVAL	= "ÃƒÂ¬Ã‚Â Ã¢â‚¬ËœÃƒÂ¬Ã‹â€ Ã‹Å“ÃƒÂªÃ‚Â²Ã‚Â°ÃƒÂ¬Ã…Â¾Ã‚Â¬ÃƒÂ­Ã¢â‚¬Â¢Ã‚Â¨";	// ÃƒÂ¬Ã‚Â Ã¢â‚¬ËœÃƒÂ¬Ã‹â€ Ã‹Å“ÃƒÂªÃ‚Â²Ã‚Â°ÃƒÂ¬Ã…Â¾Ã‚Â¬ÃƒÂ­Ã¢â‚¬Â¢Ã‚Â¨
	public static String MY_APPROVAL		= "MyÃƒÂªÃ‚Â¸Ã‚Â°ÃƒÂ¬Ã¢â‚¬Â¢Ã‹â€ ÃƒÂ«Ã‚Â¬Ã‚Â¸ÃƒÂ¬Ã¢â‚¬Å¾Ã…â€œ";	// MyÃƒÂªÃ‚Â¸Ã‚Â°ÃƒÂ¬Ã¢â‚¬Â¢Ã‹â€ ÃƒÂ«Ã‚Â¬Ã‚Â¸ÃƒÂ¬Ã¢â‚¬Å¾Ã…â€œ
	
	// ÃƒÂªÃ‚Â²Ã‚Â°ÃƒÂ¬Ã…Â¾Ã‚Â¬ÃƒÂ«Ã‚Â¬Ã‚Â¸ÃƒÂ¬Ã¢â‚¬Å¾Ã…â€œÃƒÂ¬Ã¢â‚¬Â¹Ã‚Â¤ÃƒÂ­Ã¢â‚¬â€œÃ¢â‚¬Â°
	public static String STANDBY_PAPER	= "ÃƒÂªÃ‚Â²Ã‚Â°ÃƒÂ¬Ã…Â¾Ã‚Â¬ÃƒÂ«Ã…â€™Ã¢â€šÂ¬ÃƒÂªÃ‚Â¸Ã‚Â°ÃƒÂ­Ã¢â‚¬Â¢Ã‚Â¨";	// ÃƒÂªÃ‚Â²Ã‚Â°ÃƒÂ¬Ã…Â¾Ã‚Â¬ÃƒÂ«Ã…â€™Ã¢â€šÂ¬ÃƒÂªÃ‚Â¸Ã‚Â°ÃƒÂ­Ã¢â‚¬Â¢Ã‚Â¨	
	public static String POSTPONE_PAPER	= "ÃƒÂªÃ‚Â²Ã‚Â°ÃƒÂ¬Ã…Â¾Ã‚Â¬ÃƒÂ«Ã‚Â³Ã‚Â´ÃƒÂ«Ã‚Â¥Ã‹Å“ÃƒÂ­Ã¢â‚¬Â¢Ã‚Â¨";	// ÃƒÂªÃ‚Â²Ã‚Â°ÃƒÂ¬Ã…Â¾Ã‚Â¬ÃƒÂ«Ã‚Â³Ã‚Â´ÃƒÂ«Ã‚Â¥Ã‹Å“ÃƒÂ­Ã¢â‚¬Â¢Ã‚Â¨		
	public static String APPROVAL_PAPER	= "ÃƒÂªÃ‚Â²Ã‚Â°ÃƒÂ¬Ã…Â¾Ã‚Â¬ÃƒÂ¬Ã¢â€žÂ¢Ã¢â‚¬Å¾ÃƒÂ«Ã‚Â£Ã…â€™ÃƒÂ­Ã¢â‚¬Â¢Ã‚Â¨";	// ÃƒÂªÃ‚Â²Ã‚Â°ÃƒÂ¬Ã…Â¾Ã‚Â¬ÃƒÂ¬Ã¢â€žÂ¢Ã¢â‚¬Å¾ÃƒÂ«Ã‚Â£Ã…â€™ÃƒÂ­Ã¢â‚¬Â¢Ã‚Â¨
	
	// ÃƒÂ«Ã‚Â¶Ã¢â€šÂ¬ÃƒÂ¬Ã¢â‚¬Å¾Ã…â€œÃƒÂªÃ‚Â²Ã‚Â°ÃƒÂ¬Ã…Â¾Ã‚Â¬ÃƒÂ«Ã‚Â¬Ã‚Â¸ÃƒÂ¬Ã¢â‚¬Å¾Ã…â€œÃƒÂ¬Ã¢â‚¬Â¹Ã‚Â¤ÃƒÂ­Ã¢â‚¬â€œÃ¢â‚¬Â°
	public static String DEPT_STANDBY_PAPER		= "ÃƒÂ«Ã‚Â¶Ã¢â€šÂ¬ÃƒÂ¬Ã¢â‚¬Å¾Ã…â€œÃƒÂ«Ã…â€™Ã¢â€šÂ¬ÃƒÂªÃ‚Â¸Ã‚Â°ÃƒÂ­Ã¢â‚¬Â¢Ã‚Â¨";	// ÃƒÂ«Ã‚Â¶Ã¢â€šÂ¬ÃƒÂ¬Ã¢â‚¬Å¾Ã…â€œÃƒÂ«Ã…â€™Ã¢â€šÂ¬ÃƒÂªÃ‚Â¸Ã‚Â°ÃƒÂ­Ã¢â‚¬Â¢Ã‚Â¨	
	public static String DEPT_POSTPONE_PAPER	= "ÃƒÂ«Ã‚Â¶Ã¢â€šÂ¬ÃƒÂ¬Ã¢â‚¬Å¾Ã…â€œÃƒÂ«Ã‚Â³Ã‚Â´ÃƒÂ«Ã‚Â¥Ã‹Å“ÃƒÂ­Ã¢â‚¬Â¢Ã‚Â¨";	// ÃƒÂ«Ã‚Â¶Ã¢â€šÂ¬ÃƒÂ¬Ã¢â‚¬Å¾Ã…â€œÃƒÂ«Ã‚Â³Ã‚Â´ÃƒÂ«Ã‚Â¥Ã‹Å“ÃƒÂ­Ã¢â‚¬Â¢Ã‚Â¨		
	public static String DEPT_APPROVAL_PAPER	= "ÃƒÂ«Ã‚Â¶Ã¢â€šÂ¬ÃƒÂ¬Ã¢â‚¬Å¾Ã…â€œÃƒÂ¬Ã¢â€žÂ¢Ã¢â‚¬Å¾ÃƒÂ«Ã‚Â£Ã…â€™ÃƒÂ­Ã¢â‚¬Â¢Ã‚Â¨";	// ÃƒÂ«Ã‚Â¶Ã¢â€šÂ¬ÃƒÂ¬Ã¢â‚¬Å¾Ã…â€œÃƒÂ¬Ã¢â€žÂ¢Ã¢â‚¬Å¾ÃƒÂ«Ã‚Â£Ã…â€™ÃƒÂ­Ã¢â‚¬Â¢Ã‚Â¨
	
	// ÃƒÂ¬Ã‚Â Ã¢â‚¬ËœÃƒÂ¬Ã‹â€ Ã‹Å“ÃƒÂªÃ‚Â²Ã‚Â°ÃƒÂ¬Ã…Â¾Ã‚Â¬ÃƒÂ«Ã‚Â¬Ã‚Â¸ÃƒÂ¬Ã¢â‚¬Å¾Ã…â€œÃƒÂ¬Ã¢â‚¬Â¹Ã‚Â¤ÃƒÂ­Ã¢â‚¬â€œÃ¢â‚¬Â°
	public static String RECEIPT_STANDBY_PAPER	= "ÃƒÂ¬Ã‚Â Ã¢â‚¬ËœÃƒÂ¬Ã‹â€ Ã‹Å“ÃƒÂ«Ã…â€™Ã¢â€šÂ¬ÃƒÂªÃ‚Â¸Ã‚Â°ÃƒÂ­Ã¢â‚¬Â¢Ã‚Â¨";	// ÃƒÂ¬Ã‚Â Ã¢â‚¬ËœÃƒÂ¬Ã‹â€ Ã‹Å“ÃƒÂ«Ã…â€™Ã¢â€šÂ¬ÃƒÂªÃ‚Â¸Ã‚Â°ÃƒÂ­Ã¢â‚¬Â¢Ã‚Â¨	
	public static String RECEIPT_POSTPONE_PAPER	= "ÃƒÂ¬Ã‚Â Ã¢â‚¬ËœÃƒÂ¬Ã‹â€ Ã‹Å“ÃƒÂ«Ã‚Â³Ã‚Â´ÃƒÂ«Ã‚Â¥Ã‹Å“ÃƒÂ­Ã¢â‚¬Â¢Ã‚Â¨";	// ÃƒÂ¬Ã‚Â Ã¢â‚¬ËœÃƒÂ¬Ã‹â€ Ã‹Å“ÃƒÂ«Ã‚Â³Ã‚Â´ÃƒÂ«Ã‚Â¥Ã‹Å“ÃƒÂ­Ã¢â‚¬Â¢Ã‚Â¨		
	public static String RECEIPT_APPROVAL_PAPER	= "ÃƒÂ¬Ã‚Â Ã¢â‚¬ËœÃƒÂ¬Ã‹â€ Ã‹Å“ÃƒÂ¬Ã¢â€žÂ¢Ã¢â‚¬Å¾ÃƒÂ«Ã‚Â£Ã…â€™ÃƒÂ­Ã¢â‚¬Â¢Ã‚Â¨";	// ÃƒÂ¬Ã‚Â Ã¢â‚¬ËœÃƒÂ¬Ã‹â€ Ã‹Å“ÃƒÂ¬Ã¢â€žÂ¢Ã¢â‚¬Å¾ÃƒÂ«Ã‚Â£Ã…â€™ÃƒÂ­Ã¢â‚¬Â¢Ã‚Â¨
	
	// ÃƒÂªÃ‚Â²Ã‚Â°ÃƒÂ¬Ã…Â¾Ã‚Â¬ÃƒÂ«Ã‚Â¬Ã‚Â¸ÃƒÂ¬Ã¢â‚¬Å¾Ã…â€œÃƒÂªÃ‚Â²Ã‚Â°ÃƒÂ¬Ã…Â¾Ã‚Â¬
	public static String SIGN_OPINION_APPROVAL	= "1";		// ÃƒÂ¬Ã…Â Ã‚Â¹ÃƒÂ¬Ã¯Â¿Â½Ã‚Â¸
	public static String SIGN_OPINION_RETURN	= "2";		// ÃƒÂ«Ã‚Â°Ã‹Å“ÃƒÂ¬Ã¢â‚¬Â Ã‚Â¡
	
	// ACTIVITY REQUEST CODE
	public class ReqCd{
		
		public static final int BIZCONFIRM	= 				0001;			// ÃƒÂ¬Ã¯Â¿Â½Ã‚Â´ÃƒÂ¬Ã…Â¡Ã‚Â©ÃƒÂªÃ‚Â¸Ã‚Â°ÃƒÂªÃ‚Â´Ã¢â€šÂ¬ÃƒÂ¬Ã‚Â Ã¢â‚¬Â¢ÃƒÂ«Ã‚Â³Ã‚Â´
		
		public static final int CALENDAR	= 				1000;			// ÃƒÂ«Ã¢â‚¬Â¹Ã‚Â¬ÃƒÂ«Ã‚Â Ã‚Â¥
		public static final int CALENDAR_FROMDATE = 		1001;			// ÃƒÂ«Ã¢â‚¬Â¹Ã‚Â¬ÃƒÂ«Ã‚Â Ã‚Â¥ (ÃƒÂªÃ‚Â¸Ã‚Â°ÃƒÂªÃ‚Â°Ã¢â‚¬Å¾ÃƒÂ¬Ã¯Â¿Â½Ã¢â‚¬Å¾ ÃƒÂ¬Ã¢â‚¬Å¾Ã‚Â ÃƒÂ­Ã†â€™Ã¯Â¿Â½ÃƒÂ­Ã¢â‚¬Â¢Ã‹Å“ÃƒÂ«Ã…Â Ã¢â‚¬ï¿½ ÃƒÂªÃ‚Â²Ã‚Â½ÃƒÂ¬Ã…Â¡Ã‚Â° ÃƒÂ¬Ã¢â‚¬Â¹Ã…â€œÃƒÂ¬Ã…Â¾Ã¢â‚¬ËœÃƒÂ¬Ã¯Â¿Â½Ã‚Â¼)
		public static final int CALENDAR_TODATE = 			1002;			// ÃƒÂ«Ã¢â‚¬Â¹Ã‚Â¬ÃƒÂ«Ã‚Â Ã‚Â¥ (ÃƒÂªÃ‚Â¸Ã‚Â°ÃƒÂªÃ‚Â°Ã¢â‚¬Å¾ÃƒÂ¬Ã¯Â¿Â½Ã¢â‚¬Å¾ ÃƒÂ¬Ã¢â‚¬Å¾Ã‚Â ÃƒÂ­Ã†â€™Ã¯Â¿Â½ÃƒÂ­Ã¢â‚¬Â¢Ã‹Å“ÃƒÂ«Ã…Â Ã¢â‚¬ï¿½ ÃƒÂªÃ‚Â²Ã‚Â½ÃƒÂ¬Ã…Â¡Ã‚Â° ÃƒÂ¬Ã‚Â¢Ã¢â‚¬Â¦ÃƒÂ«Ã‚Â£Ã…â€™ÃƒÂ¬Ã¯Â¿Â½Ã‚Â¼)
		public static final int TIME	= 					1004;			// ÃƒÂ«Ã¢â‚¬Â¹Ã‚Â¬ÃƒÂ«Ã‚Â Ã‚Â¥
		
		public static final int REQCD_WORK_GUBUN =		 		1003;			// ÃƒÂ­Ã¢â‚¬Â¢Ã‚Â ÃƒÂ¬Ã¯Â¿Â½Ã‚Â¼(ÃƒÂ¬Ã¢â‚¬â€�Ã¢â‚¬Â¦ÃƒÂ«Ã‚Â¬Ã‚Â´ÃƒÂ¬Ã‚Â¢Ã¢â‚¬Â¦ÃƒÂ«Ã‚Â¥Ã‹Å“ ÃƒÂ¬Ã¢â‚¬Å¾Ã‚Â ÃƒÂ­Ã†â€™Ã¯Â¿Â½)
		
		public static final int PRS_0301 = 1301;	// ÃƒÂ¬Ã¯Â¿Â½Ã‚Â¼ÃƒÂ¬Ã‚Â Ã¢â‚¬Â¢ - ÃƒÂ¬Ã¯Â¿Â½Ã‚Â¼ÃƒÂªÃ‚Â°Ã¢â‚¬Å¾ ÃƒÂ¬Ã¯Â¿Â½Ã‚Â¼ÃƒÂ¬Ã‚Â Ã¢â‚¬Â¢ÃƒÂ­Ã¢â€žÂ¢Ã¢â‚¬Â¢ÃƒÂ¬Ã¯Â¿Â½Ã‚Â¸
		
		public static final int PRS_0501 = 2000;	// ÃƒÂ¬Ã¯Â¿Â½Ã‚Â¼ÃƒÂ¬Ã‚Â Ã¢â‚¬Â¢ - ÃƒÂ¬Ã†â€™Ã¯Â¿Â½ÃƒÂ¬Ã¢â‚¬Å¾Ã‚Â¸
		public static final int PRS_0502 = 2001;	// ÃƒÂ¬Ã¯Â¿Â½Ã‚Â¼ÃƒÂ¬Ã‚Â Ã¢â‚¬Â¢ - ÃƒÂ«Ã¢â‚¬Å“Ã‚Â±ÃƒÂ«Ã‚Â¡Ã¯Â¿Â½
		public static final int PRS_0503 = 2002;	// ÃƒÂ¬Ã¯Â¿Â½Ã‚Â¼ÃƒÂ¬Ã‚Â Ã¢â‚¬Â¢ - ÃƒÂ«Ã‚Â¶Ã¢â‚¬Å¾ÃƒÂ«Ã‚Â¥Ã‹Å“ÃƒÂ¬Ã¢â‚¬Å¾Ã‚Â ÃƒÂ­Ã†â€™Ã¯Â¿Â½
		public static final int PRS_0504 = 2003;	// ÃƒÂ¬Ã¯Â¿Â½Ã‚Â¼ÃƒÂ¬Ã‚Â Ã¢â‚¬Â¢ - ÃƒÂªÃ‚Â³Ã‚ÂµÃƒÂ¬Ã…â€œÃ‚Â ÃƒÂ¬Ã…Â¾Ã¯Â¿Â½ÃƒÂ¬Ã‹â€ Ã‹Å“ÃƒÂ¬Ã‚Â Ã¢â‚¬Â¢
		public static final int PRS_0601 = 2004;	// ÃƒÂ¬Ã¯Â¿Â½Ã‚Â¼ÃƒÂ¬Ã‚Â Ã¢â‚¬Â¢ - ÃƒÂ¬Ã¯Â¿Â½Ã‚Â¼ÃƒÂ¬Ã‚Â Ã¢â‚¬Â¢ÃƒÂ­Ã¢â€žÂ¢Ã¢â‚¬Â¢ÃƒÂ¬Ã¯Â¿Â½Ã‚Â¸ÃƒÂ¬Ã…Â¡Ã¢â‚¬ï¿½ÃƒÂ¬Ã‚Â²Ã‚Â­ ÃƒÂ«Ã‚Â¦Ã‚Â¬ÃƒÂ¬Ã…Â Ã‚Â¤ÃƒÂ­Ã…Â Ã‚Â¸
		public static final int PRS_0402 = 2005;	// ÃƒÂ¬Ã¯Â¿Â½Ã‚Â¼ÃƒÂ¬Ã‚Â Ã¢â‚¬Â¢ - ÃƒÂªÃ‚Â²Ã¢â€šÂ¬ÃƒÂ¬Ã†â€™Ã¢â‚¬Â°ÃƒÂªÃ‚Â¸Ã‚Â°ÃƒÂªÃ‚Â°Ã¢â‚¬Å¾ÃƒÂ¬Ã¢â‚¬Å¾Ã‚Â¤ÃƒÂ¬Ã‚Â Ã¢â‚¬Â¢
		
		public static final int ADD_0201 = 3201;	// ÃƒÂ¬Ã‚Â£Ã‚Â¼ÃƒÂ¬Ã¢â‚¬Â Ã…â€™ÃƒÂ«Ã‚Â¡Ã¯Â¿Â½ - ÃƒÂªÃ‚Â·Ã‚Â¸ÃƒÂ«Ã‚Â£Ã‚Â¹ ÃƒÂ¬Ã†â€™Ã¯Â¿Â½ÃƒÂ¬Ã¢â‚¬Å¾Ã‚Â¸
		public static final int ADD_0401 = 3401;	// ÃƒÂ¬Ã‚Â£Ã‚Â¼ÃƒÂ¬Ã¢â‚¬Â Ã…â€™ÃƒÂ«Ã‚Â¡Ã¯Â¿Â½ - ÃƒÂ¬Ã†â€™Ã¯Â¿Â½ÃƒÂ¬Ã¢â‚¬Å¾Ã‚Â¸
		public static final int ADD_0402 = 3402;	// ÃƒÂ¬Ã‚Â£Ã‚Â¼ÃƒÂ¬Ã¢â‚¬Â Ã…â€™ÃƒÂ«Ã‚Â¡Ã¯Â¿Â½ - ÃƒÂ¬Ã‚Â£Ã‚Â¼ÃƒÂ¬Ã¢â‚¬Â Ã…â€™ÃƒÂ«Ã‚Â¡Ã¯Â¿Â½ ÃƒÂ«Ã¢â‚¬Å“Ã‚Â±ÃƒÂ«Ã‚Â¡Ã¯Â¿Â½
		public static final int ADD_0403 = 3403;	// ÃƒÂ¬Ã‚Â£Ã‚Â¼ÃƒÂ¬Ã¢â‚¬Â Ã…â€™ÃƒÂ«Ã‚Â¡Ã¯Â¿Â½ ÃƒÂªÃ‚Â·Ã‚Â¸ÃƒÂ«Ã‚Â£Ã‚Â¹ ÃƒÂ¬Ã¢â‚¬Å¾Ã‚Â ÃƒÂ­Ã†â€™Ã¯Â¿Â½
		public static final int ADD_0404 = 3404;	// ÃƒÂ¬Ã‚Â£Ã‚Â¼ÃƒÂ¬Ã¢â‚¬Â Ã…â€™ÃƒÂ«Ã‚Â¡Ã¯Â¿Â½ ÃƒÂ«Ã‚Â¶Ã¢â‚¬Å¾ÃƒÂ«Ã‚Â¥Ã‹Å“ ÃƒÂ¬Ã¢â‚¬Å¾Ã‚Â ÃƒÂ­Ã†â€™Ã¯Â¿Â½
		public static final int ADD_0405 = 3405;	// ÃƒÂ¬Ã‚Â£Ã‚Â¼ÃƒÂ¬Ã¢â‚¬Â Ã…â€™ÃƒÂ«Ã‚Â¡Ã¯Â¿Â½ - ÃƒÂ¬Ã‚Â Ã¢â‚¬Å¾ÃƒÂ­Ã¢â€žÂ¢Ã¢â‚¬ï¿½ÃƒÂ«Ã‚Â²Ã‹â€ ÃƒÂ­Ã‹Å“Ã‚Â¸ ÃƒÂ¬Ã‚Â¶Ã¢â‚¬ï¿½ÃƒÂªÃ‚Â°Ã¢â€šÂ¬
		
		public static final int STF_0101 = 4000;	// ÃƒÂ¬Ã‚Â§Ã¯Â¿Â½ÃƒÂ¬Ã¢â‚¬ÂºÃ¯Â¿Â½ÃƒÂªÃ‚Â²Ã¢â€šÂ¬ÃƒÂ¬Ã†â€™Ã¢â‚¬Â° - ÃƒÂ¬Ã‚Â Ã¢â‚¬Å¾ÃƒÂ¬Ã‚Â²Ã‚Â´ÃƒÂ­Ã†â€™Ã‚Â­
		public static final int STF_0102 = 4001;	// ÃƒÂ¬Ã‚Â§Ã¯Â¿Â½ÃƒÂ¬Ã¢â‚¬ÂºÃ¯Â¿Â½ÃƒÂªÃ‚Â²Ã¢â€šÂ¬ÃƒÂ¬Ã†â€™Ã¢â‚¬Â° - ÃƒÂ«Ã‚Â¶Ã¢â€šÂ¬ÃƒÂ¬Ã¢â‚¬Å¾Ã…â€œÃƒÂªÃ‚Â²Ã¢â€šÂ¬ÃƒÂ¬Ã†â€™Ã¢â‚¬Â°
		public static final int STF_0104 = 4002;	// ÃƒÂ¬Ã‚Â§Ã¯Â¿Â½ÃƒÂ¬Ã¢â‚¬ÂºÃ¯Â¿Â½ÃƒÂªÃ‚Â²Ã¢â€šÂ¬ÃƒÂ¬Ã†â€™Ã¢â‚¬Â° - ÃƒÂ¬Ã†â€™Ã¯Â¿Â½ÃƒÂ¬Ã¢â‚¬Å¾Ã‚Â¸ÃƒÂ­Ã¢â€žÂ¢Ã¢â‚¬ï¿½ÃƒÂ«Ã‚Â©Ã‚Â´
		public static final int STF_TAB_0101 = 4100;	// ÃƒÂ¬Ã‚Â§Ã¯Â¿Â½ÃƒÂ¬Ã¢â‚¬ÂºÃ¯Â¿Â½ÃƒÂªÃ‚Â²Ã¢â€šÂ¬ÃƒÂ¬Ã†â€™Ã¢â‚¬Â° - ÃƒÂ¬Ã‚Â Ã¢â‚¬Å¾ÃƒÂ¬Ã‚Â²Ã‚Â´ÃƒÂ­Ã†â€™Ã‚Â­_ÃƒÂ­Ã†â€™Ã‚Â­ÃƒÂ­Ã‹Å“Ã‚Â¸ÃƒÂ¬Ã‚Â¶Ã…â€œ
		public static final int STF_TAB_0102 = 4101;	// ÃƒÂ¬Ã‚Â§Ã¯Â¿Â½ÃƒÂ¬Ã¢â‚¬ÂºÃ¯Â¿Â½ÃƒÂªÃ‚Â²Ã¢â€šÂ¬ÃƒÂ¬Ã†â€™Ã¢â‚¬Â° - ÃƒÂ«Ã‚Â¶Ã¢â€šÂ¬ÃƒÂ¬Ã¢â‚¬Å¾Ã…â€œÃƒÂªÃ‚Â²Ã¢â€šÂ¬ÃƒÂ¬Ã†â€™Ã¢â‚¬Â°_ÃƒÂ­Ã†â€™Ã‚Â­ÃƒÂ­Ã‹Å“Ã‚Â¸ÃƒÂ¬Ã‚Â¶Ã…â€œ
		public static final int STF_TAB_0103 = 4102;	// ÃƒÂ¬Ã‚Â§Ã¯Â¿Â½ÃƒÂ¬Ã¢â‚¬ÂºÃ¯Â¿Â½ÃƒÂªÃ‚Â²Ã¢â€šÂ¬ÃƒÂ¬Ã†â€™Ã¢â‚¬Â° - ÃƒÂ¬Ã†â€™Ã¢â‚¬Â°ÃƒÂ¬Ã¯Â¿Â½Ã‚Â¸ÃƒÂ­Ã†â€™Ã‚Â­_ÃƒÂ­Ã†â€™Ã‚Â­ÃƒÂ­Ã‹Å“Ã‚Â¸ÃƒÂ¬Ã‚Â¶Ã…â€œ
		
		public static final int WRK_020102	= 50102;	// ÃƒÂ­Ã¢â‚¬Â¢Ã‚Â ÃƒÂ¬Ã¯Â¿Â½Ã‚Â¼ ÃƒÂ¬Ã‚Â Ã¢â‚¬Å¾ÃƒÂ¬Ã‚Â²Ã‚Â´
		public static final int WRK_020103	= 50103;	// ÃƒÂ­Ã¢â‚¬Â¢Ã‚Â ÃƒÂ¬Ã¯Â¿Â½Ã‚Â¼ ÃƒÂ«Ã‚Â¶Ã¢â‚¬Å¾ÃƒÂ«Ã‚Â¥Ã‹Å“ÃƒÂ«Ã‚Â³Ã¢â‚¬Å¾ ÃƒÂ«Ã¢â‚¬Å¡Ã‚Â´ÃƒÂ¬Ã¢â‚¬â€�Ã‚Â­
		public static final int WRK_020201	= 50201;	// ÃƒÂ­Ã¢â‚¬Â¢Ã‚Â ÃƒÂ¬Ã¯Â¿Â½Ã‚Â¼ ÃƒÂ¬Ã†â€™Ã¯Â¿Â½ÃƒÂ¬Ã¢â‚¬Å¾Ã‚Â¸
		public static final int WRK_020202	= 50202;	// ÃƒÂ­Ã¢â‚¬Â¢Ã‚Â ÃƒÂ¬Ã¯Â¿Â½Ã‚Â¼ ÃƒÂ«Ã¢â‚¬Å“Ã‚Â±ÃƒÂ«Ã‚Â¡Ã¯Â¿Â½
		
		public static final int APP_0101    = 60101;	// ÃƒÂªÃ‚Â²Ã‚Â°ÃƒÂ¬Ã‚Â Ã…â€œ ÃƒÂ«Ã‚ÂªÃ‚Â©ÃƒÂ«Ã‚Â¡Ã¯Â¿Â½
		public static final int APP_0102    = 60102;	// ÃƒÂªÃ‚Â²Ã‚Â°ÃƒÂ¬Ã‚Â Ã…â€œ ÃƒÂ¬Ã†â€™Ã¯Â¿Â½ÃƒÂ¬Ã¢â‚¬Å¾Ã‚Â¸		
		
		public static final int BBS_0102    = 70102;	// ÃƒÂªÃ‚Â²Ã…â€™ÃƒÂ¬Ã¢â‚¬Â¹Ã…â€œÃƒÂ­Ã…â€™Ã¯Â¿Â½ ÃƒÂ¬Ã†â€™Ã¯Â¿Â½ÃƒÂ¬Ã¢â‚¬Å¾Ã‚Â¸
		public static final int BBS_0104    = 70104;	// ÃƒÂªÃ‚Â²Ã…â€™ÃƒÂ¬Ã¢â‚¬Â¹Ã…â€œÃƒÂ­Ã…â€™Ã¯Â¿Â½ ÃƒÂ«Ã…â€™Ã¢â‚¬Å“ÃƒÂªÃ‚Â¸Ã¢â€šÂ¬ÃƒÂ«Ã‚ÂªÃ‚Â©ÃƒÂ«Ã‚Â¡Ã¯Â¿Â½
	}
}

