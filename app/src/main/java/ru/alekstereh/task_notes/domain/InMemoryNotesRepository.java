package ru.alekstereh.task_notes.domain;

import android.content.Context;

import java.util.ArrayList;
import java.util.List;

import ru.alekstereh.task_notes.R;

public class InMemoryNotesRepository implements NotesRepository {

    private static NotesRepository INSTANCE;

    public static NotesRepository getInstance(Context context) {
        if (INSTANCE == null) {
            INSTANCE = new InMemoryNotesRepository(context);
        }
        return INSTANCE;
    }

    private Context context;

    public InMemoryNotesRepository(Context context) {
        this.context = context;
    }

    @Override
    public List<Note> getAll() {
        ArrayList<Note> result = new ArrayList<>();

        result.add(new Note(context.getString(R.string.msk), R.drawable.msc));
        result.add(new Note(context.getString(R.string.ebrg), R.drawable.ebrg));
        result.add(new Note(context.getString(R.string.nsk), R.drawable.nsk));
        result.add(new Note(context.getString(R.string.sam), R.drawable.sam));
        result.add(new Note(context.getString(R.string.spb), R.drawable.spb));

        return result;
    }

    @Override
    public void add(Note note) {

    }
}

