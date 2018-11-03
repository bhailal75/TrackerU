package com.example.himmat.trucktracking;

import android.content.Context;
import android.databinding.DataBindingUtil;
import android.support.annotation.NonNull;
import android.support.v4.app.FragmentActivity;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.himmat.trucktracking.databinding.RowHomeBinding;
import com.example.himmat.trucktracking.fragment.HomeFragment;
import com.example.himmat.trucktracking.model.HomeData;

import java.util.ArrayList;

public class HomeAdapter extends RecyclerView.Adapter<HomeAdapter.ViewHolder> {
    private RowHomeBinding mBinding;
    private Context context;
    private ArrayList<HomeData> arrayList;
    public HomeAdapter(FragmentActivity activity,ArrayList<HomeData> arrayList, HomeFragment homeFragment) {
        this.context = activity;
        this.arrayList = arrayList;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int i) {
        mBinding = DataBindingUtil.inflate(LayoutInflater.from(parent.getContext()), R.layout.row_home, parent, false);
        return new ViewHolder(mBinding, parent);

    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder viewHolder, int i) {
//        viewHolder.mBinding.rowHomeDetailImage
    }

    @Override
    public int getItemCount() {
        return arrayList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        private RowHomeBinding mBinding;
        public ViewHolder(RowHomeBinding mBinding, @NonNull View itemView) {
            super(mBinding.getRoot());
            this.mBinding = mBinding;
        }
    }
}
