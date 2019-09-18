package in.geekofia.nearbyplaces.fragments;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.SeekBar;
import android.widget.Spinner;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import in.geekofia.nearbyplaces.R;
import com.google.android.material.button.MaterialButton;
import com.google.android.material.textfield.TextInputEditText;
import com.google.android.material.textfield.TextInputLayout;


public class HomeFragment extends Fragment implements View.OnClickListener {

    private TextInputLayout mSearchLayout;
    private TextInputEditText mSearchEditText;
    private MaterialButton mButtonSearch;
    private Spinner mTypesSpinner;
    private SeekBar mRadiusSeekBar;
    private TextView mTextViewRadius;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.frag_home, container, false);

        initViews(v);

        return v;
    }


    private void initViews(View view) {
        // From Base Spinner
        mTypesSpinner = view.getRootView().findViewById(R.id.spinner_types);
        ArrayAdapter<CharSequence> mFromAdapter = ArrayAdapter.createFromResource(getActivity(),
                R.array.array_types, android.R.layout.simple_spinner_item);
        mFromAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

        mTypesSpinner.setAdapter(mFromAdapter);

        mSearchLayout = view.getRootView().findViewById(R.id.search_layout);
        mSearchEditText = view.getRootView().findViewById(R.id.search_edit_text);

        mTextViewRadius = view.getRootView().findViewById(R.id.textview_radius);

        mRadiusSeekBar = view.getRootView().findViewById(R.id.seekbar_radius);
        mRadiusSeekBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                String radius = progress + " meters";
                mTextViewRadius.setText(radius);
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });

        mButtonSearch = view.getRootView().findViewById(R.id.button_search);
        mButtonSearch.setOnClickListener(this);
    }


    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.button_search:

                String name = mSearchEditText.getText().toString();
                String types = mTypesSpinner.getSelectedItem().toString();
                int radius = mRadiusSeekBar.getProgress();

                NearbyPlacesFragment nearbyPlacesFragment = new NearbyPlacesFragment();
                Bundle bundle = new Bundle();
                bundle.putString("name", name);
                bundle.putString("types", types);
                bundle.putInt("radius", radius);
                nearbyPlacesFragment.setArguments(bundle);
                getActivity().getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container, nearbyPlacesFragment).addToBackStack("nearby_places").commit();
                break;
        }
    }
}
