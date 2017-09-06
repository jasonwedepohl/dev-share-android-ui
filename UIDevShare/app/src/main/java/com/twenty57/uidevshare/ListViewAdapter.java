package com.twenty57.uidevshare;

import android.content.Context;
import android.support.annotation.NonNull;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.LinearLayout;
import android.widget.TextView;

class ListViewAdapter extends ArrayAdapter<Planet>
{
    private static final Planet[] planets =
            {
                    new Planet("Mercury", "Red ball of flaming death"),
                    new Planet("Venus", "Acidic yellow ball of flaming death"),
                    new Planet("Earth", "Blue and green ball of existential angst"),
                    new Planet("Mars", "Barren red ball of freezing death with rovers"),
                    new Planet("Jupiter", "Giant gaseous ball of stormy death"),
                    new Planet("Saturn", "Ringed gaseous ball of freezing death"),
                    new Planet("Uranus", "Full of gas and has a ring around it."),
                    new Planet("Neptune", "Pretty blue ball of stormy freezing death")
            };

    ListViewAdapter(Context context)
    {
        super(context, R.layout.view_planet_list_item, planets);
    }

    @NonNull
    @Override
    public View getView(int position, View convertView, @NonNull ViewGroup parent)
    {
        final Planet planet = getItem(position);
        View planetView = convertView;

        if (planet != null)
        {
            try
            {
                if (planetView == null)
                    planetView = LayoutInflater.from(getContext()).inflate(R.layout.view_planet_list_item, parent, false);

                TextView planetNameView = planetView.findViewById(R.id.planetName);
                planetNameView.setText(planet.getName());

                TextView planetDescriptionView = planetView.findViewById(R.id.planetDescription);
                planetDescriptionView.setText(planet.getDescription());
            }
            catch (Exception exception)
            {
                exception.printStackTrace();
            }
        }

        return planetView == null ? new LinearLayout(getContext()) : planetView;
    }
}
