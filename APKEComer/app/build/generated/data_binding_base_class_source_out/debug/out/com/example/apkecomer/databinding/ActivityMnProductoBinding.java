// Generated by view binder compiler. Do not edit!
package com.example.apkecomer.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.GridView;
import android.widget.RelativeLayout;
import android.widget.SearchView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.example.apkecomer.R;
import java.lang.NullPointerException;
import java.lang.Override;
import java.lang.String;

public final class ActivityMnProductoBinding implements ViewBinding {
  @NonNull
  private final RelativeLayout rootView;

  @NonNull
  public final GridView FrmProdGrid;

  @NonNull
  public final SearchView FrmProdSchbus;

  private ActivityMnProductoBinding(@NonNull RelativeLayout rootView, @NonNull GridView FrmProdGrid,
      @NonNull SearchView FrmProdSchbus) {
    this.rootView = rootView;
    this.FrmProdGrid = FrmProdGrid;
    this.FrmProdSchbus = FrmProdSchbus;
  }

  @Override
  @NonNull
  public RelativeLayout getRoot() {
    return rootView;
  }

  @NonNull
  public static ActivityMnProductoBinding inflate(@NonNull LayoutInflater inflater) {
    return inflate(inflater, null, false);
  }

  @NonNull
  public static ActivityMnProductoBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable ViewGroup parent, boolean attachToParent) {
    View root = inflater.inflate(R.layout.activity_mn_producto, parent, false);
    if (attachToParent) {
      parent.addView(root);
    }
    return bind(root);
  }

  @NonNull
  public static ActivityMnProductoBinding bind(@NonNull View rootView) {
    // The body of this method is generated in a way you would not otherwise write.
    // This is done to optimize the compiled bytecode for size and performance.
    int id;
    missingId: {
      id = R.id.FrmProd_grid;
      GridView FrmProdGrid = ViewBindings.findChildViewById(rootView, id);
      if (FrmProdGrid == null) {
        break missingId;
      }

      id = R.id.FrmProd_schbus;
      SearchView FrmProdSchbus = ViewBindings.findChildViewById(rootView, id);
      if (FrmProdSchbus == null) {
        break missingId;
      }

      return new ActivityMnProductoBinding((RelativeLayout) rootView, FrmProdGrid, FrmProdSchbus);
    }
    String missingId = rootView.getResources().getResourceName(id);
    throw new NullPointerException("Missing required view with ID: ".concat(missingId));
  }
}
