package com.pucmm.csti.ui.cart;

import android.util.Log;
import android.util.Pair;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.pucmm.csti.databinding.ItemCartBinding;
import com.pucmm.csti.listener.OnItemTouchListener;
import com.pucmm.csti.model.Product;
import com.pucmm.csti.utils.UserSession;

import org.jetbrains.annotations.NotNull;

import java.util.List;

public class CartAdaptor extends RecyclerView.Adapter<CartAdaptor.MyViewHolder> {
    private static final String TAG = "CartAdaptor";

    private UserSession session;
    private ItemCartBinding binding;
    private List<Pair<Product, Integer>> elements;

    public CartAdaptor(UserSession session) { this.session = session; }


    @NonNull
    @NotNull
    @Override
    public CartAdaptor.MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        final LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());

        binding = ItemCartBinding.inflate(layoutInflater, parent, false);
//        elements = session.getCartList();

        return new CartAdaptor.MyViewHolder(binding.getRoot());
    }

    @Override
    public void onBindViewHolder(@NonNull CartAdaptor.MyViewHolder holder, int position) {
        final Pair<Product, Integer> element = elements.get(position);
        holder.productName.setText(elements.get(position).first.getItemName());
        holder.productQuantity.setText(elements.get(position).second.toString());

    }

    @Override
    public int getItemCount() {
        if (elements == null) {
            return 0;
        }
        return elements.size();
    }

    public void setElements(List<Pair<Product,Integer>> elements) {
        this.elements = elements;
        notifyDataSetChanged();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {
        private TextView productName, productQuantity;
        private ImageButton deleteFromCart;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            productName = binding.productNameTextView;
            productQuantity = binding.productQuantityTextView;
        }
    }
}
