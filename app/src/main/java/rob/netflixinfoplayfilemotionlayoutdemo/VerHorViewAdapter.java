package rob.netflixinfoplayfilemotionlayoutdemo;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class VerHorViewAdapter extends RecyclerView.Adapter<VerHorViewAdapter.ViewHolder>{
    int[] images;

    public VerHorViewAdapter(int[] images) {
        this.images = images;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_verhor_row, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        holder.verticalImageButton.setBackgroundResource(images[position]);
    }



    @Override
    public int getItemCount() {
        return images.length;
    }

    class ViewHolder extends RecyclerView.ViewHolder{
        ImageButton verticalImageButton;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            verticalImageButton = itemView.findViewById(R.id.verticalImage_view);


        }
    }
}
