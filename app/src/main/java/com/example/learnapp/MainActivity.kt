package com.example.learnapp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.learnapp.ui.screens.LessonsScreen
import com.example.learnapp.ui.screens.QuizScreen
import com.example.learnapp.ui.theme.LearnAppTheme

class MainActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)


        setContent {

            LearnAppTheme {
                val navController = rememberNavController()
                NavHost(navController = navController, startDestination = "lessons") {
                    composable("lesson") {
                        QuizScreen(navController = navController)
                    }
                    composable("lessons") {
                        LessonsScreen(onNavigateToLesson = { navController.navigate("lesson") },)
                    }
                }
            }
        }
    }
}



