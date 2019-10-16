package com.example.sub4movieandtv.fragment;


import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;


import com.example.sub4movieandtv.R;
import com.example.sub4movieandtv.roomdb.MoviesViewModel;
import com.example.sub4movieandtv.roommovies.Movies;
import com.example.sub4movieandtv.roommovies.MoviesAdapter;

import java.util.ArrayList;
import java.util.List;

/**
 * A simple {@link Fragment} subclass.
 */
public class FavMoviesFragment extends Fragment {
    private static final String TAG = FavMoviesFragment.class.getSimpleName();
    private RecyclerView recyclerViewMovie;
    private MoviesAdapter moviesAdapter;
    private MoviesViewModel moviesViewModel;

    public FavMoviesFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_fav_movies, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        recyclerViewMovie = view.findViewById(R.id.rv_tab_movies_room);
        recyclerViewMovie.setLayoutManager(new LinearLayoutManager(getContext()));
        callDataViewModel();
    }

    private void callDataViewModel() {
        moviesViewModel = ViewModelProviders.of(this).get(MoviesViewModel.class);
        moviesViewModel.getMoviesList().observe(this, new Observer<List<Movies>>() {
            @Override
            public void onChanged(List<Movies> movies) {
                moviesAdapter = new MoviesAdapter(getContext(), (ArrayList<Movies>) movies);
                moviesAdapter.setMoviesList((ArrayList<Movies>) movies);
                recyclerViewMovie.setAdapter(moviesAdapter);

            }
        });
    }

}
