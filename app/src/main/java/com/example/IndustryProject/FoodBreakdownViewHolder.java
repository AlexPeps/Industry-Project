package com.example.IndustryProject;

import android.content.Intent;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import com.example.IndustryProject.db.entities.FoodItems;
import com.example.IndustryProject.db.entities.User;
import com.example.IndustryProject.utils.Constant;

class FoodBreakdownViewHolder extends RecyclerView.ViewHolder {

    User user;
    FoodItems foodItems;
    ImageView image;
    TextView Name, Calories, ID;
    CardView cardView;
    Button button;



    public FoodBreakdownViewHolder(@NonNull final View itemView)
    {


        super(itemView);
        Name = itemView.findViewById(R.id.user_item_card_list_name);
        Calories = itemView.findViewById(R.id.user_item_card_list_ID);
        ID = itemView.findViewById(R.id.user_item_card_list_caloriesActual);

        cardView = itemView.findViewById(R.id.user_item_card);

        button = (Button) itemView.findViewById(R.id.button_display);



        cardView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(
                        itemView.getContext(),
                        "Card has been clicked",
                        Toast.LENGTH_LONG
                ).show();
                Intent intent = new Intent(itemView.getContext(), UserInformationActivity.class);
                intent.putExtra(Constant.USER_OBJECT, user);
                itemView.getContext().startActivity(intent);
            }
        });

    }
}
