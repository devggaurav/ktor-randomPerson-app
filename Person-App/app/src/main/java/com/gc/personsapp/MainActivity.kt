package com.gc.personsapp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import coil.compose.rememberImagePainter
import com.gc.personsapp.ui.theme.RabbitsAppTheme
import dagger.hilt.android.AndroidEntryPoint


@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            RabbitsAppTheme {
             Column(
                 modifier = Modifier
                     .fillMaxSize()
                     .padding(32.dp)
             ) {
                 val viewModel: MainViewModel = hiltViewModel()

                 val person = viewModel.state.value.person
                 val isLoading = viewModel.state.value.isLoading
                 
                 person?.let { 
                     Image(painter = rememberImagePainter(data = person.imageUrl,
                     builder = {
                         crossfade(true)
                     }), contentDescription = "Person")
                     Spacer(modifier = Modifier.height(8.dp))
                     Text(text = person.name,fontWeight = FontWeight.Bold,fontSize = 20.sp,color = Color.White)
                     Spacer(modifier = Modifier.height(8.dp))
                     Text(text = person.description,color = Color.White)
                     Spacer(modifier = Modifier.height(8.dp))

                 }

                 Button(onClick = viewModel::getRandomPerson,
                 modifier = Modifier.align(Alignment.End)) {
                     Text(text = "Next Person")

                 }
                 Spacer(Modifier.height(8.dp))
                 if (isLoading){
                     CircularProgressIndicator()
                 }
             }
            }
        }
    }
}