package ru.alekstereh.task_notes.ui;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentResultListener;

import ru.alekstereh.task_notes.R;
import ru.alekstereh.task_notes.domain.City;

public class CityDetailsFragment extends Fragment {

    private static final String ARG_CITY = "ARG_CITY";

    public static CityDetailsFragment newInstance(City city) {

        Bundle args = new Bundle();
        args.putParcelable(ARG_CITY, city);

        CityDetailsFragment fragment = new CityDetailsFragment();
        fragment.setArguments(args);
        return fragment;
    }

    public CityDetailsFragment() {
        super(R.layout.fragment_city_details);
    }

    private TextView title;
    private ImageView icon;

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        title = view.findViewById(R.id.title);
        icon = view.findViewById(R.id.icon);



        getParentFragmentManager()
                .setFragmentResultListener(CitiesListFragment.CITIES_CLICKED_KEY, getViewLifecycleOwner(), new FragmentResultListener() {
                    @Override
                    public void onFragmentResult(@NonNull String requestKey, @NonNull Bundle result) {
                        City city = result.getParcelable(CitiesListFragment.SELECTED_CITY);

                        showCity(city);
                    }
                });

        if (getArguments() != null && getArguments().containsKey(ARG_CITY)){
            City city = getArguments().getParcelable(ARG_CITY);
            showCity(city);
        }

    }

    private void showCity(City city){
        title.setText(city.getName());
        icon.setImageResource(city.getIcon());
    }
}
