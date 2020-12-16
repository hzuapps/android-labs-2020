package edu.hzuapps.androidlabs.net1814080903211.ui.home;

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
import edu.hzuapps.androidlabs.net1814080903211.databinding.FragmentHomeBinding;
import edu.hzuapps.androidlabs.net1814080903211.components.ChatObject;
import edu.hzuapps.androidlabs.net1814080903211.databinding.ChatListItemBinding;


class ChatListAdapter extends RecyclerView.Adapter<ChatListAdapter.ChatListItemHolder> {
    private final ArrayList<ChatObject> objectList;

    public ChatListAdapter(ArrayList<ChatObject> list) {
        super();
        objectList = list;
    }

    static class ChatListItemHolder extends RecyclerView.ViewHolder {
        private final ChatListItemBinding binding;

        public ChatListItemHolder(@NonNull @NotNull ChatListItemBinding binding) {
            super(binding.getRoot());

            this.binding = binding;
        }

        public void setBinding(ChatObject object) {
            binding.setObject(object);
            binding.executePendingBindings();
        }
    }

    @NonNull
    @NotNull
    @Override
    public ChatListItemHolder onCreateViewHolder(@NonNull @NotNull ViewGroup viewGroup, int i) {
        LayoutInflater inflater = LayoutInflater.from(viewGroup.getContext());
        ChatListItemBinding binding = ChatListItemBinding.inflate(inflater, viewGroup, false);
        return new ChatListItemHolder(binding);
    }

    @Override
    public void onBindViewHolder(@NonNull @NotNull ChatListItemHolder chatListItemHolder, int i) {
        chatListItemHolder.setBinding(objectList.get(i));
    }

    @Override
    public int getItemCount() {
        return objectList.size();
    }
}

public class HomeFragment extends Fragment {

    private FragmentHomeBinding binding;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        HomeViewModel homeViewModel = new ViewModelProvider(this).get(HomeViewModel.class);

        binding = FragmentHomeBinding.inflate(inflater, container, false);
        View root = binding.getRoot();

        RecyclerView recyclerView = binding.chatList;
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(getActivity());
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.addItemDecoration(new ListSeparator());

        homeViewModel.getChatObjects().observe(getViewLifecycleOwner(),
                new Observer<ArrayList<ChatObject>>() {
                    @Override
                    public void onChanged(@Nullable ArrayList<ChatObject> s) {
                        ChatListAdapter adapter = new ChatListAdapter(s);
                        recyclerView.setAdapter(adapter);
                    }
                });
        return root;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }
}