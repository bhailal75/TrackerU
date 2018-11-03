package com.example.himmat.trucktracking.fragment;

import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.LinearLayoutManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.himmat.trucktracking.HomeAdapter;
import com.example.himmat.trucktracking.R;
import com.example.himmat.trucktracking.TruckApp;
import com.example.himmat.trucktracking.baseclass.BaseFragment;
import com.example.himmat.trucktracking.databinding.FragmentHomeBinding;
import com.example.himmat.trucktracking.model.HomeData;
import com.example.himmat.trucktracking.model.HomeResponse;
import com.example.himmat.trucktracking.retrofit.APICall;
import com.example.himmat.trucktracking.retrofit.APICallback;
import com.example.himmat.trucktracking.retrofit.OnApiResponseListner;
import com.example.himmat.trucktracking.utility.Utility;

import java.util.ArrayList;

import butterknife.ButterKnife;
import retrofit2.Call;

public class HomeFragment extends BaseFragment implements OnApiResponseListner, SwipeRefreshLayout.OnRefreshListener {

    private LinearLayoutManager linearLayoutManager;
    private HomeAdapter homeAdapter;
    private FragmentHomeBinding mBinding;
    private Call<?> callHome;
    private ArrayList<HomeData> homeArrayList;
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        mBinding = DataBindingUtil.inflate(inflater, R.layout.fragment_home, container, false);
        ButterKnife.bind(this,mBinding.getRoot());


        homeArrayList = new ArrayList<>();
        if (Utility.haveNetworkConnection(getActivity())) {
            mBinding.rvHome.setVisibility(View.GONE);
            mBinding.rvHome.setVisibility(View.VISIBLE);
            callHome = ((TruckApp) getActivity().getApplication()).getApiTask().home(new APICallback(getActivity(),
                    APICall.HOME, this));
        } else {
            Utility.showRedSnackBar(mBinding.getRoot(), getString(R.string.no_internet_connection));
        }
        mBinding.swipeContainer.setColorSchemeResources(android.R.color.holo_blue_bright,
                android.R.color.holo_green_light,
                android.R.color.holo_orange_light,
                android.R.color.holo_red_light);

        mBinding.swipeContainer.setOnRefreshListener(this);
        return mBinding.getRoot();
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        linearLayoutManager = new LinearLayoutManager(getActivity(), LinearLayoutManager.VERTICAL, false);
        mBinding.rvHome.setLayoutManager(linearLayoutManager);
        homeAdapter = new HomeAdapter(getActivity(), this);
        mBinding.rvHome.setAdapter(homeAdapter);
    }

    @Override
    public void onResponseComplete(Object clsGson, int requestCode) {
        if (requestCode == APICall.HOME) {
            if (clsGson instanceof HomeResponse) {
                HomeResponse homeResponse = (HomeResponse) clsGson;
                mBinding.swipeContainer.setRefreshing(false);
                homeArrayList.addAll(homeResponse.getData());
                homeAdapter.notifyDataSetChanged();
            }
            if (homeArrayList.size() == 0){

            }
//                mBinding.tvNoDataFound.setVisibility(View.VISIBLE);
        }
    }

    @Override
    public void onResponseError(Object errorMessage, int requestCode) {
//        dismissDialog();
        mBinding.rvHome.setVisibility(View.GONE);
        mBinding.swipeContainer.setRefreshing(false);

    }

    @Override
    public void onRefresh() {
        if (Utility.haveNetworkConnection(getActivity())) {
          //  callLogout = ((TruckApp) getActivity().getApplication()).getApiTask().home(new APICallback(getActivity(), APICall.HOME, this));
            callHome = ((TruckApp) getActivity().getApplication()).getApiTask().home(new APICallback(getActivity(),
                    APICall.HOME, this));
        } else {
            Utility.showRedSnackBar(mBinding.getRoot(), getString(R.string.no_internet_connection));
            mBinding.swipeContainer.setRefreshing(false);
        }
    }
}
