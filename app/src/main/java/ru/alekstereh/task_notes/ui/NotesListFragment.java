package ru.alekstereh.task_notes.ui;

import android.content.Context;
import android.content.res.Configuration;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import java.util.List;

import ru.alekstereh.task_notes.R;
import ru.alekstereh.task_notes.domain.InMemoryNotesRepository;
import ru.alekstereh.task_notes.domain.Note;

public class NotesListFragment extends Fragment {

    public static final String NOTES_CLICKED_KEY = "NOTES_CLICKED_KEY";
    public static final String SELECTED_NOTE = "SELECTED_NOTE";

    @Override
    public void onAttach(@NonNull Context context) {
        super.onAttach(context);
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_notes_list, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        List<Note> notes = InMemoryNotesRepository.getInstance(requireContext()).getAll();

        LinearLayout container = view.findViewById(R.id.container);

        for (Note note : notes) {

            View itemView = getLayoutInflater().inflate(R.layout.item_note, container, false);

            itemView.findViewById(R.id.root).setOnClickListener(v -> {
                if (getResources().getConfiguration().orientation == Configuration.ORIENTATION_LANDSCAPE) {
                    Bundle bundle = new Bundle();
                    bundle.putParcelable(SELECTED_NOTE, note);
                    getParentFragmentManager()
                            .setFragmentResult(NOTES_CLICKED_KEY, bundle);
                } else {
                    NoteDetailsActivity.show(requireContext(), note);
                }

            });

            ImageView icon = itemView.findViewById(R.id.icon);
            icon.setImageResource(note.getIcon());

//            TextView title = itemView.findViewById(R.id.title);
//            title.setText(note.getName());

            container.addView(itemView);
        }

    }
}
