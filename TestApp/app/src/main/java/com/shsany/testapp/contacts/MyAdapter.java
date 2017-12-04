package com.shsany.testapp.contacts;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.SectionIndexer;
import android.widget.TextView;

import com.shsany.testapp.R;

import java.util.List;

/**
 * Created by PC on 2017/10/13.
 */

public class MyAdapter extends BaseAdapter implements SectionIndexer {
    private Context context;
    private List<PersonBean> personBeens = null;
    private LayoutInflater layoutInflater;
    public MyAdapter(Context context,List<PersonBean> personBeens){
        this.context = context;
        this.personBeens = personBeens;
        layoutInflater = LayoutInflater.from(context);
    }
    @Override
    public int getCount() {
        return personBeens.size();
    }

    @Override
    public Object getItem(int position) {
        return personBeens.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder viewHolder = null;
        PersonBean personBean = personBeens.get(position);
        if (convertView == null){
            viewHolder = new ViewHolder();
            convertView = layoutInflater.inflate(R.layout.item_listview_contact,null);
            viewHolder.initial = (TextView)convertView.findViewById(R.id.first_alpha);
            viewHolder.name = (TextView)convertView.findViewById(R.id.contact_title);
            viewHolder.num = (TextView)convertView.findViewById(R.id.contact_phone_num);
            convertView.setTag(viewHolder);
        }else {
            viewHolder = (ViewHolder)convertView.getTag();
        }
        viewHolder.name .setText(personBean.getPerson());
        viewHolder.num.setText(personBean.getPhoneNum());
        if (getPositionForSection(getSectionForPosition(position)) == position){
            viewHolder.initial.setVisibility(View.VISIBLE);
            viewHolder.initial.setText(personBean.getInitial());
        }else {
            viewHolder.initial.setVisibility(View.GONE);
        }
        return convertView;
    }

    class ViewHolder{
        TextView initial,name,num;
    }

    @Override
    public Object[] getSections() {
        return null;
    }

    @Override
    public int getPositionForSection(int sectionIndex) {
        for (int i = 0; i<getCount();i++){
            String sort = personBeens.get(i).getInitial();
            char fchar = sort.toUpperCase().charAt(0);
            if (fchar == sectionIndex){
                return i;
            }
        }
        return -1;
    }

    @Override
    public int getSectionForPosition(int position) {
        return personBeens.get(position).getInitial().charAt(0);
    }

    /**
     *listview数据改变时用来更新listview
     * @param list
     */
    public void updateListView(List<PersonBean> list){
        this.personBeens = list;
        notifyDataSetChanged();
    }
}
