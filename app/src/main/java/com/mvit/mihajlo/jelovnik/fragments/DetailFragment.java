package com.mvit.mihajlo.jelovnik.fragments;

import android.app.Fragment;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.RatingBar;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;
import com.mvit.mihajlo.jelovnik.R;
import com.mvit.mihajlo.jelovnik.providers.CategoryProvider;
import com.mvit.mihajlo.jelovnik.providers.FoodProvider;
import java.io.IOException;
import java.io.InputStream;
import java.util.List;

/**
 * Created by Mihajlo on 16-May-17.
 */

public class DetailFragment extends Fragment {

    // Position of the item to be displayed in the detail fragment
    private int position = 0;

    // onCreate method is a life-cycle method that is called when creating the fragment.
    @Override
    public void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);

    }

    // onActivityCreated method is a life-cycle method that is called when the fragment's activity has been created and this fragment's view hierarchy instantiated.
    @Override
    public void onActivityCreated(Bundle savedInstanceState) {

        super.onActivityCreated(savedInstanceState);

        if (savedInstanceState != null) {
            position = savedInstanceState.getInt("position", 0);
        }

        // Finds "ivImage" ImageView and sets "imageDrawable" property
        ImageView ivImage = (ImageView) getView().findViewById(R.id.iv_image);
        InputStream is = null;
        try {
            is = getActivity().getAssets().open(FoodProvider.getFoodById(position).getImage());
            Drawable drawable = Drawable.createFromStream(is, null);
            ivImage.setImageDrawable(drawable);
        } catch (IOException e) {
            e.printStackTrace();
        }

        // Finds "tvName" TextView and sets "text" property
        TextView tvName = (TextView) getView().findViewById(R.id.tv_name);
        tvName.setText(FoodProvider.getFoodById(position).getName());

        // Finds "tvDescription" TextView and sets "text" property
        TextView tvDescription = (TextView) getView().findViewById(R.id.tv_description);
        tvDescription.setText(FoodProvider.getFoodById(position).getDescription());

        // Finds "spCategory" Spiner and sets "selection" property
        Spinner category = (Spinner) getView().findViewById(R.id.sp_category);
        List<String> categories = CategoryProvider.getCategoryNames();
        ArrayAdapter<String> adapter = new ArrayAdapter(getActivity(), android.R.layout.simple_spinner_item, categories);
        category.setAdapter(adapter);
        category.setSelection((int)FoodProvider.getFoodById(position).getCategory().getId());

        // Finds "rbRating" RatingBar and sets "rating" property
        RatingBar rbRating = (RatingBar) getView().findViewById(R.id.rb_rating);
        rbRating.setRating(FoodProvider.getFoodById(position).getRating());

        // Finds "btnBuy" Button and sets "onClickListener" listener
        Button btnBuy = (Button) getView().findViewById(R.id.btn_buy);
        btnBuy.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast toast = Toast.makeText(v.getContext(), "You've bought " + FoodProvider.getFoodById(position).getName() + "!", Toast.LENGTH_LONG);
                toast.show();
            }
        });
    }
    // onCreateView method is a life-cycle method that is called  to have the fragment instantiate its user interface view.
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        // Finds view in the view hierarchy and returns it.
        View view = inflater.inflate(R.layout.fragment_detail, container, false);
        return view;
    }

    // Called to set fragment's content.
    public void setContent(final int position) {
        this.position = position;
        Log.v("DetailFragment", "setContent() sets position to " + position);
    }

    // Called to update fragment's content.
    public void updateContent(final int position) {
        this.position = position;
        Log.v("DetailFragment", "updateContent() sets position to " + position);

        // Finds "ivImage" ImageView and sets "imageDrawable" property
        ImageView ivImage = (ImageView) getView().findViewById(R.id.iv_image);
        InputStream is = null;
        try {
            is = getActivity().getAssets().open(FoodProvider.getFoodById(position).getImage());
            Drawable drawable = Drawable.createFromStream(is, null);
            ivImage.setImageDrawable(drawable);
        } catch (IOException e) {
            e.printStackTrace();
        }

        // Finds "tvName" TextView and sets "text" property
        TextView tvName = (TextView) getView().findViewById(R.id.tv_name);
        tvName.setText(FoodProvider.getFoodById(position).getName());

        // Finds "tvDescription" TextView and sets "text" property
        TextView tvDescription = (TextView) getView().findViewById(R.id.tv_description);
        tvDescription.setText(FoodProvider.getFoodById(position).getDescription());

        // Finds "spCategory" Spiner and sets "selection" property
        Spinner category = (Spinner) getView().findViewById(R.id.sp_category);
        List<String> categories = CategoryProvider.getCategoryNames();
        ArrayAdapter<String> adapter = new ArrayAdapter(getActivity(), android.R.layout.simple_spinner_item, categories);
        category.setAdapter(adapter);
        category.setSelection((int)FoodProvider.getFoodById(position).getCategory().getId());

        // Finds "rbRating" RatingBar and sets "rating" property
        RatingBar rbRating = (RatingBar) getView().findViewById(R.id.rb_rating);
        rbRating.setRating(FoodProvider.getFoodById(position).getRating());

        // Finds "btnBuy" Button and sets "onClickListener" listener
        Button btnBuy = (Button) getView().findViewById(R.id.btn_buy);
        btnBuy.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast toast = Toast.makeText(v.getContext(), "You've bought " + FoodProvider.getFoodById(position).getName() + "!", Toast.LENGTH_LONG);
                toast.show();
            }
        });
    }







}
