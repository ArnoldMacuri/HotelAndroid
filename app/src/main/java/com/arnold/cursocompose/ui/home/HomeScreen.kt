package com.arnold.cursocompose.ui.home

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Modifier

@Composable
fun HomeScreen(
    homeViewModel: HomeViewModel = hiltViewModel()
){
    val items by homeViewModel.items.collectAsState()

    LaunchedEffect(Unit) {
        homeViewModel.loadFeaturedItems()
    }
    
    Column(modifier = Modifier.fillMaxSize()) {
        Text(text = "Hola \uD83D\uDC4B", style = MaterialTheme.typography.h5)
    }
}
