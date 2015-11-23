/** 
 * <pre>
 * 로그�?� �?�답전문
 * @COPYRIGHT (c) 2010 WebCash, Inc. All Right Reserved.
 *
 * @author       : WebCash
 * @Description  :
 * @History      :
 *
 * </pre>
 **/
package com.webcash.sws.toolkit.comm.tx.biz;

import org.json.JSONException;

import android.app.Activity;

import com.webcash.sws.comm.tx.TxField;
import com.webcash.sws.comm.tx.TxMessage;
import com.webcash.sws.comm.tx.TxRecord;
import com.webcash.sws.comm.util.ComUtil;

/**
 * Log in
 */
public class TX_LOGIN_ACT_HGIL00_RES extends TxMessage {
	private static int IDX_USER_NAME;
	private static int IDX_USER_PASS;
	private static int IDX_USER_ID;
	private static int IDX_IS_VERIFIED;
	
		
	public TX_LOGIN_ACT_HGIL00_RES(Activity atvt, Object obj, String txNo) throws Exception {
		mTxNo = TX_LOGIN_ACT_HGIL00_REQ.TXNO;
		mLayout = new TxRecord();
		
		IDX_USER_ID = mLayout.addField(new TxField("USER_ID","USER_ID")); 
		IDX_USER_PASS = mLayout.addField(new TxField("USER_PASS","USER_PASS")); 
		IDX_USER_NAME = mLayout.addField(new TxField("USER_NAME","USER_NAME"));
		IDX_IS_VERIFIED = mLayout.addField(new TxField("IS_VERIFIED", "IS_VERIFIED"));
			
		super.initRecvMessage(atvt, obj, txNo);
	}

	public String getUSERENAME() throws JSONException, Exception {
		return getString(mLayout.getField(IDX_USER_NAME).getId());
	}
	
	public String getUSERPASS() throws JSONException, Exception {
		ComUtil.printLog("Method GET", "mmmmmmmmmm"+mLayout.getField(IDX_USER_PASS).getId());
		return getString(mLayout.getField(IDX_USER_PASS).getId());//get USER_PASS
	}
	
	public String getUSEREID() throws JSONException, Exception {
		return getString(mLayout.getField(IDX_USER_ID).getId());
	}
	
	public String getIsVerified() throws JSONException, Exception {
		return getString(mLayout.getField(IDX_IS_VERIFIED).getId());
	}
}
