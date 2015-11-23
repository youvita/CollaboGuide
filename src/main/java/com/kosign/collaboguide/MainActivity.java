package com.kosign.collaboguide;


import com.webcash.sws.comm.define.Msg;
import com.webcash.sws.comm.tran.BizInterface;
import com.webcash.sws.comm.ui.DlgAlert;
import com.webcash.sws.toolkit.comm.tran.ComTran;
import com.webcash.sws.toolkit.comm.tx.biz.TX_LOGIN_ACT_HGIL00_REQ;
import com.webcash.sws.toolkit.comm.ui.browser.BizConf;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.telephony.TelephonyManager;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends Activity implements BizInterface {

	private ComTran mComTran;
	private EditText mEmail;
	private EditText mPass;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.login);
		mComTran = new ComTran(this);
		
		mEmail = (EditText)findViewById(R.id.et_Email);
		mPass = (EditText)findViewById(R.id.et_Pass);
		Button mLogin = (Button)findViewById(R.id.btn_Login);
		
		mLogin.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				msgTrSend(TX_LOGIN_ACT_HGIL00_REQ.TXNO);
			}
		});
		
		
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}
	
	public void msgTrSend_TX_LOGIN_ACT_HGIL00(String tranCd) throws Exception {	
		TX_LOGIN_ACT_HGIL00_REQ reqMsg = new TX_LOGIN_ACT_HGIL00_REQ(this, tranCd);
		reqMsg.setUSEREMIL(mEmail.getText().toString());
		reqMsg.setUSERPW(mPass.getText().toString());
		mComTran.msgTrSend(tranCd, reqMsg.getSendMessage(),true,true,false);
	}
	
	public void msgTrRecv_TX_LOGIN_ACT_HGIL00(String tranCd, Object obj) throws Exception {
		Intent mIntent = new Intent(this,ListPart.class);
		startActivity(mIntent);
	}

	@Override
	public void msgTrSend(String tranCd) {
		// TODO Auto-generated method stub
		try{
			if (tranCd.equals(TX_LOGIN_ACT_HGIL00_REQ.TXNO)) {
				msgTrSend_TX_LOGIN_ACT_HGIL00(tranCd);
			}
		}catch (Exception e){
			DlgAlert.Error(this, Msg.Exp.DEFAULT, e);
		}	
	}

	@Override
	public void msgTrRecv(String tranCd, Object obj) {
		// TODO Auto-generated method stub
		try{
			if (tranCd.equals(TX_LOGIN_ACT_HGIL00_REQ.TXNO)){
				msgTrRecv_TX_LOGIN_ACT_HGIL00(tranCd, obj);
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
