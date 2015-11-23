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
public class TX_LIST_PART_ACT_HGIL00_RES extends TxMessage {
	private static int IDX_REC;	
		
	public TX_LIST_PART_ACT_HGIL00_RES(Activity atvt, Object obj, String txNo) throws Exception {
		mTxNo = TX_LIST_PART_ACT_HGIL00_REQ.TXNO;
		mLayout = new TxRecord();
		
		IDX_REC = mLayout.addField(new TxField("LOT_PART_REC","LOT_PART_REC")); 
		
		super.initRecvMessage(atvt, obj, txNo);
	}
	
	public TX_LIST_PART_ACT_HGIL00_RES_REC1 getREC() throws JSONException, Exception {
		Object obj = getRecord(mLayout.getField(IDX_REC).getId());
		return new TX_LIST_PART_ACT_HGIL00_RES_REC1((Activity) mContext, obj, mTxNo);
	}

	
}
