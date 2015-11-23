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

public class TX_LIST_PART_ACT_HGIL00_REQ extends TxMessage {
	public static final String TXNO = "cth_lot_l001";
	private static int IDX_LOT_PART_REC;
	private static int IDX_USER_ID;
	
	public TX_LIST_PART_ACT_HGIL00_REQ(Activity atvt, String txNo) throws Exception {
		mTxNo = TXNO;
		mLayout = new TxRecord();

		IDX_LOT_PART_REC = mLayout.addField(new TxField("LOT_PART_REC","LotPartRec"));
		IDX_USER_ID	= mLayout.addField(new TxField("USER_ID", "UserID"));
		super.initSendMessage(atvt, txNo);
	}

	/**
	 * set category cd
	 * @param value
	 * @throws Exception
	 */
	public void setLOTPARTREC(String value) throws JSONException, Exception {
		mSendMessage.put(mLayout.getField(IDX_LOT_PART_REC).getId(), value);
	}

	/**
	 * get category cd
	 * @param value
	 * @throws Exception
	 */
	public String getLOTPARTREC() throws Exception {
		return (String) mSendMessage.get(mLayout.getField(IDX_LOT_PART_REC).getId());
	}
	
	/**
	 * set user id
	 * @param value
	 * @throws Exception
	 */
	public void setUSERID(String value) throws JSONException, Exception {
		mSendMessage.put(mLayout.getField(IDX_USER_ID).getId(), value);
	}

	/**
	 * get user id
	 * @param value
	 * @throws Exception
	 */
	public String getUSERID() throws Exception {
		return (String) mSendMessage.get(mLayout.getField(IDX_USER_ID).getId());
	}

}
