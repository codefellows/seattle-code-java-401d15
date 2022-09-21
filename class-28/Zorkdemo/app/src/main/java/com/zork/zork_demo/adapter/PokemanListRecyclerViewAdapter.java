
package com.zork.zork_demo.adapter;


import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.zork.zork_demo.R;
import com.zork.zork_demo.activities.OrderFormActivity;
import com.zork.zork_demo.activities.PokemanActivity;
import com.zork.zork_demo.models.Pokeman;

import java.util.List;

// TODO: Step 1-4: Make a class whose sole purpose is to manage RecyclerViews: a RecyclerView.Adapter
// Extend Recycler view.adapter
// TODO: Step 3-1: Clean up the RecyclerView.Adapter references to actually use ProductListRecyclerViewAdapter
    // (You'll need to change it in the methods below also)
public class PokemanListRecyclerViewAdapter extends RecyclerView.Adapter<PokemanListRecyclerViewAdapter.PokemanListViewHolder> {

    // TODO: Step 2-3: Hand in data items
    List<Pokeman> pokemans;
    // TODO: Step 3-2: Hand in the activity context
    Context callingActivity;

    //TODO: 2-3: Create constructor
    // TODO: Step: 3-2 Hand in the activity Context
    public PokemanListRecyclerViewAdapter(List<Pokeman> pokemans, Context callingActivity) {
        this.pokemans = pokemans;
        this.callingActivity = callingActivity;
    }

    @NonNull
    @Override
    public PokemanListViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        // TODO: Step 1-7: Inflate fragment
        View pokemanFragment = LayoutInflater.from(parent.getContext()).inflate(R.layout.fragment_pokeman, parent, false);
        return new PokemanListViewHolder(pokemanFragment);
    }

    @Override
    public void onBindViewHolder(@NonNull PokemanListViewHolder holder, int position) {
        // TODO: Step 2-5: Bind data items to Fragments inside of ViewHolders
        TextView pokemanFragmentNameTextView = holder.itemView.findViewById(R.id.PokemonFragmentName);
        String pokemanName = pokemans.get(position).getName();
        pokemanFragmentNameTextView.setText(position + ". " + pokemanName);
        TextView pokemanFragTextViewType = holder.itemView.findViewById(R.id.PokemonFragmentType);
        String pokemanType = pokemans.get(position).getType();
        pokemanFragTextViewType.setText(pokemanType);

        //TODO: Step: 3-3 Make OnClickHandler so we can interact with the RecyclerView items
        View pokemanViewHolder = holder.itemView;
        pokemanViewHolder.setOnClickListener(view -> {
            Intent goToOrderForm = new Intent(callingActivity, OrderFormActivity.class);
            goToOrderForm.putExtra(PokemanActivity.POKEMAN_NAME_EXTRA_TAG, pokemanName);
            callingActivity.startActivity(goToOrderForm);
        });
    }

    @Override
    public int getItemCount() {
        // TODO: Step 1-10: For testing purposes, hardcode a large number of items
//        return 100;
        // TODO: Step 2-5: Make the size of the list dynamic
        return pokemans.size();
    }


    // TODO: Step 1-8: Make a ViewHolder class to hold a fragment
    public static class PokemanListViewHolder extends RecyclerView.ViewHolder{
        public PokemanListViewHolder(@NonNull View itemView) {
            super(itemView);
        }
    }
}
