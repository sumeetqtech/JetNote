package com.compose.jetnote.screen

import android.widget.Toast
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.Notifications
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import com.compose.jetnote.R
import com.compose.jetnote.components.NoteButton
import com.compose.jetnote.components.NoteInputText
import com.compose.jetnote.model.Note
import org.threeten.bp.format.DateTimeFormatter

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun NoteScreen(
    modifier: Modifier = Modifier,
    notes: List<Note> = listOf(),
    onAdd: (Note) -> Unit,
    onRemove: (Note) -> Unit,
) {

    var title by remember {
        mutableStateOf("")
    }

    var content by remember {
        mutableStateOf("")
    }
    val context = LocalContext.current

    Scaffold(
        modifier = modifier.fillMaxSize(),
        topBar = {
            TopAppBar(
                title = {
                    Text(text = stringResource(R.string.app_name))
                },
                actions = {
                    Icon(
                        modifier = Modifier
                            .padding(horizontal = 16.dp)
                            .clickable {

                            },
                        imageVector = Icons.Rounded.Notifications,
                        contentDescription = "Notification Icon"
                    )
                },
                colors = TopAppBarDefaults.topAppBarColors(
                    containerColor = MaterialTheme.colorScheme.primary,
                    scrolledContainerColor = MaterialTheme.colorScheme.primary,
                    navigationIconContentColor = MaterialTheme.colorScheme.onPrimary,
                    titleContentColor = MaterialTheme.colorScheme.onPrimary,
                    actionIconContentColor = MaterialTheme.colorScheme.onPrimary
                ),
                modifier = Modifier.shadow(4.dp)
            )
        }
    ) { innerPadding ->

        Column(
            modifier = Modifier
                .padding(innerPadding)
                .padding(16.dp)
        ) {
            Column(
                modifier = Modifier.fillMaxWidth(),
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                NoteInputText(text = title, label = "Title", onTextChanged = { typedText ->
                    if (typedText.all { char ->
                            char.isLetter() || char.isWhitespace()
                        }) title = typedText
                })
                Spacer(modifier = Modifier.height(16.dp))
                NoteInputText(text = content, label = "Content", onTextChanged = { typedText ->
                    if (typedText.all { char ->
                            char.isLetter() || char.isWhitespace()
                        }) content = typedText
                })
                Spacer(modifier = Modifier.height(16.dp))
                NoteButton(text = "Save Note", onClick = {
                    if (title.isNotEmpty() && content.isNotEmpty()) {
                        onAdd(Note(title = title, content = content))
                        title = ""
                        content = ""
                        Toast.makeText(context, "Note Added!", Toast.LENGTH_LONG)
                            .show()
                    }
                })
            }
            HorizontalDivider(modifier = Modifier.padding(16.dp))
            LazyColumn {
                items(notes) { note ->
                    NoteRow(note = note, onClick = {
                        onRemove(note)
                    })
                }
            }
        }
    }
}

@Composable
fun NoteRow(
    modifier: Modifier = Modifier,
    note: Note,
    onClick: (Note) -> Unit
) {

    Surface(
        modifier = modifier
            .padding(4.dp)
            .clip(shape = RoundedCornerShape(topEnd = 32.dp, bottomStart = 32.dp))
            .fillMaxWidth(),
        color = Color(0xFFDFE6EB),
        shadowElevation = 8.dp
    ) {
        Column(modifier = modifier
            .padding(horizontal = 16.dp, vertical = 8.dp)
            .clickable { onClick.invoke(note) }) {
            Text(text = note.title, style = MaterialTheme.typography.titleMedium)
            Text(text = note.content, style = MaterialTheme.typography.bodySmall)
            note.entryDate?.format(DateTimeFormatter.ofPattern("EEE, d MMM"))?.let {
                Text(
                    text = it,
                    style = MaterialTheme.typography.bodySmall
                )
            }
        }
    }

}