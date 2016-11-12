package com.sherlockshi.androidmvparchitecture.view.activity;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import com.sherlockshi.androidmvparchitecture.R;
import com.sherlockshi.androidmvparchitecture.business.cook_detail.CookDetailContract;
import com.sherlockshi.androidmvparchitecture.business.cook_detail.CookDetailPresenter;
import com.sherlockshi.androidmvparchitecture.business.entity.CookDetail;
import com.sherlockshi.androidmvparchitecture.global.Config;
import com.squareup.picasso.Picasso;

public class MainActivity extends AppCompatActivity implements CookDetailContract.IView {

    private CookDetailPresenter mCookDetailPresenter;

    private ProgressBar progressBar;

    private ImageView ivImage;
    private TextView tvName;

    private int id = 23;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initView();
    }

    @Override
    protected void onResume() {
        super.onResume();

        initData();
    }

    private void initView() {
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(MainActivity.this, "id: " + id, Toast.LENGTH_SHORT).show();
                mCookDetailPresenter.getCookDetail(Config.API_KEY, (id++) + "");
            }
        });

        progressBar = (ProgressBar) findViewById(R.id.progress_bar);

        ivImage = (ImageView) findViewById(R.id.iv_image);
        tvName = (TextView) findViewById(R.id.tv_name);
    }

    private void initData() {
        mCookDetailPresenter = new CookDetailPresenter(MainActivity.this, this);
        mCookDetailPresenter.getCookDetail(Config.API_KEY, (id++) + "");
    }

    @Override
    public void updateCookDetail(CookDetail cookDetail) {
        tvName.setText(cookDetail.getName());
        Picasso.with(this).load(Config.IMAGE_URL_PREFIX + cookDetail.getImg()).into(ivImage);
    }

    @Override
    public void showLoading() {
        progressBar.setVisibility(View.VISIBLE);
    }

    @Override
    public void hideLoading() {
        progressBar.setVisibility(View.GONE);
    }

    @Override
    public void showMessage(String msg) {
        Toast.makeText(this, msg, Toast.LENGTH_SHORT).show();
    }
}
