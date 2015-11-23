package com.webcash.sws.toolkit.comm.tran;

import java.io.IOException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import org.apache.http.NameValuePair;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.ResponseHandler;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.cookie.Cookie;
import org.apache.http.impl.client.BasicResponseHandler;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.params.BasicHttpParams;
import org.apache.http.params.HttpConnectionParams;
import org.apache.http.params.HttpParams;
import org.json.JSONArray;
import org.json.JSONObject;
import android.app.Activity;
import android.app.AlertDialog;
import android.app.ProgressDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.text.format.DateFormat;
import android.util.Log;
import com.webcash.sws.comm.tran.WrapperAsyncCaller;
import com.webcash.sws.comm.tran.WrapperAsyncParam;
import com.webcash.sws.comm.util.ComUtil;

public class ComTran {
	
	private static final String KEY_TRAN_CD 			= "KEY";
	private static final String KEY_APP_TYPE 			= "APP_TYPE";
	private static final String KEY_TRAN_TR_TIME 		= "TR_TIME";
	private static final String KEY_TRAN_REQ_DATA 		= "REQ_DATA";
	private static final String KEY_TRAN_RES_DATA 		= "RESP_DATA";
	private static final String KEY_TRAN_ERROR_CD		= "RSLT_CD";
	private static final String KEY_TRAN_ERROR_MSG		= "RSLT_MSG";
	private static final String KEY_USER_ID				= "USER_ID";
	private Activity mActivity;
	private String mTranCd;	
	private Boolean mIsShowDialog = true;
	private boolean mIsSendCancel = false;
	private String mInput;
	private String mOutput;
	private String mAlertTitle = "Error";
	private ConnectivityManager mConnectivity;
	private NetworkInfo mInfo;
	private boolean mIsTranCancel;
	private Boolean mIsTranRecv = true;	
	private ProgressDialog mPgDialog;	
	
	private String mTrnsErrCd;
	public static DefaultHttpClient mHttpclient;
	public static List<Cookie> mCookies;
	private String mPageNo;
	
	public ComTran(Activity acti)
	{
		mActivity = acti;
	}
	
	public void msgTrSend(String tran_cd, HashMap<String, Object> tran_req_data, Boolean isShowDialog, Boolean isTranRecv, Boolean isSendCancel)
	{
		try {
			
			printLog("msgTrSend", "msgTrSend============");
			mTranCd = tran_cd;
			mIsShowDialog = isShowDialog;
			mIsTranRecv = isTranRecv;
			mIsSendCancel = isSendCancel;
			printLog("msgTrSend", "msgTrSend============0000000000000");
			makeJsonData(tran_cd, tran_req_data);
			printLog("msgTrSend", "msgTrSend============1111111111111111");
			 
		
			String call_method = "sendData";
			printLog("msgTrSend", "msgTrSend============222222222222222");
			// call method sendData()	
			Method aMethod = ComTran.class.getDeclaredMethod(call_method);
			
			WrapperAsyncParam aXCoreWrapperParam = new WrapperAsyncParam(aMethod, this);
			new WrapperAsyncCaller().execute(aXCoreWrapperParam);	
			
		} catch (Exception e) {
			makeExceptionData(mTranCd, TranErrorCode.TRNS_ERRCD_MAKE);
			e.printStackTrace();
		}
	
	}
	
	
	public void msgTrSend(String tran_cd, HashMap<String, Object> tran_req_data, Boolean isShowDialog)
	{
		msgTrSend(tran_cd, tran_req_data, isShowDialog, true, true);
	}
	
	public void msgTrSend(String tran_cd, HashMap<String, Object> tran_req_data)
	{
		msgTrSend(tran_cd, tran_req_data, true, true, true);
	}
	
	
	@SuppressWarnings("unchecked")
	private void makeJsonData(String tran_cd, HashMap<String, Object> tran_req_data){
		JSONObject jobjectInput 	= new JSONObject();
		JSONObject jobjectReqData 	= new JSONObject();
		JSONArray  jarrayReqData 	= new JSONArray();

		try {
			Iterator<String> ite = tran_req_data.keySet().iterator();
			while (ite.hasNext()) {
				String key = ite.next();

				if(tran_req_data.get(key) instanceof java.util.List)
				{
					//If the List
					JSONArray  jarray 	= new JSONArray();
					List<HashMap<String, String>> list = (List<HashMap<String, String>>) tran_req_data.get(key);

					for (HashMap<String, String> map : list) {
						JSONObject jobj = new JSONObject();
						Iterator<String> iteMap = map.keySet().iterator();

						while (iteMap.hasNext()) {
							String keyMap = iteMap.next();
							jobj.put(keyMap, map.get(keyMap));
						}
						jarray.put(jobj);
					}
					jobjectReqData.put(key, jarray);
				}
				else
				{	
					jobjectReqData.put(key, tran_req_data.get(key));
				}
			}

			jarrayReqData.put(jobjectReqData);
			printLog("makeJsonData", "tran_cd:::"+jarrayReqData);
			
			
			jobjectInput.put(KEY_TRAN_CD		, tran_cd);													//API Key
			jobjectInput.put(KEY_APP_TYPE		, "1");												//Application Type : ANDROID(1), IOS(2)
			jobjectInput.put(KEY_USER_ID		, "16eae23b-1c48-4678-85ad-4eb5783d3f06");	
			jobjectInput.put(KEY_TRAN_TR_TIME	, DateFormat.format("yyyyMMddhhmmss", new Date()));	//Transaction DateTime
			jobjectInput.put(KEY_TRAN_REQ_DATA	, jarrayReqData.get(0));
			mInput = jobjectInput.toString();
			
			printLog("makeJsonData", "Input_"+mInput);
					
		} catch (Exception e) {
			makeExceptionData(mTranCd, TranErrorCode.TRNS_ERRCD_MAKE);
			e.printStackTrace();
		}
	}
	
	
	/*
	 *Specialized encryption, and then sends the results to the actual transfer certain methods
	 */
	@SuppressWarnings("unused")
	private void sendData()
	{	
		
		ComUtil.printLog( "sendData", "send data first >>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>");
		
		mIsTranCancel = false;

		mConnectivity = (ConnectivityManager)mActivity.getSystemService(Context.CONNECTIVITY_SERVICE);
		mInfo = mConnectivity.getActiveNetworkInfo(); //Internet connected state 
	
			mActivity.runOnUiThread( new Runnable() {
				@Override
				public void run() {
					
					mPgDialog = new ProgressDialog(mActivity);
					mPgDialog.setMessage("Processing.\nPlease wait!");
					mPgDialog.setCancelable(mIsSendCancel);
					mPgDialog.setCanceledOnTouchOutside(false);
					mPgDialog.setOnCancelListener(new DialogInterface.OnCancelListener() {
						@Override
						public void onCancel(DialogInterface dialog) {
							mIsTranCancel = true;						
						}
					});
					if(mIsShowDialog)	mPgDialog.show();
				}
			});	
			
			printLog("sendData()","Thread  >>>>>>>>>>");
		
		// Variables init

		mOutput 		= null;
		mTrnsErrCd 		= "";
	
		printLog("sendData()","_input:::" + mInput);
		
		if(mInfo == null)
		{
			//network connection fail 
			printLog("sendData()","NetworkInfo fail");
			mTrnsErrCd = TranErrorCode.TRNS_ERRCD_INTERNET;
		}
		else
		{
			//Network connection true
			printLog("sendData()","NetworkInfo true");
			try
			{
				//httpclient create
				HttpPost httppost;
				/*
				 * httppost = new HttpPost("your login link");
				 */
//				httppost = new HttpPost("http://192.168.178.83:19100/gateway/gauus_api.jsp?");
				httppost = new HttpPost("http://bizconsult.wecambodia.com/gateway/gauus_api.jsp?");

					
				
				ComUtil.printLog("sendData()","httppost=================" + httppost.getURI());		
				
				//apache.http.client used to set connection timeout
				if(mHttpclient == null)
				{
					printLog("csback"," mHttpclient is null or url reset");
					
					HttpParams httpparams = new BasicHttpParams();
					HttpConnectionParams.setConnectionTimeout(httpparams, 1000 *  60 * 1);
					HttpConnectionParams.setSoTimeout(httpparams, 1000 *  60 * 1);
					
					mHttpclient = new DefaultHttpClient(httpparams);
				}
				
								
//				httppost.setHeader("User-Agent", BizBrowser.mUserAgent);
//								
//				ComUtil.printLog("sendData()","_useragent:::" + BizBrowser.mUserAgent);
				
				ArrayList<NameValuePair> paramList = new ArrayList<NameValuePair>();
				paramList.add(new BasicNameValuePair("JSONData", mInput));
				httppost.setEntity(new UrlEncodedFormEntity(paramList, "EUC-KR"));
				
				ComUtil.printLog("sendData()","httpclient send");
		        ResponseHandler<String> aResponseHandler = new BasicResponseHandler();
		        
		        String aResponseBody = mHttpclient.execute(httppost, aResponseHandler);
		        
				ComUtil.printLog("sendData()","BlockDec start");
		     
				mOutput= aResponseBody.trim();
				ComUtil.printLog("sendData()","_output:::" + mOutput);
				     
		        //to set the cookie information httpclient.
		        mCookies = mHttpclient.getCookieStore().getCookies();
		   		       
		        mInput = null; //send data init
		        
			} catch (ClientProtocolException e) {
				
				// Http error
				mTrnsErrCd = TranErrorCode.TRNS_ERRCD_PAGEERR;
				ComUtil.printLog("sendData()","ClientProtocolException");
				e.printStackTrace();
				
		    } catch (IOException e) {
		    	
		    	// Timeout error
		    	String aaa = e.getMessage();
		    	Log.d("test", aaa);
		    	mTrnsErrCd = TranErrorCode.TRNS_ERRCD_TIMEOUT;  	
		    	ComUtil.printLog("sendData()","IOException");
		    	e.printStackTrace();
		    	
		    } catch (Exception e) {
		    	
		    	// Unknown error
		    	mTrnsErrCd = TranErrorCode.TRNS_ERRCD_UNKNOWN;
		    	ComUtil.printLog("sendData()","Exception");
		    	e.printStackTrace();
		    	
		    }
		}
		
		if(!mIsTranCancel)
		{
			printLog("sendData()","recvDataSend...............");
			
			
			//ÃƒÂ¬Ã‚Â·Ã‚Â¨ÃƒÂ¬Ã¢â‚¬Â Ã…â€™ÃƒÂªÃ‚Â°Ã¢â€šÂ¬ ÃƒÂ¬Ã¢â‚¬Â¢Ã¢â‚¬Å¾ÃƒÂ«Ã¢â‚¬Â¹Ã…â€™ÃƒÂªÃ‚Â²Ã‚Â½ÃƒÂ¬Ã…Â¡Ã‚Â° ÃƒÂ¬Ã¯Â¿Â½Ã¢â‚¬ËœÃƒÂ«Ã¢â‚¬Â¹Ã‚ÂµÃƒÂ¬Ã¯Â¿Â½Ã¢â‚¬Å¾ ÃƒÂ«Ã¢â‚¬Å¡Ã‚Â´ÃƒÂ«Ã‚Â Ã‚Â¤ÃƒÂ¬Ã‚Â¤Ã¢â€šÂ¬ÃƒÂ«Ã¢â‚¬Â¹Ã‚Â¤.
		    mActivity.runOnUiThread( new Runnable() {
				@Override
				public void run() {
					if(mIsShowDialog)
					{
						mPgDialog.dismiss();			
					}			
					if(mIsTranRecv) //ÃƒÂ¬Ã¯Â¿Â½Ã¢â‚¬ËœÃƒÂ«Ã¢â‚¬Â¹Ã‚ÂµÃƒÂ¬Ã‚Â Ã¢â‚¬Å¾ÃƒÂ«Ã‚Â¬Ã‚Â¸ÃƒÂ¬Ã¯Â¿Â½Ã¢â‚¬Å¾ ÃƒÂ«Ã‚Â°Ã¢â‚¬ÂºÃƒÂ¬Ã¯Â¿Â½Ã¢â‚¬Å¾ÃƒÂ¬Ã‚Â§Ã¢â€šÂ¬ ÃƒÂ¬Ã¢â‚¬â€�Ã‚Â¬ÃƒÂ«Ã‚Â¶Ã¢â€šÂ¬
					{
						if(mTrnsErrCd.equals(""))
						{
							// ÃƒÂ¬Ã‚Â Ã¢â‚¬Â¢ÃƒÂ¬Ã†â€™Ã¯Â¿Â½ÃƒÂ¬Ã¯Â¿Â½Ã¢â‚¬ËœÃƒÂ«Ã¢â‚¬Â¹Ã‚ÂµÃƒÂ¬Ã¯Â¿Â½Ã‚Â¼ÃƒÂªÃ‚Â²Ã‚Â½ÃƒÂ¬Ã…Â¡Ã‚Â°
							parseJsonData(mOutput); 	
						}
						else
						{
							makeExceptionData(mTranCd, mTrnsErrCd);
						}
					}
				}
			});
	
		}
	    
		printLog("sendData()","END <<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<");
	}
	
	
	/**
	 * In the common case of error Exception makes the response data.
	 */
	private void makeExceptionData(String tran_cd, String err_cd)
	{
		try {
			String errcd	= err_cd;
			String errmsg = "";// 	= mComErrMsg;

			
			if(errcd.equals(TranErrorCode.TRNS_ERRCD_TIMEOUT))
			{
				errmsg = "Internet connections are not secure. Please use later.";
			}
			else if(errcd.equals(TranErrorCode.TRNS_ERRCD_PAGEERR))
			{
				errmsg = "Communication state is unstable. Please use later";
			}
			else if(errcd.equals(TranErrorCode.TRNS_ERRCD_UNKNOWN))
			{
				errmsg = "An internet connection is unstable. Please use after connectivity";
			}
			
			JSONObject errorObject = new JSONObject();
			errorObject.put(KEY_TRAN_ERROR_CD, errcd);
			errorObject.put(KEY_TRAN_ERROR_MSG, errmsg);		
			parseJsonData(errorObject.toString());
			
		} catch (Exception e) {
			e.printStackTrace();
		}			
	}	
	
	
	/**
	 * ÃƒÆ’Ã‚Â¬Ãƒâ€šÃ‚Â ÃƒÂ¢Ã¢â€šÂ¬Ã…Â¾ÃƒÆ’Ã‚Â«Ãƒâ€šÃ‚Â¬Ãƒâ€šÃ‚Â¸ÃƒÆ’Ã‚Â¬Ãƒâ€šÃ‚Â ÃƒÂ¢Ã¢â€šÂ¬Ã…Â¾ÃƒÆ’Ã‚Â¬ÃƒÂ¢Ã¢â€šÂ¬Ã‚Â Ãƒâ€šÃ‚Â¡ÃƒÆ’Ã‚Â­ÃƒÂ¢Ã¢â€šÂ¬Ã‚ÂºÃƒÂ¢Ã¢â€šÂ¬Ã…Â¾ ÃƒÆ’Ã‚ÂªÃƒâ€šÃ‚Â²Ãƒâ€šÃ‚Â°ÃƒÆ’Ã‚ÂªÃƒâ€šÃ‚Â³Ãƒâ€šÃ‚Â¼ÃƒÆ’Ã‚Â«Ãƒâ€šÃ‚Â¥Ãƒâ€šÃ‚Â¼ ÃƒÆ’Ã‚Â«Ãƒâ€šÃ‚Â°ÃƒÂ¢Ã¢â€šÂ¬Ã‚ÂºÃƒÆ’Ã‚ÂªÃƒâ€šÃ‚Â³Ãƒâ€šÃ‚Â  json ÃƒÆ’Ã‚Â«ÃƒÂ¯Ã‚Â¿Ã‚Â½Ãƒâ€šÃ‚Â°ÃƒÆ’Ã‚Â¬ÃƒÂ¯Ã‚Â¿Ã‚Â½Ãƒâ€šÃ‚Â´ÃƒÆ’Ã‚Â­Ãƒâ€ Ã¢â‚¬â„¢ÃƒÂ¢Ã¢â‚¬Å¡Ã‚Â¬ÃƒÆ’Ã‚Â«Ãƒâ€šÃ‚Â¥Ãƒâ€šÃ‚Â¼ ÃƒÆ’Ã‚Â­Ãƒâ€¦Ã¢â‚¬â„¢Ãƒâ€¦Ã¢â‚¬â„¢ÃƒÆ’Ã‚Â¬ÃƒÂ¢Ã¢â€šÂ¬Ã‚Â¹Ãƒâ€šÃ‚Â±ÃƒÆ’Ã‚Â­ÃƒÂ¢Ã¢â€šÂ¬Ã‚Â¢Ãƒâ€¦Ã¢â‚¬Å“ÃƒÆ’Ã‚Â«ÃƒÂ¢Ã¢â€šÂ¬Ã‚Â¹Ãƒâ€šÃ‚Â¤.
	 */
	private void parseJsonData(String output)
	{
		JSONObject jobjectOutput 	= null;
		JSONArray  jarrayResData 	= null;	
		
		String rslt_cd				= null;
		String rsltMsg 				= null;
		try {
			ComUtil.printLog("OUTDATA", output);

			jobjectOutput = new JSONObject(output.toString());
			
			rslt_cd = jobjectOutput.getString(KEY_TRAN_ERROR_CD);
			if(jobjectOutput.isNull(KEY_TRAN_ERROR_CD)){
				rslt_cd = "";
			}else{
				rslt_cd = jobjectOutput.getString(KEY_TRAN_ERROR_CD);
				rsltMsg = jobjectOutput.getString(KEY_TRAN_ERROR_MSG);
			}
			
			if(!jobjectOutput.isNull(KEY_TRAN_RES_DATA)){
				JSONObject jObj=jobjectOutput.getJSONObject(KEY_TRAN_RES_DATA);// get key json object
				jarrayResData = new JSONArray();
				jarrayResData.put(jObj);
				ComUtil.printLog("csback","errAction ::: " + jObj);
			}
			
			// check rslt cd
			if(!"0000".equals(rslt_cd))
			{
				comExceptionAlertDialog(rslt_cd, rsltMsg, mTranCd, jarrayResData);
			}
			else
			{	
				recvDataSend(mTranCd, jarrayResData, false, false);
			}

		} catch (Exception e) {
			printLog("json","error");
			makeExceptionData(mTranCd, TranErrorCode.TRNS_ERRCD_PASER);
			e.printStackTrace();
		}		
	}
	
	private void comExceptionAlertDialog(String errcd, String errmsg, final String tran_cd, final Object jarrayResData)
	{
		final String strMessage 	= errmsg;	
		mActivity.runOnUiThread(new Runnable() {
			
			@Override
			public void run() {
				new AlertDialog.Builder(mActivity)
				.setTitle(mAlertTitle)
				.setMessage(strMessage)   
				.setNeutralButton(android.R.string.ok,   
						new DialogInterface.OnClickListener() {   
					public void onClick(DialogInterface dialog, int whichButton)
					{
						mActivity.finish();
					}
				});
			}
		});
				
	}
	
	public class TranErrorCode {
		/**
		 * ÃƒÆ’Ã‚ÂªÃƒâ€šÃ‚Â³Ãƒâ€šÃ‚ÂµÃƒÆ’Ã‚Â­ÃƒÂ¢Ã¢â€šÂ¬Ã‚Â Ãƒâ€šÃ‚ÂµÃƒÆ’Ã‚Â¬ÃƒÂ¢Ã¢â€šÂ¬Ã¢â‚¬ï¿½ÃƒÂ¯Ã‚Â¿Ã‚Â½ÃƒÆ’Ã‚Â¬ÃƒÂ¢Ã¢â€šÂ¬Ã…Â¾Ãƒâ€¦Ã¢â‚¬Å“ ÃƒÆ’Ã‚Â¬Ãƒâ€šÃ‚Â ÃƒÂ¢Ã¢â€šÂ¬Ã…Â¾ÃƒÆ’Ã‚Â«Ãƒâ€šÃ‚Â¬Ãƒâ€šÃ‚Â¸ÃƒÆ’Ã‚Â«Ãƒâ€šÃ‚Â°Ãƒâ€¦Ã¢â‚¬Å“ÃƒÆ’Ã‚Â¬ÃƒÂ¢Ã¢â€šÂ¬Ã‚Â Ãƒâ€šÃ‚Â¡ ÃƒÆ’Ã‚Â«ÃƒÂ¯Ã‚Â¿Ã‚Â½Ãƒâ€šÃ‚Â°ÃƒÆ’Ã‚Â¬ÃƒÂ¯Ã‚Â¿Ã‚Â½Ãƒâ€šÃ‚Â´ÃƒÆ’Ã‚Â­Ãƒâ€ Ã¢â‚¬â„¢ÃƒÂ¢Ã¢â‚¬Å¡Ã‚Â¬ÃƒÆ’Ã‚Â«Ãƒâ€šÃ‚Â¥Ãƒâ€šÃ‚Â¼ ÃƒÆ’Ã‚Â«Ãƒâ€šÃ‚Â§Ãƒâ€¦Ã¢â‚¬â„¢ÃƒÆ’Ã‚Â«ÃƒÂ¢Ã¢â€šÂ¬Ã…â€œÃƒâ€¦Ã¢â‚¬Å“ÃƒÆ’Ã‚Â«Ãƒâ€¦Ã‚Â ÃƒÂ¢Ã¢â€šÂ¬Ã¯Â¿Â½ÃƒÆ’Ã‚Â¬Ãƒâ€šÃ‚Â¤ÃƒÂ¢Ã¢â€šÂ¬Ã‹Å“ÃƒÆ’Ã‚Â¬ÃƒÂ¢Ã¢â€šÂ¬Ã¢â‚¬ï¿½ÃƒÂ¯Ã‚Â¿Ã‚Â½ÃƒÆ’Ã‚Â«Ãƒâ€¦Ã‚Â¸Ãƒâ€šÃ‚Â¬
		 */
		public static final String TRNS_ERRCD_MAKE  		= "T001";	
		
		/**
		 * gate ÃƒÆ’Ã‚Â­Ãƒâ€¦Ã‚Â½Ãƒâ€¹Ã…â€œÃƒÆ’Ã‚Â¬ÃƒÂ¯Ã‚Â¿Ã‚Â½Ãƒâ€šÃ‚Â´ÃƒÆ’Ã‚Â¬Ãƒâ€šÃ‚Â§ÃƒÂ¢Ã¢â‚¬Å¡Ã‚Â¬ÃƒÆ’Ã‚Â«Ãƒâ€šÃ‚Â¡Ãƒâ€¦Ã¢â‚¬Å“ ÃƒÆ’Ã‚Â¬Ãƒâ€šÃ‚Â ÃƒÂ¢Ã¢â€šÂ¬Ã…Â¾ÃƒÆ’Ã‚Â«Ãƒâ€šÃ‚Â¬Ãƒâ€šÃ‚Â¸ÃƒÆ’Ã‚Â¬Ãƒâ€šÃ‚Â ÃƒÂ¢Ã¢â€šÂ¬Ã…Â¾ÃƒÆ’Ã‚Â¬ÃƒÂ¢Ã¢â€šÂ¬Ã‚Â Ãƒâ€šÃ‚Â¡ÃƒÆ’Ã‚Â¬ÃƒÂ¢Ã¢â€šÂ¬Ã‚Â¹Ãƒâ€¦Ã¢â‚¬Å“ timeout
		 */
		public static final String TRNS_ERRCD_TIMEOUT  		= "T002";
		
		/**
		 * gate ÃƒÆ’Ã‚Â­Ãƒâ€¦Ã‚Â½Ãƒâ€¹Ã…â€œÃƒÆ’Ã‚Â¬ÃƒÂ¯Ã‚Â¿Ã‚Â½Ãƒâ€šÃ‚Â´ÃƒÆ’Ã‚Â¬Ãƒâ€šÃ‚Â§ÃƒÂ¢Ã¢â‚¬Å¡Ã‚Â¬ÃƒÆ’Ã‚Â«Ãƒâ€šÃ‚Â¡Ãƒâ€¦Ã¢â‚¬Å“ ÃƒÆ’Ã‚Â¬Ãƒâ€šÃ‚Â ÃƒÂ¢Ã¢â€šÂ¬Ã…Â¾ÃƒÆ’Ã‚Â«Ãƒâ€šÃ‚Â¬Ãƒâ€šÃ‚Â¸ÃƒÆ’Ã‚Â¬Ãƒâ€šÃ‚Â ÃƒÂ¢Ã¢â€šÂ¬Ã…Â¾ÃƒÆ’Ã‚Â¬ÃƒÂ¢Ã¢â€šÂ¬Ã‚Â Ãƒâ€šÃ‚Â¡ÃƒÆ’Ã‚Â¬ÃƒÂ¢Ã¢â€šÂ¬Ã‚Â¹Ãƒâ€¦Ã¢â‚¬Å“ gate ÃƒÆ’Ã‚Â­Ãƒâ€¦Ã‚Â½Ãƒâ€¹Ã…â€œÃƒÆ’Ã‚Â¬ÃƒÂ¯Ã‚Â¿Ã‚Â½Ãƒâ€šÃ‚Â´ÃƒÆ’Ã‚Â¬Ãƒâ€šÃ‚Â§ÃƒÂ¢Ã¢â‚¬Å¡Ã‚Â¬ ÃƒÆ’Ã‚Â¬Ãƒâ€¹Ã…â€œÃƒâ€šÃ‚Â¤ÃƒÆ’Ã‚Â«Ãƒâ€šÃ‚Â¥Ãƒâ€¹Ã…â€œ
		 */	
		public static final String TRNS_ERRCD_PAGEERR  		= "T003";
		
		/**
		 * ÃƒÆ’Ã‚Â¬Ãƒâ€šÃ‚Â ÃƒÂ¢Ã¢â€šÂ¬Ã…Â¾ÃƒÆ’Ã‚Â«Ãƒâ€šÃ‚Â¬Ãƒâ€šÃ‚Â¸ÃƒÆ’Ã‚ÂªÃƒâ€šÃ‚Â²Ãƒâ€šÃ‚Â°ÃƒÆ’Ã‚ÂªÃƒâ€šÃ‚Â³Ãƒâ€šÃ‚Â¼ ÃƒÆ’Ã‚Â«Ãƒâ€šÃ‚Â°ÃƒÂ¢Ã¢â€šÂ¬Ã‚ÂºÃƒÆ’Ã‚Â¬ÃƒÂ¯Ã‚Â¿Ã‚Â½ÃƒÂ¢Ã¢â‚¬Å¡Ã‚Â¬ÃƒÆ’Ã‚Â­ÃƒÂ¢Ã¢â€šÂ¬Ã‚ÂºÃƒÂ¢Ã¢â€šÂ¬Ã…Â¾ ÃƒÆ’Ã‚ÂªÃƒâ€šÃ‚Â³Ãƒâ€šÃ‚ÂµÃƒÆ’Ã‚Â­ÃƒÂ¢Ã¢â€šÂ¬Ã‚Â Ãƒâ€šÃ‚ÂµÃƒÆ’Ã‚Â¬ÃƒÂ¢Ã¢â€šÂ¬Ã¢â‚¬ï¿½ÃƒÂ¯Ã‚Â¿Ã‚Â½ÃƒÆ’Ã‚Â¬ÃƒÂ¢Ã¢â€šÂ¬Ã…Â¾Ãƒâ€¦Ã¢â‚¬Å“ json ÃƒÆ’Ã‚Â­Ãƒâ€¦Ã¢â‚¬â„¢Ãƒâ€¦Ã¢â‚¬â„¢ÃƒÆ’Ã‚Â¬ÃƒÂ¢Ã¢â€šÂ¬Ã‚Â¹Ãƒâ€šÃ‚Â±ÃƒÆ’Ã‚Â¬Ãƒâ€šÃ‚Â¤ÃƒÂ¢Ã¢â€šÂ¬Ã‹Å“ ÃƒÆ’Ã‚Â¬ÃƒÂ¢Ã¢â€šÂ¬Ã¢â‚¬ï¿½ÃƒÂ¯Ã‚Â¿Ã‚Â½ÃƒÆ’Ã‚Â«Ãƒâ€¦Ã‚Â¸Ãƒâ€šÃ‚Â¬ (ÃƒÆ’Ã‚Â¬Ãƒâ€šÃ‚Â ÃƒÂ¢Ã¢â€šÂ¬Ã…Â¾ÃƒÆ’Ã‚Â«Ãƒâ€šÃ‚Â¬Ãƒâ€šÃ‚Â¸ ÃƒÆ’Ã‚Â­Ãƒâ€¹Ã…â€œÃƒÂ¢Ã¢â€šÂ¬Ã‚Â¢ÃƒÆ’Ã‚Â¬ÃƒÂ¢Ã¢â€šÂ¬Ã‚Â¹ÃƒÂ¯Ã‚Â¿Ã‚Â½ ÃƒÆ’Ã‚Â¬Ãƒâ€¦Ã‚Â¾Ãƒâ€¹Ã…â€œÃƒÆ’Ã‚Â«Ãƒâ€šÃ‚ÂªÃƒâ€šÃ‚Â»ÃƒÆ’Ã‚Â«ÃƒÂ¯Ã‚Â¿Ã‚Â½Ãƒâ€šÃ‚Â¨)
		 */	
		public static final String TRNS_ERRCD_PASER  		= "T004";
		
		/**
		 * ÃƒÆ’Ã‚Â¬ÃƒÂ¯Ã‚Â¿Ã‚Â½Ãƒâ€šÃ‚Â¸ÃƒÆ’Ã‚Â­ÃƒÂ¢Ã¢â€šÂ¬Ã…Â¾Ãƒâ€šÃ‚Â°ÃƒÆ’Ã‚Â«ÃƒÂ¢Ã¢â€šÂ¬Ã…Â¾Ãƒâ€šÃ‚Â· ÃƒÆ’Ã‚Â¬ÃƒÂ¢Ã¢â€šÂ¬Ã¢â‚¬ï¿½Ãƒâ€šÃ‚Â°ÃƒÆ’Ã‚ÂªÃƒâ€šÃ‚Â²Ãƒâ€šÃ‚Â°ÃƒÆ’Ã‚Â¬ÃƒÂ¢Ã¢â€šÂ¬Ã‚Â¢Ãƒâ€¹Ã¢â‚¬Â ÃƒÆ’Ã‚Â«ÃƒÂ¯Ã‚Â¿Ã‚Â½Ãƒâ€šÃ‚Â¨
		 */	
		public static final String TRNS_ERRCD_INTERNET  	= "T005";
		
		/**
		 * ÃƒÆ’Ã‚Â¬Ãƒâ€šÃ‚Â ÃƒÂ¢Ã¢â€šÂ¬Ã…Â¾ÃƒÆ’Ã‚Â«Ãƒâ€šÃ‚Â¬Ãƒâ€šÃ‚Â¸ÃƒÆ’Ã‚Â¬Ãƒâ€šÃ‚Â ÃƒÂ¢Ã¢â€šÂ¬Ã…Â¾ÃƒÆ’Ã‚Â¬ÃƒÂ¢Ã¢â€šÂ¬Ã‚Â Ãƒâ€šÃ‚Â¡ÃƒÆ’Ã‚Â¬Ãƒâ€šÃ‚Â¤ÃƒÂ¢Ã¢â€šÂ¬Ã‹Å“ ÃƒÆ’Ã‚Â¬ÃƒÂ¢Ã¢â€šÂ¬Ã‚Â¢Ãƒâ€¦Ã¢â‚¬â„¢ÃƒÆ’Ã‚Â¬Ãƒâ€¹Ã¢â‚¬Â Ãƒâ€¹Ã…â€œ ÃƒÆ’Ã‚Â¬ÃƒÂ¢Ã¢â€šÂ¬Ã¢â‚¬ï¿½ÃƒÂ¢Ã¢â€šÂ¬Ã‚Â ÃƒÆ’Ã‚Â«Ãƒâ€¦Ã‚Â ÃƒÂ¢Ã¢â€šÂ¬Ã¯Â¿Â½ ÃƒÆ’Ã‚Â¬Ãƒâ€¹Ã…â€œÃƒâ€šÃ‚Â¤ÃƒÆ’Ã‚Â«Ãƒâ€šÃ‚Â¥Ãƒâ€¹Ã…â€œ
		 */	
		public static final String TRNS_ERRCD_UNKNOWN  		= "T999";	
		
		
		/**
		 * TransKeyÃƒÆ’Ã‚Â¬ÃƒÂ¢Ã¢â€šÂ¬Ã¢â‚¬ï¿½ÃƒÂ¯Ã‚Â¿Ã‚Â½ÃƒÆ’Ã‚Â¬ÃƒÂ¢Ã¢â€šÂ¬Ã…Â¾Ãƒâ€¦Ã¢â‚¬Å“ ÃƒÆ’Ã‚Â¬Ãƒâ€¹Ã…â€œÃƒâ€šÃ‚Â¤ÃƒÆ’Ã‚Â«Ãƒâ€šÃ‚Â¥Ãƒâ€¹Ã…â€œ ÃƒÆ’Ã‚Â«Ãƒâ€šÃ‚Â°Ãƒâ€¦Ã¢â‚¬Å“ÃƒÆ’Ã‚Â¬Ãƒâ€ Ã¢â‚¬â„¢ÃƒÂ¯Ã‚Â¿Ã‚Â½
		 */
		public static final String APP_ERRCD_TRANSKEY  		= "A001";	
		
		/**
		 * ÃƒÆ’Ã‚ÂªÃƒâ€šÃ‚Â³Ãƒâ€šÃ‚ÂµÃƒÆ’Ã‚Â­ÃƒÂ¢Ã¢â€šÂ¬Ã‚Â Ãƒâ€šÃ‚ÂµÃƒÆ’Ã‚Â¬ÃƒÂ¢Ã¢â€šÂ¬Ã‚ÂºÃƒâ€šÃ‚Â¹ÃƒÆ’Ã‚Â«Ãƒâ€šÃ‚Â¸Ãƒâ€¦Ã¢â‚¬â„¢ÃƒÆ’Ã‚Â«ÃƒÂ¯Ã‚Â¿Ã‚Â½Ãƒâ€šÃ‚Â¼ÃƒÆ’Ã‚Â¬Ãƒâ€¦Ã‚Â¡Ãƒâ€šÃ‚Â°ÃƒÆ’Ã‚Â¬Ãƒâ€šÃ‚Â Ãƒâ€šÃ‚Â¸ÃƒÆ’Ã‚Â¬ÃƒÂ¢Ã¢â€šÂ¬Ã¢â‚¬ï¿½ÃƒÂ¯Ã‚Â¿Ã‚Â½ÃƒÆ’Ã‚Â¬ÃƒÂ¢Ã¢â€šÂ¬Ã…Â¾Ãƒâ€¦Ã¢â‚¬Å“ ÃƒÆ’Ã‚Â¬Ãƒâ€¦Ã‚Â¾Ãƒâ€¹Ã…â€œÃƒÆ’Ã‚Â«Ãƒâ€šÃ‚ÂªÃƒâ€šÃ‚Â»ÃƒÆ’Ã‚Â«ÃƒÂ¯Ã‚Â¿Ã‚Â½Ãƒâ€¦Ã¢â‚¬Å“ ÃƒÆ’Ã‚Â«Ãƒâ€šÃ‚Â§ÃƒÂ¯Ã‚Â¿Ã‚Â½ÃƒÆ’Ã‚Â­ÃƒÂ¯Ã‚Â¿Ã‚Â½Ãƒâ€šÃ‚Â¬ÃƒÆ’Ã‚Â¬Ãƒâ€šÃ‚Â ÃƒÂ¢Ã¢â€šÂ¬Ã‚Â¢ÃƒÆ’Ã‚Â«Ãƒâ€šÃ‚Â³Ãƒâ€šÃ‚Â´ÃƒÆ’Ã‚Â«Ãƒâ€šÃ‚Â¥Ãƒâ€šÃ‚Â¼ ÃƒÆ’Ã‚Â«Ãƒâ€šÃ‚Â°ÃƒÂ¢Ã¢â€šÂ¬Ã‚ÂºÃƒÆ’Ã‚Â¬ÃƒÂ¯Ã‚Â¿Ã‚Â½ÃƒÂ¢Ã¢â‚¬Å¡Ã‚Â¬ÃƒÆ’Ã‚ÂªÃƒâ€šÃ‚Â²Ãƒâ€šÃ‚Â½ÃƒÆ’Ã‚Â¬Ãƒâ€¦Ã‚Â¡Ãƒâ€šÃ‚Â°
		 */
		public static final String APP_ERRCD_BROWSER_URL  	= "A002";	
		
		/**
		 * XECURE SMARTÃƒÆ’Ã‚Â¬ÃƒÂ¢Ã¢â€šÂ¬Ã¢â‚¬ï¿½ÃƒÂ¯Ã‚Â¿Ã‚Â½ÃƒÆ’Ã‚Â¬ÃƒÂ¢Ã¢â€šÂ¬Ã…Â¾Ãƒâ€¦Ã¢â‚¬Å“ ÃƒÆ’Ã‚Â¬Ãƒâ€¹Ã…â€œÃƒâ€šÃ‚Â¤ÃƒÆ’Ã‚Â«Ãƒâ€šÃ‚Â¥Ãƒâ€¹Ã…â€œÃƒÆ’Ã‚ÂªÃƒâ€šÃ‚Â°ÃƒÂ¢Ã¢â‚¬Å¡Ã‚Â¬ ÃƒÆ’Ã‚Â«Ãƒâ€šÃ‚Â°Ãƒâ€¦Ã¢â‚¬Å“ÃƒÆ’Ã‚Â¬Ãƒâ€ Ã¢â‚¬â„¢ÃƒÂ¯Ã‚Â¿Ã‚Â½ÃƒÆ’Ã‚Â­ÃƒÂ¢Ã¢â€šÂ¬Ã‚Â¢Ãƒâ€¦Ã¢â‚¬Å“ÃƒÆ’Ã‚ÂªÃƒâ€šÃ‚Â²Ãƒâ€šÃ‚Â½ÃƒÆ’Ã‚Â¬Ãƒâ€¦Ã‚Â¡Ãƒâ€šÃ‚Â°
		 */
		public static final String APP_ERRCD_XECURE  	= "A003";	
		
		/**
		 * APP UNKNOWN ERROR
		 */
		public static final String APP_ERRCD_UNKNOWN  		= "A999";
	}
	
	/**
	 * LogÃƒÆ’Ã†â€™Ãƒâ€¦Ã‚Â½ÃƒÆ’Ã‚Â¢ÃƒÂ¢Ã¢â‚¬Å¡Ã‚Â¬Ãƒâ€šÃ‚Â¢ÃƒÆ’Ã¢â‚¬Å¡Ãƒâ€šÃ‚Âº ÃƒÆ’Ã†â€™Ãƒâ€¦Ã‚Â½ÃƒÆ’Ã†â€™ÃƒÂ¢Ã¢â€šÂ¬Ã‚Â¡ÃƒÆ’Ã¢â‚¬Å¡Ãƒâ€šÃ‚Â®ÃƒÆ’Ã†â€™ÃƒÂ¯Ã‚Â¿Ã‚Â½ÃƒÆ’Ã‚Â¢Ãƒâ€¹Ã¢â‚¬Â ÃƒÂ¯Ã‚Â¿Ã‚Â½ÃƒÆ’Ã¢â‚¬Å¡Ãƒâ€šÃ‚Â¥ÃƒÆ’Ã†â€™Ãƒâ€¦Ã‚Â½ÃƒÆ’Ã†â€™Ãƒâ€šÃ‚Â£ÃƒÆ’Ã¢â‚¬Å¡Ãƒâ€šÃ‚Â§. (ÃƒÆ’Ã†â€™ÃƒÂ¯Ã‚Â¿Ã‚Â½ÃƒÆ’Ã‚Â¢ÃƒÂ¢Ã¢â€šÂ¬Ã‚Â°Ãƒâ€šÃ‚Â¥ÃƒÆ’Ã¢â‚¬Å¡Ãƒâ€šÃ‚ÂµÃƒÆ’Ã†â€™Ãƒâ€¦Ã¢â‚¬â„¢ÃƒÆ’Ã†â€™Ãƒâ€¦Ã¢â‚¬Å“ÃƒÆ’Ã¢â‚¬Å¡Ãƒâ€šÃ‚ÂµÃƒÆ’Ã†â€™ÃƒÂ¯Ã‚Â¿Ã‚Â½ÃƒÆ’Ã†â€™Ãƒâ€šÃ‚Â³ÃƒÆ’Ã†â€™Ãƒâ€šÃ‚ÂªÃƒÆ’Ã†â€™ÃƒÂ¯Ã‚Â¿Ã‚Â½ÃƒÆ’Ã†â€™ÃƒÂ¢Ã¢â€šÂ¬Ã‹Å“ÃƒÆ’Ã†â€™Ãƒâ€šÃ‚ÂºÃƒÆ’Ã†â€™Ãƒâ€¦Ã‚Â½ÃƒÆ’Ã†â€™Ãƒâ€¦Ã‚Â¸ÃƒÆ’Ã†â€™Ãƒâ€šÃ‚Â¥ ÃƒÆ’Ã†â€™ÃƒÂ¯Ã‚Â¿Ã‚Â½ÃƒÆ’Ã†â€™ÃƒÂ¢Ã¢â€šÂ¬Ã‚Â¡ÃƒÆ’Ã¢â‚¬Å¡Ãƒâ€šÃ‚Â¨ÃƒÆ’Ã†â€™ÃƒÂ¯Ã‚Â¿Ã‚Â½ÃƒÆ’Ã†â€™Ãƒâ€šÃ‚Â¶ÃƒÆ’Ã¢â‚¬Å¡Ãƒâ€šÃ‚Â©ÃƒÆ’Ã†â€™Ãƒâ€¦Ã¢â‚¬â„¢ÃƒÆ’Ã†â€™Ãƒâ€šÃ‚Â¯ÃƒÆ’Ã‚Â¢ÃƒÂ¢Ã¢â‚¬Å¡Ã‚Â¬Ãƒâ€šÃ‚Â  ÃƒÆ’Ã†â€™ÃƒÂ¯Ã‚Â¿Ã‚Â½ÃƒÆ’Ã‚Â¢ÃƒÂ¢Ã¢â€šÂ¬Ã‚Â°Ãƒâ€šÃ‚Â¤ÃƒÆ’Ã†â€™ÃƒÂ¢Ã¢â€šÂ¬Ã‚Â°)
	 * @param tag LogÃƒÆ’Ã†â€™Ãƒâ€¦Ã¢â‚¬â„¢ÃƒÆ’Ã†â€™Ãƒâ€šÃ‚Â«ÃƒÆ’Ã†â€™Ãƒâ€šÃ‚ÂºÃƒÆ’Ã†â€™ÃƒÂ¯Ã‚Â¿Ã‚Â½ÃƒÆ’Ã†â€™Ãƒâ€šÃ‚Â£ÃƒÆ’Ã†â€™Ãƒâ€šÃ‚ÂºÃƒÆ’Ã†â€™Ãƒâ€¦Ã¢â‚¬â„¢ÃƒÆ’Ã†â€™ÃƒÂ¢Ã¢â€šÂ¬Ã‚Â°ÃƒÆ’Ã†â€™Ãƒâ€šÃ‚ÂºÃƒÆ’Ã†â€™ÃƒÂ¯Ã‚Â¿Ã‚Â½ÃƒÆ’Ã‚Â¢Ãƒâ€¹Ã¢â‚¬Â ÃƒÂ¢Ã¢â€šÂ¬Ã‹Å“ÃƒÆ’Ã‚Â¢Ãƒâ€¹Ã¢â‚¬Â ÃƒÂ¯Ã‚Â¿Ã‚Â½
	 * @param msg ÃƒÆ’Ã†â€™Ãƒâ€¦Ã‚Â½ÃƒÆ’Ã¢â‚¬Å¡Ãƒâ€šÃ‚Â©ÃƒÆ’Ã†â€™Ãƒâ€šÃ‚Â®ÃƒÆ’Ã†â€™ÃƒÂ¯Ã‚Â¿Ã‚Â½ÃƒÆ’Ã†â€™ÃƒÂ¢Ã¢â€šÂ¬Ã‹Å“ÃƒÆ’Ã‚Â¢Ãƒâ€¹Ã¢â‚¬Â ÃƒÂ¯Ã‚Â¿Ã‚Â½ÃƒÆ’Ã†â€™ÃƒÂ¯Ã‚Â¿Ã‚Â½ÃƒÆ’Ã†â€™Ãƒâ€¦Ã‚Â¸ÃƒÆ’Ã†â€™ÃƒÂ¢Ã¢â€šÂ¬Ã…Â¾
	 * @param vargs 
	 */
	public static void printLog(String tag, String msg, String...vargs)
	{
//		if(Conf.ISRELEASE) return;
		
		for(String var : vargs){
			msg = msg.replaceFirst("&", var);
		}		
		
		Log.d(tag, msg);
	}
	
	/**
	 * ÃƒÆ’Ã‚Â¬ÃƒÂ¯Ã‚Â¿Ã‚Â½ÃƒÂ¢Ã¢â€šÂ¬Ã‹Å“ÃƒÆ’Ã‚Â«ÃƒÂ¢Ã¢â€šÂ¬Ã‚Â¹Ãƒâ€šÃ‚ÂµÃƒÆ’Ã‚Â¬Ãƒâ€šÃ‚Â ÃƒÂ¢Ã¢â€šÂ¬Ã…Â¾ÃƒÆ’Ã‚Â«Ãƒâ€šÃ‚Â¬Ãƒâ€šÃ‚Â¸ ÃƒÆ’Ã‚ÂªÃƒâ€šÃ‚Â²Ãƒâ€šÃ‚Â°ÃƒÆ’Ã‚ÂªÃƒâ€šÃ‚Â³Ãƒâ€šÃ‚Â¼ÃƒÆ’Ã‚Â«Ãƒâ€šÃ‚Â¥Ãƒâ€šÃ‚Â¼ ÃƒÆ’Ã‚Â«ÃƒÂ¢Ã¢â€šÂ¬Ã…Â¡Ãƒâ€šÃ‚Â´ÃƒÆ’Ã‚Â«Ãƒâ€šÃ‚Â Ãƒâ€šÃ‚Â¤ÃƒÆ’Ã‚Â¬Ãƒâ€šÃ‚Â¤ÃƒÂ¢Ã¢â‚¬Å¡Ã‚Â¬ÃƒÆ’Ã‚Â«ÃƒÂ¢Ã¢â€šÂ¬Ã‚Â¹Ãƒâ€šÃ‚Â¤.
	 */	
	@SuppressWarnings("unchecked")
	private void recvDataSend(String tran_cd, Object jarrayResData, boolean isError, boolean isNotFound)
	{
		try {	
			@SuppressWarnings("rawtypes")
			Class cls = mActivity.getClass();
			Method method;
			String excuteMethod = "msgTrRecv";
			if(isError)	excuteMethod = "msgTrError"; 
			if(isNotFound)	excuteMethod = "msgTrNotFound"; 
			printLog("csback","call Method ::: " + excuteMethod);
			method = cls.getMethod(excuteMethod, String.class, Object.class);
			method.invoke(mActivity, tran_cd, jarrayResData);
		} catch (Exception e) {
			e.printStackTrace();
		}		
	}	
	
	

}
