package com.krishna.mydemoapp.example.espresso;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.krishna.mydemoapp.R;

import java.util.List;

/**
 * Created by parthdesai on 2017-09-04.
 */

public class EspressoAdaptor extends RecyclerView.Adapter<EspressoAdaptor.MyViewHolder> {

    private List<EspressoModel> moviesList;

    public EspressoAdaptor(List<EspressoModel> moviesList) {
        this.moviesList = moviesList;
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.espresso_example_ui, parent, false);

        return new MyViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, int position) {
        EspressoModel model = moviesList.get(position);
        holder.firstName.setText(model.getFirstName());
        holder.secondName.setText(model.getSecondName());

    }

    @Override
    public int getItemCount() {
        return moviesList.size();
    }


    public class MyViewHolder extends RecyclerView.ViewHolder {
        public TextView firstName,secondName;

        public MyViewHolder(View view) {
            super(view);
            firstName = (TextView) view.findViewById(R.id.first_name);
            secondName = (TextView) view.findViewById(R.id.second_name);

        }
    }
}
