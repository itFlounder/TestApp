package com.shsany.testapp.example.expandable;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseExpandableListAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.shsany.testapp.R;

import java.util.List;

/**
 * Created by PC on 2018/1/5.
 */

public class ExpandeAdapter extends BaseExpandableListAdapter {

    private Context mContext;
    private LayoutInflater mInflater = null;
    private String[] mGroupStrings = null;
    private List<List<Item>> mData = null;

    public ExpandeAdapter(Context context,List<List<Item>> list){
        mContext = context;
        mInflater = (LayoutInflater)mContext.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
//        mGroupStrings = mContext.getResources().getStringArray(R.array.groups);
        mData = list;
    }

    public void setmData(List<List<Item>> list){
        mData = list;
    }
    @Override
    public int getGroupCount() {
        return mData.size();
    }

    @Override
    public int getChildrenCount(int groupPosition) {
        return mData.get(groupPosition).size();
    }

    //List<Item>
    @Override
    public List<Item> getGroup(int groupPosition) {
        return mData.get(groupPosition);
    }

    //Item
    @Override
    public Item getChild(int groupPosition, int childPosition) {
        return mData.get(groupPosition).get(childPosition);
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
        return false;
    }

    @Override
    public View getGroupView(int groupPosition, boolean isExpanded, View convertView, ViewGroup parent) {
        if (convertView == null){
            convertView = mInflater.inflate(R.layout.group_item_layout,null);
        }
        GroupViewHolder holder = new GroupViewHolder();
//        holder.mGroupName = (TextView) convertView
//                .findViewById(R.id.group_name);
//        holder.mGroupName.setText(mGroupStrings[groupPosition]);
//        holder.mGroupCount = (TextView) convertView
//                .findViewById(R.id.group_count);
//        holder.mGroupCount.setText("[" + mData.get(groupPosition).size() + "]");
        return convertView;
    }

    @Override
    public View getChildView(int groupPosition, int childPosition, boolean isLastChild, View convertView, ViewGroup parent) {
        if (convertView == null) {
            convertView = mInflater.inflate(R.layout.child_item_layout, null);
        }
        ChildViewHolder holder = new ChildViewHolder();
//        holder.mIcon = (ImageView) convertView.findViewById(R.id.img);
//        holder.mIcon.setBackgroundDrawable(getRoundCornerDrawable(
//                getChild(groupPosition, childPosition).getImageId(), 10));
//        holder.mChildName = (TextView) convertView.findViewById(R.id.item_name);
//        holder.mChildName.setText(getChild(groupPosition, childPosition)
//                .getName());
//        holder.mDetail = (TextView) convertView.findViewById(R.id.item_detail);
        holder.mDetail.setText(getChild(groupPosition, childPosition)
                .getDetail());
        return convertView;
    }

    @Override
    public boolean isChildSelectable(int groupPosition, int childPosition) {
        return true;
    }
//    private Drawable getRoundCornerDrawable(int resId, float roundPX /* 圆角的半径 */) {
//        Drawable drawable = mContext.getResources().getDrawable(resId);
//        int w = mContext.getResources().getDimensionPixelSize(R.dimen.image_width);
//        int h = w;
//
//        Bitmap bitmap = Bitmap
//                .createBitmap(w,h,
//                        drawable.getOpacity() != PixelFormat.OPAQUE ? Bitmap.Config.ARGB_8888
//                                : Bitmap.Config.RGB_565);
//        Canvas canvas = new Canvas(bitmap);
//        drawable.setBounds(0, 0, w, h);
//        drawable.draw(canvas);
//
//        int width = bitmap.getWidth();
//        int height = bitmap.getHeight();
//        Bitmap retBmp = Bitmap.createBitmap(width, height, Bitmap.Config.ARGB_8888);
//        Canvas can = new Canvas(retBmp);
//
//        final int color = 0xff424242;
//        final Paint paint = new Paint();
//        final Rect rect = new Rect(0, 0, width, height);
//        final RectF rectF = new RectF(rect);
//
//        paint.setColor(color);
//        paint.setAntiAlias(true);
//        can.drawARGB(0, 0, 0, 0);
//        can.drawRoundRect(rectF, roundPX, roundPX, paint);
//
//        paint.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.SRC_IN));
//        can.drawBitmap(bitmap, rect, rect, paint);
//        return new BitmapDrawable(retBmp);
//    }

    private class GroupViewHolder {
        TextView mGroupName;
        TextView mGroupCount;
    }

    private class ChildViewHolder {
        ImageView mIcon;
        TextView mChildName;
        TextView mDetail;
    }
}
