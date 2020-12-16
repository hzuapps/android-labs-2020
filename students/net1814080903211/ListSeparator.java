package edu.hzuapps.androidlabs.net1814080903211.components;

import android.graphics.Rect;
import android.view.View;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import org.jetbrains.annotations.NotNull;

public class ListSeparator extends RecyclerView.ItemDecoration {

    private static int margin = 12;

    @Override
    public void getItemOffsets(@NonNull @NotNull Rect outRect, @NonNull @NotNull View view,
                               @NonNull @NotNull RecyclerView parent, @NonNull @NotNull RecyclerView.State state) {
        super.getItemOffsets(outRect, view, parent, state);

        final float scale = parent.getResources().getDisplayMetrics().density;
        final int margin_dp = (int) (margin * scale + 0.5f);

        if (parent.getChildLayoutPosition(view) == 0) {
            outRect.top = margin_dp;
        }
        outRect.bottom = margin_dp;
        outRect.left = margin_dp;
        outRect.right = margin_dp;
    }
}
