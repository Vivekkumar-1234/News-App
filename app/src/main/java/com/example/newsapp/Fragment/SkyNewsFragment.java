package com.example.newsapp.Fragment;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebView;

import com.example.newsapp.R;
import com.example.newsapp.WebViewController;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link SkyNewsFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class SkyNewsFragment extends Fragment {

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public SkyNewsFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment SkyNewsFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static SkyNewsFragment newInstance(String param1, String param2) {
        SkyNewsFragment fragment = new SkyNewsFragment();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_sky_news, container, false);

        // webView ka findViewById() krege
        WebView webView = view.findViewById(R.id.webViewSky);

        // Ab BBC ka URL dege :-
        webView.loadUrl("https://news.sky.com/");

        // uske bad WebViewController.java jo class h usko HomeFragment.java m use karna h :-
        webView.setWebViewClient(new WebViewController());

        return view;
    }
}