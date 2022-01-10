package com.pucmm.csti.ui.cart;

import android.util.Pair;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.Transformations;
import androidx.lifecycle.ViewModel;

import com.pucmm.csti.model.Product;
import com.pucmm.csti.utils.UserSession;

import java.util.List;

public class CartViewModel extends ViewModel {
    private MutableLiveData<List<Pair<Product,Integer>>> listLiveData;

    public CartViewModel(UserSession session) {
        if (listLiveData == null) {
            listLiveData = new MutableLiveData<List<Pair<Product,Integer>>>();
        }
        listLiveData.setValue(session.getCartList());
    }

    public MutableLiveData<List<Pair<Product,Integer>>> getListLiveData() { return listLiveData; }

    public void setListLiveData(List<Pair<Product,Integer>> updatedData) {
        listLiveData.setValue(updatedData);
    }
}
