
package com.zork.zork_demo.adapter;


import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.amplifyframework.datastore.generated.model.SuperFurBoy;
import com.zork.zork_demo.R;
import com.zork.zork_demo.activities.OrderFormActivity;
import com.zork.zork_demo.activities.SuperFurBoyActivity;


import java.util.List;
public class SuperFurBoyListRecyclerViewAdapter extends RecyclerView.Adapter<SuperFurBoyListRecyclerViewAdapter.SuperFurBoyListViewHolder> {

    List<SuperFurBoy> superFurBoys;
    Context callingActivity;

    public SuperFurBoyListRecyclerViewAdapter(List<SuperFurBoy> superFurBoys, Context callingActivity) {
        this.superFurBoys = superFurBoys;
        this.callingActivity = callingActivity;
    }

    @NonNull
    @Override
    public SuperFurBoyListViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View superFurBoyFragment = LayoutInflater.from(parent.getContext()).inflate(R.layout.fragment_super_fur_boy, parent, false);
        return new SuperFurBoyListViewHolder(superFurBoyFragment);
    }

    @Override
    public void onBindViewHolder(@NonNull SuperFurBoyListViewHolder holder, int position) {
        TextView SFBFragmentNameTextView = holder.itemView.findViewById(R.id.SuperFurBoyFragmentNameTV);
        String superFurBoyName = superFurBoys.get(position).getName();
        SFBFragmentNameTextView.setText(position + ". " + superFurBoyName);
        TextView SFBFragTextViewType = holder.itemView.findViewById(R.id.SuperFurBoyFragmentTypeTV);
        String superFurBoyType = superFurBoys.get(position).getType().toString();
        SFBFragTextViewType.setText(superFurBoyType);

        View superFurBoyViewHolder = holder.itemView;
        superFurBoyViewHolder.setOnClickListener(view -> {
            Intent goToOrderForm = new Intent(callingActivity, OrderFormActivity.class);
            goToOrderForm.putExtra(SuperFurBoyActivity.SUPER_FUR_BOY_NAME_EXTRA_TAG, superFurBoyName);
            callingActivity.startActivity(goToOrderForm);
        });
    }

    @Override
    public int getItemCount() {
        return superFurBoys.size();
    }

    public static class SuperFurBoyListViewHolder extends RecyclerView.ViewHolder{
        public SuperFurBoyListViewHolder(@NonNull View itemView) {
            super(itemView);
        }
    }
}
