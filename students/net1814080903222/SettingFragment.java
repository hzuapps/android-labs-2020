package edu.hzuapps.androidlabs.net1814080903222.ui.setting;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.RecyclerView;

import org.jetbrains.annotations.NotNull;

import java.util.List;

import edu.hzuapps.androidlabs.net1814080903222.components.DownloadDialog;
import edu.hzuapps.androidlabs.net1814080903222.components.ListDecorator;
import edu.hzuapps.androidlabs.net1814080903222.components.storage.ExcludeItem;
import edu.hzuapps.androidlabs.net1814080903222.databinding.ExcludeListItemBinding;
import edu.hzuapps.androidlabs.net1814080903222.databinding.FragmentSettingBinding;

class ExcludeListAdapter extends RecyclerView.Adapter<ExcludeListAdapter.ExcludeItemHolder> {

    private final List<ExcludeItem> excludeList;

    static class ExcludeItemHolder extends RecyclerView.ViewHolder {

        private final ExcludeListItemBinding binding;

        public ExcludeItemHolder(@NonNull @NotNull ExcludeListItemBinding binding) {
            super(binding.getRoot());
            this.binding = binding;
        }

        void setItem(ExcludeItem item) {
            binding.setItem(item);
            binding.executePendingBindings();
        }
    }

    public ExcludeListAdapter(List<ExcludeItem> excludeList) {
        this.excludeList = excludeList;
    }

    @NonNull
    @NotNull
    @Override
    public ExcludeItemHolder onCreateViewHolder(@NonNull @NotNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        ExcludeListItemBinding binding = ExcludeListItemBinding.inflate(inflater, parent, false);
        return new ExcludeItemHolder(binding);
    }

    @Override
    public void onBindViewHolder(@NonNull @NotNull ExcludeItemHolder holder, int position) {
        holder.setItem(excludeList.get(position));
    }

    @Override
    public int getItemCount() {
        return excludeList != null ? excludeList.size() : 0;
    }
}

public class SettingFragment extends Fragment {

    private FragmentSettingBinding binding;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        SettingViewModel notificationsViewModel = new ViewModelProvider(this).get(SettingViewModel.class);

        binding = FragmentSettingBinding.inflate(inflater, container, false);
        View root = binding.getRoot();

        RecyclerView recyclerView = binding.excludeList;
        recyclerView.addItemDecoration(new ListDecorator(12));
        notificationsViewModel.getExcludeList().observe(getViewLifecycleOwner(),
                newList -> {
                    ExcludeListAdapter adapter = new ExcludeListAdapter(newList);
                    recyclerView.setAdapter(adapter);
                });

        binding.downloadBtn.setOnClickListener(this::showDownloadDialog);
        return root;
    }

    public void showDownloadDialog(View v) {
        DownloadDialog dialog = new DownloadDialog();
        dialog.show(getParentFragmentManager(), "DOWNLOAD");
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }
}