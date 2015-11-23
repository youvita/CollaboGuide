 /**
 * <pre>
 * 공통 > 네비게이션바
 * @COPYRIGHT (c) 2014 Webcash, Inc. All Right Reserved.
 *
 * @author       : 스마트프레임워크팀 (최은경)
 * @Description  : 
 * @History      : 
 *
 * </pre>
 **/
package com.kosign.collaboguide;

import android.app.Activity;
import android.content.Context;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;

public class NavigationBar extends LinearLayout {
	
	private Activity mActivity = null;
	private Context mContext = null;

	public NavigationBar(Context context) {
		super(context);
		
		initialize(context, null);
	}
	
	public NavigationBar(Context context, AttributeSet attrs) {
		super(context, attrs);
		
		initialize(context, attrs);
	}
	
	private void initialize(Context context, AttributeSet attrs) {
		
		try {
			mContext = context;
			mActivity = (Activity)mContext;
	        String aInfService = Context.LAYOUT_INFLATER_SERVICE;
	        LayoutInflater aLi = (LayoutInflater) getContext().getSystemService(aInfService);
	        View aView = aLi.inflate(R.layout.comm_navigation_bar, this, false);
	        addView(aView); 
	        
	        boolean isBackButton = attrs.getAttributeBooleanValue(null, "back", true);
	        String strTitle = attrs.getAttributeValue(null, "title");				// 타이틀	   
	        String strLanguage = attrs.getAttributeValue(null, "language");			// 언어
	        strLanguage = TextUtils.isEmpty(strLanguage) ? "kr" : strLanguage;
	        
	        
	        setVisibleBackButton(isBackButton);
	        setTitle(strTitle, strLanguage);
	        
	        

			
	        // back 버튼
//	        Button btnBack =    (Button) aView.findViewById(R.id.btn_NavigationBack);
//	        btnBack.setOnClickListener(new View.OnClickListener() {
//				@Override
//				public void onClick(View v) {
//					mActivity = (Activity)mContext;
//					mActivity.onBackPressed();
//				}
//			});
	       
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}
	
	public void setVisibleBackButton(boolean value) {
//		findViewById(R.id.btn_NavigationBack).setVisibility(value ? View.VISIBLE : View.GONE);
	}
	
	public void setVisibleNavigationBarButton(int id, boolean value) {
		findViewById(id).setVisibility(value ? View.VISIBLE : View.GONE);
	}
	
	public void setVisibleNavigationBarButton(int id, boolean value, int resid) {
		findViewById(id).setVisibility(value ? View.VISIBLE : View.GONE);
		findViewById(id).setBackgroundResource(resid);
	}
	
	
	/**
	 * 타이틀 입력
	 * @param aTitle
	 */
	public void setTitle(String aTitle, String strLanguage) {

		try {
			if(null == aTitle || "".equals(aTitle)) return;

			TextView aView = (TextView) findViewById(R.id.tv_NavigationTitle);
			
			if (strLanguage.equals("kr")) {
				// 국문
				
			} else {
				// 영문
			}
			
			if (aTitle.charAt(0) != '@') {
				aView.setText(aTitle);	
			} else if (aTitle.substring(0, 7).toUpperCase().equals("@STRING")){
				aView.setText(getString(aTitle));
			} else {
				aView.setText("");
			}
		}catch (Exception e) {
			e.printStackTrace();
		}
		
	}
	
	/**
	 * 타이틀 가져오기
	 * @param aTitle
	 */
	public String getTitle() {
		TextView aView = (TextView) findViewById(R.id.tv_NavigationTitle);
		return aView.getText().toString();	
	}
	
	private String  getString(String value) {
		if(null == value || "".equals(value)) return "";

		if(value.charAt(0) == '@') {
			int aResId = getResources().getIdentifier( value.substring( 1 ), null, getContext().getPackageName());
			if (aResId > 0)
				return  getResources().getString(aResId);
			else return "";
		} else {
			return value;
		}
	}

}
