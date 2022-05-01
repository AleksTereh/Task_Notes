package ru.alekstereh.task_notes.ui;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;

import ru.alekstereh.task_notes.R;
import ru.alekstereh.task_notes.domain.Note;

public class NoteDetailsActivity extends AppCompatActivity {

    private static final String EXTRA_CITY = "EXTRA_CITY";

    public static void show(Context context, Note note){
        Intent intent = new Intent(context, NoteDetailsActivity.class);
        intent.putExtra(EXTRA_CITY, note);

        context.startActivity(intent);
    }


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_note_details);

        if (savedInstanceState == null){

            Note note = getIntent().getParcelableExtra(EXTRA_CITY);

            NoteDetailsFragment noteDetailsFragment = NoteDetailsFragment.newInstance(note);

            getSupportFragmentManager()
                    .beginTransaction()
                    .replace(R.id.container, noteDetailsFragment)
                    .commit();

        }

    }
}