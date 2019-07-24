//package com.beatrice.notekeeper.fragments;
//
//
//import android.os.Bundle;
//
//import androidx.annotation.Nullable;
//import androidx.fragment.app.Fragment;
//import androidx.lifecycle.Observer;
//import androidx.lifecycle.ViewModelProviders;
//import androidx.recyclerview.widget.LinearLayoutManager;
//import androidx.recyclerview.widget.RecyclerView;
//
//import android.view.LayoutInflater;
//import android.view.View;
//import android.view.ViewGroup;
//import android.widget.Toast;
//
//import com.beatrice.notekeeper.R;
//import com.beatrice.notekeeper.adapter.NoteAdapter;
//import com.beatrice.notekeeper.model.Note;
//import com.beatrice.notekeeper.viewModel.NotesViewModel;
//
//import java.util.List;
//
///**
// * A simple {@link Fragment} subclass.
// */
//public class Tab2 extends Fragment {
//    private NotesViewModel notesViewModel;
//    private RecyclerView recyclerView;
//    private NoteAdapter noteAdapter;
//
//
//    public Tab2() {
//        // Required empty public constructor
//    }
//
//
//    @Override
//    public View onCreateView(LayoutInflater inflater, ViewGroup container,
//                             Bundle savedInstanceState) {
//        // Inflate the layout for this fragment
//        View rootView = inflater.inflate(R.layout.fragment_tab_two, container, false);
//        recyclerView = rootView.findViewById(R.id.notes_container);
//
//        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(getActivity().getApplicationContext());
//        recyclerView.setLayoutManager(layoutManager);
//
//
//        return rootView;
//    }
//
//    @Override
//    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
//        super.onActivityCreated(savedInstanceState);
//        notesViewModel = ViewModelProviders.of(getActivity()).get(NotesViewModel.class);
//        notesViewModel.queryRepo();
//        notesViewModel.getNotes().observe(this, new Observer<List<Note>>() {
//            @Override
//            public void onChanged(List<Note> notes) {
//                Toast.makeText(getActivity(), "Beatrice", Toast.LENGTH_LONG).show();
//                noteAdapter = new NoteAdapter(notes);
//                recyclerView.setAdapter(noteAdapter);
//
//            }
//        });
//    }
//}
