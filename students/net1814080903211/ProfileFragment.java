package edu.hzuapps.androidlabs.net1814080903211.ui.profile;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;

import java.util.ArrayList;
import java.util.EventListener;
import java.util.List;

import edu.hzuapps.androidlabs.net1814080903211.R;
import edu.hzuapps.androidlabs.net1814080903211.databinding.FragmentProfileBinding;

public class ProfileFragment extends Fragment {

    private FragmentProfileBinding binding;
    private SharedPreferences sharedPreferences;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        ProfileViewModel profileViewModel = new ViewModelProvider(this).get(ProfileViewModel.class);

        binding = FragmentProfileBinding.inflate(inflater, container, false);
        View root = binding.getRoot();

        sharedPreferences = requireContext().getSharedPreferences(
                getString(R.string.preference_profile_key), Context.MODE_PRIVATE
        );

        Spinner sex_spinner = binding.sexualSpinner;
        // Create an ArrayAdapter using the string array and a default spinner layout
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(root.getContext(),
                R.array.profile_sexual_selections, android.R.layout.simple_spinner_item);
        // Specify the layout to use when the list of choices appears
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        // Apply the adapter to the spinner
        sex_spinner.setAdapter(adapter);

        Spinner age_spinner = binding.ageSpinner;
        ArrayList<Integer> ages = new ArrayList<>();
        for (int i = 1; i < 101; i++) {
            ages.add(i);
        }
        ArrayAdapter<Integer> age_adapter = new ArrayAdapter<>(root.getContext(),
                android.R.layout.simple_spinner_item, ages);
        age_adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        age_spinner.setAdapter(age_adapter);

        recoverProfile();
        binding.submitBtn.setOnClickListener(saveProfile);
        return root;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }

    View.OnClickListener saveProfile = view -> {
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putString(
                getString(R.string.profile_pref_name_key),
                binding.profileId.getText().toString()
        );
        editor.putInt(
                getString(R.string.profile_pref_sex_key),
                binding.sexualSpinner.getSelectedItemPosition()
        );
        editor.putInt(
                getString(R.string.profile_pref_age_key),
                binding.ageSpinner.getSelectedItemPosition()
        );
        editor.putString(
                getString(R.string.profile_pref_intro_key),
                binding.introText.getText().toString()
        );
        editor.apply();
    };

    void recoverProfile() {
        binding.profileId.setText(sharedPreferences.getString(
                getString(R.string.profile_pref_name_key), "Anonymous")
        );
        binding.sexualSpinner.setSelection(sharedPreferences.getInt(
                getString(R.string.profile_pref_sex_key), 2
        ));
        binding.ageSpinner.setSelection(sharedPreferences.getInt(
                getString(R.string.profile_pref_age_key), 19
        ));
        binding.introText.setText(sharedPreferences.getString(
                getString(R.string.profile_pref_intro_key), "I am new here."
        ));
    }
}