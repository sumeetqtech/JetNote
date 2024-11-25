package com.compose.jetnote.data.db

import com.compose.jetnote.model.Note

class NoteDataSource {
    fun loadNotes(): List<Note> {
        return listOf(
            Note(
                title = "Shopping List",
                content = "Buy milk, bread, and eggs."
            ),
            Note(
                title = "Workout Routine",
                content = "Monday: Chest, Tuesday: Back, Wednesday: Legs."
            ),
            Note(
                title = "Project Ideas",
                content = "Create a weather app or a to-do list app."
            ),
            Note(
                title = "Meeting Notes",
                content = "Discussed project deadlines and team assignments.",
            ),
            Note(
                title = "Birthday Party",
                content = "Plan decorations and invite list."
            ),
            Note(
                title = "Book Recommendations",
                content = "Read 'Atomic Habits' and 'The Alchemist'."
            ),
            Note(
                title = "Vacation Plans",
                content = "Travel to Italy and visit Rome, Venice, and Florence."
            ),
            Note(
                title = "App Feature List",
                content = "Add user authentication and offline mode."
            ),
            Note(
                title = "Weekly Goals",
                content = "Finish the presentation and submit the report."
            ),
            Note(
                title = "Recipe",
                content = "Ingredients for spaghetti: pasta, sauce, cheese."
            ),
            Note(
                title = "Learning Kotlin",
                content = "Focus on coroutines and Jetpack Compose."
            ),
            Note(
                title = "Fitness Goals",
                content = "Run 5km daily and eat more protein."
            ),
            Note(
                title = "Grocery List",
                content = "Fruits, vegetables, and snacks."
            ),
            Note(
                title = "Event Planning",
                content = "Coordinate with vendors and finalize the schedule."
            ),
            Note(
                title = "Daily Journal",
                content = "Reflect on today's challenges and accomplishments."
            )
        )
    }
}