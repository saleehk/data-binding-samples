package com.saleeh.databinding.adapter;

import android.content.Context;
import android.databinding.BindingAdapter;
import android.databinding.DataBindingUtil;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;

import com.nostra13.universalimageloader.core.ImageLoader;
import com.saleeh.databinding.R;
import com.saleeh.databinding.api.models.Repo;
import com.saleeh.databinding.databinding.ListRepoItemBinding;

import java.util.List;

/**
 * Created by saleeh on 02/02/15.
 */
public class ListAdapter extends ArrayAdapter<Repo> {

    Context context;
    private LayoutInflater mInflater;


    public ListAdapter(Context context, List<Repo> objects) {
        super(context, 0, objects);
        this.context = context;
        mInflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);

    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ListRepoItemBinding binding;
        if (convertView == null)
            binding = DataBindingUtil.inflate(mInflater, R.layout.list_repo_item, parent, false);
        else
            binding = DataBindingUtil.getBinding(convertView);
        Repo item = getItem(position);
        binding.setRepo(item);

        convertView = binding.getRoot();
        return convertView;
    }

    @BindingAdapter({"bind:imageUrl"})
    public static void loadImage(ImageView view, String url) {
        ImageLoader.getInstance().displayImage(url, view);
    }


}
