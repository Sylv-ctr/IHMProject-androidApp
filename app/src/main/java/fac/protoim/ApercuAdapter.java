package fac.protoim;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.List;

/**
 * Created by Sylvain on 18/04/2016.
 */
public class ApercuAdapter extends ArrayAdapter<Apercu> {

    public ApercuAdapter(Context context, List<Apercu> type) {
        super(context, 0, type);
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        if(convertView == null){
            convertView = LayoutInflater.from(getContext()).inflate(R.layout.apercus,parent, false);
        }

        ApercuViewHolder viewHolder = (ApercuViewHolder) convertView.getTag();
        if(viewHolder == null){
            viewHolder = new ApercuViewHolder();
            viewHolder.jour = (TextView) convertView.findViewById(R.id.jour);
            viewHolder.mois = (TextView) convertView.findViewById(R.id.mois);
            viewHolder.type = (TextView) convertView.findViewById(R.id.typeEvent);
            viewHolder.description = (TextView) convertView.findViewById(R.id.descEvent);
            convertView.setTag(viewHolder);
        }

        //getItem(position) va récupérer l'item [position] de la List<Tweet> tweets
        Apercu monApercu = getItem(position);
        viewHolder.jour.setText(monApercu.getJour());
        viewHolder.mois.setText(monApercu.getMois());
        viewHolder.type.setText(monApercu.getType());
        viewHolder.description.setText(monApercu.getDescription());

        return convertView;
    }

    private class ApercuViewHolder{
        public TextView jour;
        public TextView mois;
        public TextView type;
        public TextView description;

    }

}
