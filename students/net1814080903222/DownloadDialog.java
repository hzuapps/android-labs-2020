package edu.hzuapps.androidlabs.net1814080903222.components;

import android.app.AlertDialog;
import android.app.Dialog;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.widget.EditText;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.DialogFragment;

import com.bumptech.glide.Glide;

import org.jetbrains.annotations.NotNull;

import java.util.Objects;

import edu.hzuapps.androidlabs.net1814080903222.R;
import edu.hzuapps.androidlabs.net1814080903222.databinding.DialogDownloadBinding;

public class DownloadDialog extends DialogFragment {
    private EditText urlInput;
    private ImageView imageView;

    @NonNull
    @NotNull
    @Override
    public Dialog onCreateDialog(@Nullable @org.jetbrains.annotations.Nullable Bundle savedInstanceState) {
        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());

        LayoutInflater inflater = requireActivity().getLayoutInflater();
        DialogDownloadBinding binding = DialogDownloadBinding.inflate(inflater, null, false);
        urlInput = binding.url;
        imageView = binding.image;

        binding.btn.setOnClickListener(view -> {
            Glide.with(this).load(urlInput.getText().toString()).into(imageView);
        });

        builder.setView(binding.getRoot())
                .setTitle(R.string.settings_download_button_text)
                .setNegativeButton(R.string.download_dialog_close,
                        (dialog, id) -> Objects.requireNonNull(DownloadDialog.this.getDialog()).cancel());
        return builder.create();
    }
}
