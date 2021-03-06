package com.github.vivchar.example.pages.github.items.list;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v7.widget.RecyclerView;
import android.view.ViewGroup;

import com.github.vivchar.example.widgets.BetweenSpacesItemDecoration;
import com.github.vivchar.example.R;
import com.github.vivchar.example.widgets.NestedAdapter;
import com.github.vivchar.rendererrecyclerviewadapter.CompositeViewRenderer;
import com.github.vivchar.rendererrecyclerviewadapter.DefaultDiffCallback;
import com.github.vivchar.rendererrecyclerviewadapter.ItemModel;
import com.github.vivchar.rendererrecyclerviewadapter.RendererRecyclerViewAdapter;
import com.github.vivchar.rendererrecyclerviewadapter.ViewState;

import java.util.Collections;
import java.util.List;

/**
 * Created by Vivchar Vitaly on 8/24/17.
 */

public class RecyclerViewRenderer extends CompositeViewRenderer<RecyclerViewModel, RecyclerViewHolder> {

	public RecyclerViewRenderer(@NonNull final Context context) {
		super(RecyclerViewModel.TYPE, context);
	}

	@Override
	public void rebindView(final RecyclerViewModel model, final RecyclerViewHolder holder, @NonNull final List payloads) {
		holder.adapter.setItems(model.getItems(), new DefaultDiffCallback());
	}

	@NonNull
	@Override
	public RecyclerViewHolder createCompositeViewHolder(@Nullable final ViewGroup parent) {
		return new RecyclerViewHolder(inflate(R.layout.item_recycler_view, parent));
	}

	@Nullable
	@Override
	public ViewState createViewState(@NonNull final ItemModel model, @NonNull final RecyclerViewHolder holder) {
		return new RecyclerViewState(holder);
	}

	@NonNull
	@Override
	protected RendererRecyclerViewAdapter createAdapter() {
		return new NestedAdapter();
	}

	@NonNull
	@Override
	protected List<? extends RecyclerView.ItemDecoration> createItemDecorations() {
		return Collections.singletonList(new BetweenSpacesItemDecoration(0, 10));
	}
}