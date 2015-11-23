package com.kosign.collaboguide;

import java.util.ArrayList;

import com.webcash.sws.comm.debug.PrintLog;
import com.webcash.sws.comm.define.Msg;
import com.webcash.sws.comm.tran.BizInterface;
import com.webcash.sws.comm.ui.DlgAlert;
import com.webcash.sws.comm.util.ComUtil;
import com.webcash.sws.toolkit.comm.tran.ComTran;
import com.webcash.sws.toolkit.comm.tx.biz.TX_LIST_PART_ACT_HGIL00_REQ;
import com.webcash.sws.toolkit.comm.tx.biz.TX_LIST_PART_ACT_HGIL00_RES;
import com.webcash.sws.toolkit.comm.tx.biz.TX_LIST_PART_ACT_HGIL00_RES_REC1;

import android.app.Activity;
import android.os.Bundle;
import android.widget.ListView;


public class ListPart extends Activity implements BizInterface{

	private ComTran mComTran;
	private ListView mListView;
	private ArrayList<ItemList> mArrayList;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.list_view_item);
		mComTran = new ComTran(this);
		mListView = (ListView)findViewById(R.id.lv_List);
		mArrayList = new ArrayList<ItemList>();
		
		msgTrSend(TX_LIST_PART_ACT_HGIL00_REQ.TXNO);
		
		NavigationBar mNavigationBar = (NavigationBar)findViewById(R.id.navigationBar);
		mNavigationBar.setVisibleNavigationBarButton(R.id.btn_Alarm, true);
		mNavigationBar.setVisibleNavigationBarButton(R.id.btn_More, true);
		
	}
	
	public void msgTrSend_TX_LIST_PART_ACT_HGIL00(String tranCd) throws Exception {	
		TX_LIST_PART_ACT_HGIL00_REQ reqMsg = new TX_LIST_PART_ACT_HGIL00_REQ(this, tranCd);
		mComTran.msgTrSend(tranCd, reqMsg.getSendMessage(),true,true,false);
	}

	@Override
	public void msgTrSend(String tranCd) {
		// TODO Auto-generated method stub
		try{
			if (tranCd.equals(TX_LIST_PART_ACT_HGIL00_REQ.TXNO)) {
				msgTrSend_TX_LIST_PART_ACT_HGIL00(tranCd);
			}
		}catch (Exception e){
			DlgAlert.Error(this, Msg.Exp.DEFAULT, e);
		}	
	}
	
	public void msgTrRecv_TX_LIST_PART_ACT_HGIL00(String tranCd, Object obj) throws Exception {
		TX_LIST_PART_ACT_HGIL00_RES resMsg = new TX_LIST_PART_ACT_HGIL00_RES(this, obj, tranCd);
		TX_LIST_PART_ACT_HGIL00_RES_REC1 resRec = resMsg.getREC();
		int cnt = resRec.getLength();
	
		for(int i=0;i<cnt;i++){
			ItemList mItem = new ItemList();
			mItem.setId(String.valueOf(i));
			mItem.setPart(resRec.getLOTPARTLINKCD());
			mItem.setTitle(resRec.getLOTPARTTITLE());
			mArrayList.add(mItem);
			resRec.moveNext();
		}	
		
		AdapterView mAdapterView = new AdapterView(this, mArrayList);
		mListView.setAdapter(mAdapterView);
	}

	@Override
	public void msgTrRecv(String tranCd, Object obj) {
		// TODO Auto-generated method stub
		try{
			if (tranCd.equals(TX_LIST_PART_ACT_HGIL00_REQ.TXNO)){
				msgTrRecv_TX_LIST_PART_ACT_HGIL00(tranCd, obj);
			}
		}catch (Exception e){
			DlgAlert.Error(this, Msg.Exp.DEFAULT, e);
		}
	}

	@Override
	public void msgTrError(String tranCd, Object obj) throws Exception {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void msgTrNotFound(String tranCd, Object obj) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void msgTrCancel(String tranCd) {
		// TODO Auto-generated method stub
		
	}
}
