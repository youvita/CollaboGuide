package com.kosign.collaboguide;

import java.util.ArrayList;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

public class AdapterView extends BaseAdapter{
	private ArrayList<ItemList> mItemList;
	private Context mContext;
	
	public AdapterView(Context context,ArrayList<ItemList> itemlist){
		mItemList = itemlist;
		mContext = context;
	}

	@Override
	public int getCount() {
		// TODO Auto-generated method stub
		return mItemList.size();
	}

	@Override
	public Object getItem(int position) {
		// TODO Auto-generated method stub
		return mItemList.get(position);
	}

	@Override
	public long getItemId(int position) {
		// TODO Auto-generated method stub
		return position;
	}

	@Override
	public View getView(int position, View convertView, ViewGroup parent) {
		// TODO Auto-generated method stub
		if(convertView==null){
			convertView = LayoutInflater.from(mContext).inflate(R.layout.list_item, null);
		}
		
		TextView tv_part = (TextView)convertView.findViewById(R.id.tv_Part);
		TextView tv_title = (TextView)convertView.findViewById(R.id.tv_Title);
		
		ItemList mItem = mItemList.get(position);
		tv_part.setText(mItem.getPart());
		tv_title.setText(mItem.getTitle());
		
		convertView.setTag(mItem);
		
		return convertView;
	}

}
