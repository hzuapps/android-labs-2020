package edu.hzuapps.androidlabs.net1814080903222.ui.home;

import android.content.ContentResolver;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.os.Bundle;
import android.os.ParcelFileDescriptor;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.RecyclerView;

import org.jetbrains.annotations.NotNull;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Objects;

import edu.hzuapps.androidlabs.net1814080903222.databinding.FolderListItemBinding;
import edu.hzuapps.androidlabs.net1814080903222.databinding.FragmentHomeBinding;

class FolderListAdapter extends RecyclerView.Adapter<FolderListAdapter.FolderItemHolder> {

    private final ContentResolver contentResolver;
    private final ArrayList<FolderItem> list;

    static class FolderItemHolder extends RecyclerView.ViewHolder {
        private final FolderListItemBinding binding;

        public FolderItemHolder(@NonNull @NotNull FolderListItemBinding binding) {
            super(binding.getRoot());
            this.binding = binding;
        }

        void setBinding(FolderItem item, Bitmap bitmap) {
            binding.setItem(item);
            binding.executePendingBindings();
            if (bitmap != null) {
                binding.pic.setImageBitmap(bitmap);
            }
        }
    }

    public FolderListAdapter(ArrayList<FolderItem> list, ContentResolver resolver) {
        super();
        this.list = list;
        contentResolver = resolver;
    }

    @NonNull
    @NotNull
    @Override
    public FolderItemHolder onCreateViewHolder(@NonNull @NotNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        FolderListItemBinding binding = FolderListItemBinding.inflate(inflater, parent, false);
        return new FolderItemHolder(binding);
    }

    @Override
    public void onBindViewHolder(@NonNull @NotNull FolderItemHolder holder, int position) {
        FolderItem item = list.get(position);
        try {
            File file = new File(item.getPicturePath());
            Uri uri = Uri.fromFile(file);
            ParcelFileDescriptor fd = contentResolver.openFileDescriptor(uri, "r");
            Bitmap bitmap = BitmapFactory.decodeFileDescriptor(fd.getFileDescriptor());
            holder.setBinding(item, bitmap);
            fd.close();
        } catch (FileNotFoundException e) {
            Log.e("FLA:onBindViewHolder", Objects.requireNonNull(e.getLocalizedMessage()));
            holder.setBinding(item, null);
        } catch (IOException e) {
            Log.e("FLA:onBindViewHolder", Objects.requireNonNull(e.getLocalizedMessage()));
        }
    }

    @Override
    public int getItemCount() {
        return list != null ? list.size() : 0;
    }
}

public class HomeFragment extends Fragment {

    private FragmentHomeBinding binding;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        HomeViewModel homeViewModel = new ViewModelProvider(this).get(HomeViewModel.class);

        binding = FragmentHomeBinding.inflate(inflater, container, false);
        View root = binding.getRoot();

        final RecyclerView recyclerView = binding.folderList;
        homeViewModel.getText().observe(getViewLifecycleOwner(), s -> {
            FolderListAdapter adapter = new FolderListAdapter(s, requireActivity().getContentResolver());
            recyclerView.setAdapter(adapter);
        });

        ArrayList<FolderItem> demoList = new ArrayList<>(
                Arrays.asList(
                        new FolderItem("Test1", "/sdcard/Pictures/test.png"),
                        new FolderItem("Test2", "/sdcard/Pictures/test2.png"),
                        new FolderItem("foo3", "/sdcard/Pictures/test3.png"),
                        new FolderItem("bee4", "/sdcard/Pictures/test4.png"))
        );
        homeViewModel.setList(demoList);
        return root;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }
}