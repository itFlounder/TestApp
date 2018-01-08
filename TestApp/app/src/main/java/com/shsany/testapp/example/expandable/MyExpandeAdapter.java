package com.shsany.testapp.example.expandable;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseExpandableListAdapter;
import android.widget.TextView;

import com.shsany.testapp.R;

import java.util.List;

/**
 * Created by PC on 2018/1/5.
 */

public class MyExpandeAdapter extends BaseExpandableListAdapter{
    private Context mContext;
    private LayoutInflater mInflater = null;
    private List<String> mGroupData = null;
    private List<String> mChildData = null;
    public MyExpandeAdapter(Context context,List<String> groupList,List<String> childList){
        super();
        this.mContext = context;
//        mInflater = (LayoutInflater)mContext.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        mInflater = LayoutInflater.from(context);
        this.mGroupData = groupList;
        this.mChildData = childList;
    }

    @Override
    public int getGroupCount() {
        return mGroupData.size();
    }

    @Override
    public int getChildrenCount(int groupPosition) {
        return mChildData.size();
    }

    @Override
    public Object getGroup(int groupPosition) {
        return mGroupData.get(groupPosition);
    }

    @Override
    public Object getChild(int groupPosition, int childPosition) {
        return mChildData.get(childPosition);
    }

    @Override
    public long getGroupId(int groupPosition) {
        return groupPosition;
    }

    @Override
    public long getChildId(int groupPosition, int childPosition) {
        return childPosition;
    }

    @Override
    public boolean hasStableIds() {
        return true;
    }

    @Override
    public View getGroupView(int groupPosition, boolean isExpanded, View convertView, ViewGroup parent) {
        GroupViewHolder groupViewHolder = null;
        if (convertView == null){
            groupViewHolder = new GroupViewHolder();
            convertView = mInflater.inflate(R.layout.group_item_layout,null);
            groupViewHolder.group = (TextView)convertView.findViewById(R.id.textGroup);
            convertView.setTag(groupViewHolder);
        }else {
            groupViewHolder = (GroupViewHolder)convertView.getTag();
        }
        groupViewHolder.group.setText(getGroup(groupPosition).toString());
        return convertView;
    }

    @Override
    public View getChildView(int groupPosition, int childPosition, boolean isLastChild, View convertView, ViewGroup parent) {
        ChlidViewHolder chlidViewHolder = null;
        if (convertView == null){
            chlidViewHolder = new ChlidViewHolder();
            convertView = mInflater.inflate(R.layout.child_item_layout,null);
            chlidViewHolder.child = (TextView)convertView.findViewById(R.id.textGroup);
            convertView.setTag(chlidViewHolder);
        }else {
            chlidViewHolder = (ChlidViewHolder)convertView.getTag();
        }
        chlidViewHolder.child.setText(getChild(groupPosition,childPosition).toString());
        return convertView;
    }

    @Override
    public boolean isChildSelectable(int groupPosition, int childPosition) {
        return true;
    }

    class ChlidViewHolder{
        TextView child;
    }
    class GroupViewHolder{
        TextView group;
    }
}
