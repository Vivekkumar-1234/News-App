package com.example.newsapp.ui.bbc;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebView;
import android.widget.Button;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;
import androidx.navigation.Navigation;

import com.example.newsapp.R;
import com.example.newsapp.WebViewController;
import com.example.newsapp.databinding.FragmentHomeBinding;

public class HomeFragment extends Fragment {

    private FragmentHomeBinding binding;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        HomeViewModel homeViewModel =
                new ViewModelProvider(this).get(HomeViewModel.class);

        binding = FragmentHomeBinding.inflate(inflater, container, false);
        View root = binding.getRoot();

        // webView ka findViewById() krege
        WebView webView = root.findViewById(R.id.webViewBBC);

        // Ab BBC ka URL dege :-
        webView.loadUrl("https://www.bbc.com/");

        // uske bad WebViewController.java jo class h usko HomeFragment.java m use karna h :-
        webView.setWebViewClient(new WebViewController());

        // Button lga rhe h Fragment m :-
        Button btn = root.findViewById(R.id.button);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Navigation.findNavController(view).navigate(R.id.action_nav_home_to_skyNewsFragment);
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