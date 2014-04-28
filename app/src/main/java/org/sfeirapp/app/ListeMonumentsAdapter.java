package org.sfeirapp.app;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import org.sfeirapp.model.Monument;
import org.sfeirapp.model.MonumentsVille;

/**
 * Created by tarekelchami on 28/04/14.
 */
public class ListeMonumentsAdapter extends BaseAdapter {

    private Context context;
    private MonumentsVille monumentsVille;


    public ListeMonumentsAdapter(Context context, MonumentsVille monumentsVille) {
        this.context = context;
        this.monumentsVille = monumentsVille;
    }

    @Override
    public int getCount() {
        return this.monumentsVille.size();
    }

    @Override
    public Object getItem(int i) {
        return this.monumentsVille.get(i);
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        View itemView = view;

        if(itemView == null) {
            LayoutInflater inflater = (LayoutInflater) this.context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            itemView = inflater.inflate(R.layout.item_liste_definition, viewGroup, false);
        }

        TextView titreMonument = (TextView) itemView.findViewById(R.id.titreMonument);
        TextView lieuMonument = (TextView) itemView.findViewById(R.id.lieuMonument);
        TextView descMonument = (TextView) itemView.findViewById(R.id.descMonument);

        Monument mnt = this.monumentsVille.get(i);

        titreMonument.setText(mnt.getNomMonument());
        lieuMonument.setText(mnt.getLieuMonument());
        descMonument.setText(mnt.getDescription());

        return itemView;
    }
}
