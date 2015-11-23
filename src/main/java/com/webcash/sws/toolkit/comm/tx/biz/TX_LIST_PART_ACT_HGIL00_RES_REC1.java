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

/**
 * Log in
 */
public class TX_LIST_PART_ACT_HGIL00_RES_REC1 extends TxMessage {
	
	private static int IDX_LOT_PART_LINK;	
	private static int IDX_LOT_LEVEL;	
	private static int IDX_LOT_PART_CD;	
	private static int IDX_LOT_PART_TITLE;	
	
		
	public TX_LIST_PART_ACT_HGIL00_RES_REC1(Activity atvt, Object obj, String txNo) throws Exception {
		mTxNo = TX_LIST_PART_ACT_HGIL00_REQ.TXNO;
		mLayout = new TxRecord();
		
		
		IDX_LOT_PART_LINK = mLayout.addField(new TxField("LOT_PART_LINK","LOT_PART_LINK")); 
		IDX_LOT_LEVEL = mLayout.addField(new TxField("LOT_LEVEL","LOT_LEVEL")); 
		IDX_LOT_PART_CD = mLayout.addField(new TxField("LOT_PART_CD","LOT_PART_CD")); 
		IDX_LOT_PART_TITLE = mLayout.addField(new TxField("LOT_PART_TITLE","LOT_PART_TITLE")); 
		
		super.initRecvMessage(atvt, obj, txNo);
	}

	
	public String getLOTPARTLINKCD() throws JSONException, Exception {
		return getString(mLayout.getField(IDX_LOT_PART_LINK).getId());
	}
	
	public String getLOT_LEVEL() throws JSONException, Exception {
		return getString(mLayout.getField(IDX_LOT_LEVEL).getId());
	}
	
	public String getLOTPARTCD() throws JSONException, Exception {
		return getString(mLayout.getField(IDX_LOT_PART_CD).getId());
	}
	
	public String getLOTPARTTITLE() throws JSONException, Exception {
		return getString(mLayout.getField(IDX_LOT_PART_TITLE).getId());
	}
	
	
}
