package rob.netflixinfoplayfilemotionlayoutdemo;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class RecyclerAdapter extends RecyclerView.Adapter<RecyclerAdapter.ViewHolder> {
    List<String> movieList ;
    int[] images ;
    private RecyclerViewClickInterface recyclerViewClickInterface;

    public RecyclerAdapter(List<String> movieList, int[] images, RecyclerViewClickInterface recyclerViewClickInterface1) {
        this.movieList = movieList;
        this.images = images;
        this.recyclerViewClickInterface= recyclerViewClickInterface1;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        View view = layoutInflater.inflate(R.layout.item_row, parent, false);
        ViewHolder viewHolder = new ViewHolder(view);

        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        holder.titleTextView.setText(this.movieList.get(position));
        holder.descriptionTextView.setText(this.movieList.get(position));
        holder.imageView.setImageResource(images[position]);

    }


    @Override
    public int getItemCount() {
        return movieList.size();
    }

   class ViewHolder extends RecyclerView.ViewHolder{
        TextView titleTextView;
        TextView descriptionTextView;
        ImageView imageView;
        LinearLayout item_rowId;

       public ViewHolder(@NonNull View itemView) {
           super(itemView);
           titleTextView = itemView.findViewById(R.id.title_textView);
           descriptionTextView = itemView.findViewById(R.id.description_textView);
           item_rowId = itemView.findViewById(R.id.item_rowId);
           imageView = itemView.findViewById(R.id.row_imageView);


            item_rowId.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    //Log.i("TAG", "onClick: "+ getAdapterPosition());
                    recyclerViewClickInterface.onItemClickInterface(getAdapterPosition());



                }
            });
            item_rowId.setOnLongClickListener(new View.OnLongClickListener() {
                @Override
                public boolean onLongClick(View view) {
                    recyclerViewClickInterface.onLongItemClickInterface(getAdapterPosition());
                    return false;
                }
            });



       }
   }

}
