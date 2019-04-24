package sangamsagar.learningroom;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public class NoteAdapter  extends RecyclerView.Adapter<NoteAdapter.NoteHolder>{

    private List<ModelClass> modelClasses   = new ArrayList<>();

    @NonNull
    @Override
    public NoteHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View itemview = LayoutInflater.from(parent.getContext()).inflate(R.layout.reading_information,parent,false);
        return new NoteHolder(itemview);

    }

    @Override
    public void onBindViewHolder(@NonNull NoteHolder holder, int position) {
        ModelClass modelClass = modelClasses.get(position);
        holder.title.setText(modelClass.getTitle());
        holder.heading.setText(modelClass.getDescription());
    }

    @Override
    public int getItemCount() {
        return modelClasses.size();
    }
    public  void setModelClasses(List<ModelClass> modelClasses)
    {

        this.modelClasses  = modelClasses;
        notifyDataSetChanged();
    }

    class NoteHolder extends RecyclerView.ViewHolder
    {
        TextView title ,heading;

        public NoteHolder(View itemView) {
            super(itemView);
            title = (TextView) itemView.findViewById(R.id.title);
            heading = (TextView) itemView.findViewById(R.id.heading);
            Log.d("PrintingValue",title + " " + heading);
        }


    }
}
