package com.compose.jetnote

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.activity.viewModels
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.tooling.preview.Preview
import com.compose.jetnote.screen.NoteScreen
import com.compose.jetnote.screen.NoteViewModel
import com.compose.jetnote.ui.theme.JetNoteTheme
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            App {
                val noteViewModel: NoteViewModel by viewModels()
                NoteScreen(
                    notes = noteViewModel.noteList.collectAsState().value,
                    onAdd = {
                        noteViewModel.addNote(it)
                    },
                    onRemove = {
                        noteViewModel.removeNote(it)
                    }
                )
            }
        }
    }
}

@Composable
private fun App(content: @Composable () -> Unit) {
    JetNoteTheme {
        content()
    }
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    App {
        NoteScreen(notes = emptyList(), onAdd = {}, onRemove = {})
    }
}