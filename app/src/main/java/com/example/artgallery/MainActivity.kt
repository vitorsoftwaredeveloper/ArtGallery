package com.example.artgallery

import android.annotation.SuppressLint
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.filled.ArrowForward
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
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
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.artgallery.ui.theme.ArtGalleryTheme

class MainActivity : ComponentActivity() {
    @SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            ArtGalleryTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) {
                    Showing(
                        modifier = Modifier
                    )
                }
            }
        }
    }
}

@Composable
fun Showing(modifier: Modifier = Modifier) {
    var countImage by remember { mutableStateOf(1) }
    val galleryImage = when (countImage) {
        1 -> R.drawable._149848100
        2 -> R.drawable._149848101
        3 -> R.drawable._149848105
        4 -> R.drawable._149848106
        else -> R.drawable._149848109
    }

    val nameImage = when(countImage){
        1 -> R.string.lucia_ferraz
        2 -> R.string.eduardo_vilar
        3 -> R.string.clara_mendonca
        4 -> R.string.rafael_tavares
        else -> R.string.sofia_nogueira
    }

    val descriptionImage = when(countImage){
        1 -> R.string.lucia_ferraz_ds
        2 -> R.string.eduardo_vilar_ds
        3 -> R.string.clara_mendonca_ds
        4 -> R.string.rafael_tavares_ds
        else -> R.string.sofia_nogueira_ds
    }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp)
    ) {
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .aspectRatio(1f)
                .padding(8.dp)
                .weight(0.7f)
                .shadow(elevation = 8.dp)
                .clip(RoundedCornerShape(5.dp))
        ) {
            Image(
                painter = painterResource(galleryImage),
                contentDescription = null,
                contentScale = ContentScale.Fit,
                modifier = Modifier
                    .fillMaxSize()
                    .border(30.dp, Color.White)
            )
        }

        Column(
            horizontalAlignment = Alignment.Start,
            modifier = Modifier
                .fillMaxWidth()
                .weight(0.15f)
                .padding(top = 16.dp)
                .padding(8.dp)
                .background(Color.hsl(247f, 0.29f, 0.94f))

        ) {
            Text(
                text = stringResource(nameImage),
                fontSize = 32.sp,
                fontWeight = FontWeight.Thin,
                modifier = Modifier.padding(16.dp, 16.dp, 0.dp, 0.dp)

            )
            Text(
                text = stringResource(descriptionImage),
                style = MaterialTheme.typography.bodyMedium,
                fontWeight = FontWeight.Bold,
                modifier = Modifier.padding(16.dp, 0.dp, 0.dp, 16.dp)
            )
        }

        Row(
            modifier = Modifier
                .fillMaxWidth()
                .weight(0.15f)
                .padding(top = 16.dp)
                .padding(8.dp),
            horizontalArrangement = Arrangement.SpaceEvenly
        ) {
            IconButton(
                modifier = Modifier
                    .size(56.dp)
                    .background(Color.hsl(247f, 0.29f, 0.94f), shape = CircleShape),
                onClick = {
                    if (countImage == 1) {
                        countImage = 5
                    } else {
                        countImage--
                    }
                }) {
                Icon(
                    imageVector = Icons.Filled.ArrowBack,
                    contentDescription = "Previous Image",
                    tint = Color.hsl(247f, 0.29f, 0.7f)
                )
            }
            IconButton(
                modifier = Modifier
                    .size(56.dp)
                    .background(Color.hsl(247f, 0.29f, 0.94f), shape = CircleShape),
                onClick = {
                    if (countImage == 5) {
                        countImage = 1
                    } else {
                        countImage += 1
                    }
                }) {
                Icon(
                    imageVector = Icons.Filled.ArrowForward,
                    contentDescription = "Next image",
                    tint = Color.hsl(247f, 0.29f, 0.7f)
                )
            }
        }
    }

}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    ArtGalleryTheme {
        Showing()
    }
}