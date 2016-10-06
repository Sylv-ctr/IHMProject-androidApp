package fac.protoim;


import android.content.Context;
import android.graphics.drawable.ColorDrawable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;
/**
 *
 * Created by Sylvain on 15/04/2016.
 */
public class TypeAdapter extends ArrayAdapter<Type>{

    public TypeAdapter(Context context, List<Type> type) {
        super(context, 0, type);
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        if(convertView == null){
            convertView = LayoutInflater.from(getContext()).inflate(R.layout.rows,parent, false);
        }

        TypeViewHolder viewHolder = (TypeViewHolder) convertView.getTag();
        if(viewHolder == null){
            viewHolder = new TypeViewHolder();
            viewHolder.text = (TextView) convertView.findViewById(R.id.checkItem);
            convertView.setTag(viewHolder);
        }

        //getItem(position) va récupérer l'item [position] de la List<Tweet> tweets
        Type monType = getItem(position);
        viewHolder.text.setText(monType.getText());

        return convertView;
    }

    private class TypeViewHolder{
        public TextView text;

    }

}
