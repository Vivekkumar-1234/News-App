package com.example.newsapp.ui.aljazeera;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;

import com.example.newsapp.R;
import com.example.newsapp.WebViewController;
import com.example.newsapp.databinding.FragmentGalleryBinding;

public class GalleryFragment extends Fragment {

    private FragmentGalleryBinding binding;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        GalleryViewModel galleryViewModel =
                new ViewModelProvider(this).get(GalleryViewModel.class);

        binding = FragmentGalleryBinding.inflate(inflater, container, false);
        View root = binding.getRoot();

        // webView ka findViewById() krege
        WebView webView = root.findViewById(R.id.webViewAljazeera);

        // Ab BBC ka URL dege :-
        webView.loadUrl("https://www.aljazeera.com/");

        // uske bad WebViewController.java jo class h usko HomeFragment.java m use karna h :-
        webView.setWebViewClient(new WebViewController());


        return root;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }
}