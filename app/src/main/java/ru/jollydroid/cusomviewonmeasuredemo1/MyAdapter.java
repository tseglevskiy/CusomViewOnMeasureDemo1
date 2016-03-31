package ru.jollydroid.cusomviewonmeasuredemo1;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

/**
 * Created by tse on 31/03/16.
 */
public class MyAdapter extends RecyclerView.Adapter<MyAdapter.MyHolder> {
    Item[] data;

    public MyAdapter(Item[] data) {
        this.data = data;
    }

    @Override
    public MyHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return new MyHolder(LayoutInflater.from(parent.getContext()).inflate(R.layout.item, parent, false));
    }

    @Override
    public void onBindViewHolder(MyHolder holder, int position) {
        holder.myView.setItem(data[position]);

    }

    @Override
    public int getItemCount() {
        return data.length;
    }

    public static class MyHolder extends RecyclerView.ViewHolder {

        private final MyView myView;

        public MyHolder(View itemView) {
            super(itemView);

            myView = (MyView)itemView.findViewById(R.id.nest);
        }
    }
}
