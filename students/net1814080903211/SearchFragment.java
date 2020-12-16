package edu.hzuapps.androidlabs.net1814080903211.ui.search;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;

import edu.hzuapps.androidlabs.net1814080903211.components.ListSeparator;
import edu.hzuapps.androidlabs.net1814080903211.components.SearchResult;
import edu.hzuapps.androidlabs.net1814080903211.databinding.FragmentSearchBinding;
import edu.hzuapps.androidlabs.net1814080903211.databinding.SearchResultItemBinding;


class SearchResultAdapter extends RecyclerView.Adapter<SearchResultAdapter.SearchResultHolder> {

    ArrayList<SearchResult> list;

    public SearchResultAdapter(ArrayList<SearchResult> list) {
        super();
        this.list = list;
    }

    static class SearchResultHolder extends RecyclerView.ViewHolder {
        private final SearchResultItemBinding binding;

        public SearchResultHolder(@NonNull @NotNull SearchResultItemBinding binding) {
            super(binding.getRoot());

            this.binding = binding;
        }

        public void setBinding(SearchResult result) {
            binding.setResult(result);
            binding.executePendingBindings();
        }
    }

    @NonNull
    @NotNull
    @Override
    public SearchResultHolder onCreateViewHolder(@NonNull @NotNull ViewGroup viewGroup, int i) {
        LayoutInflater inflater = LayoutInflater.from(viewGroup.getContext());
        SearchResultItemBinding binding = SearchResultItemBinding.inflate(inflater, viewGroup, false);
        return new SearchResultHolder(binding);
    }

    @Override
    public void onBindViewHolder(@NonNull @NotNull SearchResultHolder searchResultHolder, int i) {
        searchResultHolder.setBinding(list.get(i));
    }

    @Override
    public int getItemCount() {
        return list != null ? list.size() : 0;
    }
}

public class SearchFragment extends Fragment {

    private FragmentSearchBinding binding;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        SearchViewModel searchViewModel = new ViewModelProvider(this).get(SearchViewModel.class);

        binding = FragmentSearchBinding.inflate(inflater, container, false);
        View root = binding.getRoot();

        final RecyclerView recyclerView = binding.resultList;
        RecyclerView.LayoutManager layout = new LinearLayoutManager(getActivity());
        recyclerView.setLayoutManager(layout);
        recyclerView.addItemDecoration(new ListSeparator());

        searchViewModel.getResults().observe(getViewLifecycleOwner(),
                searchResults -> {
                    SearchResultAdapter adapter = new SearchResultAdapter(searchResults);
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