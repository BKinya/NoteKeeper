package com.beatrice.notekeeper.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.TextView;

import com.beatrice.notekeeper.R;
import com.beatrice.notekeeper.model.Note;

import java.util.List;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class NoteAdapter extends RecyclerView.Adapter<NoteAdapter.MyNoteViewHolder> {
    private List<Note> myNotes;

    public class MyNoteViewHolder extends RecyclerView.ViewHolder{
        private TextView titleTxtView, subTitleTxtview, textTxtView;

        public MyNoteViewHolder(@NonNull View itemView) {
            super(itemView);
            titleTxtView = itemView.findViewById(R.id.title_txtview);
            subTitleTxtview = itemView.findViewById(R.id.subTitle_txtview);
            textTxtView = itemView.findViewById(R.id.text_txtview);

        }
    }

    public NoteAdapter(List<Note> myNotes) {
        this.myNotes = myNotes;
    }

    @NonNull
    @Override
    public MyNoteViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext()).inflate(R.layout.note_item,parent, false);
        return new MyNoteViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull MyNoteViewHolder holder, int position) {
        Note note = myNotes.get(position);
        holder.titleTxtView.setText(note.getTitle());
        holder.subTitleTxtview.setText(note.getSubTitle());
        holder.textTxtView.setText(note.getText());

    }

    @Override
    public int getItemCount() {
        return myNotes.size();
    }
}
