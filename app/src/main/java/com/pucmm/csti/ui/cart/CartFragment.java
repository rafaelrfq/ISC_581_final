package com.pucmm.csti.ui.cart;

import android.os.Bundle;
import android.util.Log;
import android.util.Pair;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.LinearLayoutManager;

import com.pucmm.csti.R;
import com.pucmm.csti.databinding.FragmentCartBinding;
import com.pucmm.csti.listener.OnItemTouchListener;
import com.pucmm.csti.model.Product;
import com.pucmm.csti.ui.ViewModelFactory;
import com.pucmm.csti.utils.UserSession;

import org.jetbrains.annotations.NotNull;

import java.util.List;

public class CartFragment extends Fragment {
    private FragmentCartBinding binding;
    private UserSession session;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        session = new UserSession(getContext());
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {

        binding = FragmentCartBinding.inflate(inflater, container, false);
        View root = binding.getRoot();

        return root;
    }

    @Override
    public void onViewCreated(@NonNull @NotNull View view, @Nullable @org.jetbrains.annotations.Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        setHasOptionsMenu(false);

        final CartAdaptor adapter = new CartAdaptor(session);
        binding.cartReciclerview.setAdapter(adapter);
        binding.cartReciclerview.setLayoutManager(new LinearLayoutManager(getContext()));
        binding.cartReciclerview.setHasFixedSize(true);
        binding.cartReciclerview.setItemAnimator(new DefaultItemAnimator());

        if (session.getCartList().size() > 0) {
            for(int ind=0; ind < session.getCartList().size(); ind++) {
                Log.e("Cart", "Item #" + (ind + 1) + " " + session.getCartList().get(ind).first.getItemName());
            }
        }

        CartViewModel cartViewModel = new ViewModelProvider(this, new ViewModelFactory(getContext())).get(CartViewModel.class);

        cartViewModel.getListLiveData().observe(getViewLifecycleOwner(), elements -> {
            final List<Pair<Product,Integer>> els = session.getCartList();
            adapter.setElements(els);
        });

        binding.deleteAllCart.setOnClickListener(v -> {
            session.clearCartList();
            cartViewModel.setListLiveData(session.getCartList());
        });
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }
}
