/** 
 * <pre>
 * 로그�?� 요구전문
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

public class TX_LOGIN_ACT_HGIL00_REQ extends TxMessage {
	public static final String TXNO = "cth_login_r001";
	private static int IDX_USER_PASS;
	private static int IDX_USER_EMAIL;
	private static int IDX_AUTH_TYPE;
	
	public TX_LOGIN_ACT_HGIL00_REQ(Activity atvt, String txNo) throws Exception {
		mTxNo 				= TXNO;
		mLayout 			= new TxRecord();

		IDX_USER_EMAIL 		= mLayout.addField(new TxField("USER_EMAIL","USER_EMAIL"));
		IDX_USER_PASS		= mLayout.addField(new TxField("USER_PASS", "USER_PASS"));
		IDX_AUTH_TYPE		= mLayout.addField(new TxField("AUTH_TYPE", "AUTH_TYPE"));
		
		super.initSendMessage(atvt, txNo);
	}

	/**
	 * USER EMAIL
	 * @param value
	 * @throws Exception
	 */
	public void setUSEREMIL(String value) throws JSONException, Exception {
		mSendMessage.put(mLayout.getField(IDX_USER_EMAIL).getId(), value);
	}

	
	/**
	 * USER PW
	 * @param value
	 * @throws Exception
	 */
	public void setUSERPW(String value) throws JSONException, Exception {
		mSendMessage.put(mLayout.getField(IDX_USER_PASS).getId(), value);
	}

	
	public void setAuthType(String value) throws JSONException, Exception {
		mSendMessage.put(mLayout.getField(IDX_AUTH_TYPE).getId(), value);
	}
	
}
