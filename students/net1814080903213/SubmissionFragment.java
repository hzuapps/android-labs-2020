package com.example.facewords_java;

import android.content.Intent;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;

import static android.content.ContentValues.TAG;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link SubmissionFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class SubmissionFragment extends Fragment implements View.OnClickListener {

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public SubmissionFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment SubmissionFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static SubmissionFragment newInstance(String param1, String param2) {
        SubmissionFragment fragment = new SubmissionFragment();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    Button submissionButton;
    EditText submissionContent;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        // 注册 submission_button
        submissionButton = requireView().findViewById(R.id.submission_button);
        submissionButton.setOnClickListener(this);
        // 注册 submission_content
        submissionContent = requireView().findViewById(R.id.submission_content);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_submission, container, false);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.submission_button:
                // Intent 传值至 SubmitResultActivity
                Intent intent = new Intent();
                intent.putExtra("submitUrl", "https://mecab-web-api.herokuapp.com/v1/parse?sentence=");
                intent.putExtra("paras", submissionContent.getText().toString());
                intent.setClass(getActivity(), SubmitResultActivity.class);
                getActivity().startActivity(intent);
                break;
            default:
                break;
        }
    }
}