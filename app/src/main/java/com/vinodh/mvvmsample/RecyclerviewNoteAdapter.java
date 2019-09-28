package com.vinodh.mvvmsample;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by VINODH KUMAR on 14-09-2019.
 */
public class RecyclerviewNoteAdapter extends RecyclerView.Adapter<RecyclerviewNoteAdapter.NoteHolder> {

    private List<Note> notes = new ArrayList<>();
    private onItemClickListener listener;

    public void setNotes(List<Note> notes) {
        this.notes = notes;
        notifyDataSetChanged();
    }


    public Note getNoteAt(int position){
        return notes.get(position);
    }

    @NonNull
    @Override
    public NoteHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.note_item,parent,false);
        return new NoteHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull NoteHolder holder, int position) {
        Note currentNote = notes.get(position);
        holder.title_tv.setText(currentNote.getName());
        holder.desc_tv.setText(currentNote.getDescription());
        holder.priority_tv.setText(String.valueOf(currentNote.getPriority()));
    }

    @Override
    public int getItemCount() {
        return notes.size();
    }


    public class NoteHolder extends RecyclerView.ViewHolder{

        private TextView title_tv;
        private TextView desc_tv;
        private TextView priority_tv;

        public NoteHolder(@NonNull View itemView) {
            super(itemView);
            title_tv = (TextView) itemView.findViewById(R.id.title_tv_id);
            desc_tv = (TextView) itemView.findViewById(R.id.desc_tv_id);
            priority_tv = (TextView) itemView.findViewById(R.id.priority_tv_id);

            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    int position = getAdapterPosition();
                    if(listener!=null && position!= RecyclerView.NO_POSITION) {
                        listener.onItemClick(notes.get(position));
                    }
                }
            });
        }
    }

    public interface onItemClickListener{
        void onItemClick(Note note);
    }

    public void setOnItemClickListener(onItemClickListener listener){
        this.listener = listener;
    }


}
