package edu.hzuapps.androidlabs.net1814080903222.ui.browser;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;

import edu.hzuapps.androidlabs.net1814080903222.components.ListDecorator;
import edu.hzuapps.androidlabs.net1814080903222.databinding.BrowserItemBinding;
import edu.hzuapps.androidlabs.net1814080903222.databinding.FragmentBrowserBinding;

class BrowseItemAdapter extends RecyclerView.Adapter<BrowseItemAdapter.BrowseItemHolder> {

    private ArrayList<BrowseItem> list;

    public BrowseItemAdapter(ArrayList<BrowseItem> list) {
        super();
        this.list = list;
    }

    static class BrowseItemHolder extends RecyclerView.ViewHolder {
        private final BrowserItemBinding binding;

        public BrowseItemHolder(@NonNull @NotNull BrowserItemBinding binding) {
            super(binding.getRoot());
            this.binding = binding;
        }

        void bind(BrowseItem item) {
            binding.setItem(item);
            binding.executePendingBindings();
        }
    }

    @NonNull
    @NotNull
    @Override
    public BrowseItemHolder onCreateViewHolder(@NonNull @NotNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        BrowserItemBinding binding = BrowserItemBinding.inflate(inflater, parent, false);
        return new BrowseItemHolder(binding);
    }

    @Override
    public void onBindViewHolder(@NonNull @NotNull BrowseItemHolder holder, int position) {
        holder.bind(list.get(position));
    }

    @Override
    public int getItemCount() {
        return list != null ? list.size() : 0;
    }
}


public class BrowserFragment extends Fragment {

    private BrowserViewModel dashboardViewModel;
    private FragmentBrowserBinding binding;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        dashboardViewModel =
                new ViewModelProvider(this).get(BrowserViewModel.class);

        binding = FragmentBrowserBinding.inflate(inflater, container, false);
        View root = binding.getRoot();

        RecyclerView recyclerView = binding.browseList;
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
        recyclerView.addItemDecoration(new ListDecorator(8));
        dashboardViewModel.getList().observe(getViewLifecycleOwner(),
                newList -> {
                    BrowseItemAdapter adapter = new BrowseItemAdapter(newList);
                    recyclerView.setAdapter(adapter);
                });
        return root;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }
}