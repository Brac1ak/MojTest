package com.example.marcin.mojtest;

import android.content.Context;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.v4.app.Fragment;
import android.support.v4.content.ContextCompat;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.ProgressBar;

import com.squareup.picasso.Callback;
import com.squareup.picasso.Picasso;

public class ImageFragmentPagerAdapter extends Fragment implements Callback, View.OnClickListener {

    ImageView imageView;
    ProgressBar progressBar;
    FloatingActionButton floatingActionButton;
    FavoriteImages favoriteImages;

    Context context;
    String imageURL;
    boolean downloadImage = false;

    private static final String IMAGE_URL_500 = "http://image.tmdb.org/t/p/w500/";
    public static final String SEND_IMAGE_URL = "imageURL";

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        this.context = context;
    }

    public ImageFragmentPagerAdapter(){

    }

    public static ImageFragmentPagerAdapter newInstance(int position, ImageData imageURL){

        ImageFragmentPagerAdapter imageFragment = new ImageFragmentPagerAdapter();
        Bundle bundle = new Bundle();
        bundle.putString(SEND_IMAGE_URL, imageURL.results.get(position).poster_path);
        imageFragment.setArguments(bundle);

        return imageFragment;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.image_fragment_pager_adapter, container, false);

        Bundle argument = getArguments();

        imageView = (ImageView) view.findViewById(R.id.image_view_image_fragment_pager_adapter);
        progressBar = (ProgressBar) view.findViewById(R.id.progress_bar_image_fragment_pager_adapter);
        floatingActionButton = (FloatingActionButton) view.findViewById(R.id.floating_action_button_image_fragment_pager_adapter);
        imageURL = argument.getString(SEND_IMAGE_URL);

        favoriteImages = new FavoriteImages(context);
        floatingActionButton.setOnClickListener(this);
        Picasso.with(context).load(IMAGE_URL_500 + imageURL).into(imageView, this);
        setVisibleProgressBar();
        checkIfMovieIsAddToFavorite();

        return view;
    }

    private void setVisibleProgressBar(){
        if(downloadImage){
            progressBar.setVisibility(View.GONE);
            imageView.setVisibility(View.VISIBLE);
            floatingActionButton.setVisibility(View.VISIBLE);
        }else {
            progressBar.setVisibility(View.VISIBLE);
            imageView.setVisibility(View.GONE);
            floatingActionButton.setVisibility(View.GONE);
        }
    }

    @Override
    public void onSuccess() {
        downloadImage = true;
        setVisibleProgressBar();
    }

    @Override
    public void onError() {

    }

    @Override
    public void onClick(View v) {
        insertOrDeleteMovie();
        checkIfMovieIsAddToFavorite();
    }

    private void checkIfMovieIsAddToFavorite(){

        if (favoriteImages.checkTheMovieIsAdded(imageURL)){
            floatingActionButton.setImageDrawable(ContextCompat.getDrawable(context, R.drawable.heart_white));
        } else {
            floatingActionButton.setImageDrawable(ContextCompat.getDrawable(context, R.drawable.heart_outline));
        }

    }

    private void insertOrDeleteMovie(){

        if (!favoriteImages.checkTheMovieIsAdded(imageURL)) {
            favoriteImages.insertImageURL(new Result(imageURL));
        } else {
            favoriteImages.deleteRow(imageURL);
        }
    }
}
