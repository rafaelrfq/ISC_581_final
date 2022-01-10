package com.pucmm.csti.ui;

import android.content.Context;
import androidx.annotation.NonNull;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelProvider;
import com.pucmm.csti.database.AppDataBase;
import com.pucmm.csti.database.CategoryDao;
import com.pucmm.csti.ui.cart.CartViewModel;
import com.pucmm.csti.ui.category.CategoryViewModel;
import com.pucmm.csti.ui.product.ProductViewModel;
import com.pucmm.csti.utils.UserSession;

import org.jetbrains.annotations.NotNull;

public class ViewModelFactory implements ViewModelProvider.Factory {

    private final AppDataBase dataBase;
    private final UserSession session;

    public ViewModelFactory(@NonNull Context context) {
        this.dataBase = AppDataBase.getInstance(context);
        this.session = new UserSession(context);

    }

    @NonNull
    @NotNull
    @Override
    public <T extends ViewModel> T create(@NonNull @NotNull Class<T> modelClass) {
        if (modelClass.isAssignableFrom(CategoryViewModel.class)) {
            return (T) new CategoryViewModel(dataBase);
        } else if (modelClass.isAssignableFrom(ProductViewModel.class)) {
            return (T) new ProductViewModel(dataBase);
        } else if (modelClass.isAssignableFrom(CartViewModel.class)) {
            return (T) new CartViewModel(session);
        } else {
            throw new IllegalArgumentException("Unknown ViewModel Class");
        }
    }
}
