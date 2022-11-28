package com.jellysoft.vegi.activites;

import android.os.Bundle;
import android.view.View;

import androidx.databinding.DataBindingUtil;

import com.google.android.material.bottomsheet.BottomSheetDialog;
import com.jellysoft.vegi.R;
import com.jellysoft.vegi.adapters.TickitPagerAdapter;
import com.jellysoft.vegi.databinding.ActivityComplainBinding;
import com.jellysoft.vegi.databinding.BottomsheetHaveAnIssueBinding;

import io.reactivex.disposables.CompositeDisposable;

public class ComplainActivity extends BaseActivity {
    ActivityComplainBinding binding;
    private BottomSheetDialog bottomSheetDialog;
    CompositeDisposable disposable = new CompositeDisposable();
    BottomsheetHaveAnIssueBinding bottomsheetHaveAnIssueBinding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = DataBindingUtil.setContentView(this, R.layout.activity_complain);


        initView();
    }

    private void initView() {
        binding.tablayout.removeAllTabs();
        binding.tablayout.addTab(binding.tablayout.newTab().setText("Open"));
        binding.tablayout.addTab(binding.tablayout.newTab().setText("Resolved"));
        binding.tablayout.setupWithViewPager(binding.viewpager);
        TickitPagerAdapter tickitPagerAdapter = new TickitPagerAdapter(getSupportFragmentManager());
        binding.viewpager.setAdapter(tickitPagerAdapter);
        binding.viewpager.setVisibility(View.VISIBLE);

    }


    public void onClickBack(View view) {
        onBackPressed();
    }

}