package com.example.myapplication.view

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import coil.compose.rememberAsyncImagePainter
import com.example.myapplication.model.Serie

@Composable
fun SerieCard(serie: Serie) {
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .height(320.dp)
            .padding(4.dp),
        shape = RoundedCornerShape(12.dp)
    ) {
        Column(
            modifier = Modifier.padding(8.dp)
        ) {
            Image(
                painter = rememberAsyncImagePainter(serie.image_thumbnail_path),
                contentDescription = serie.name,
                modifier = Modifier
                    .fillMaxWidth()
                    .height(160.dp)
                    .clip(RoundedCornerShape(8.dp)),
                contentScale = ContentScale.Crop
            )

            Spacer(modifier = Modifier.height(8.dp))

            Text(
                text = serie.name,
                style = MaterialTheme.typography.titleMedium,
                maxLines = 1,
                overflow = TextOverflow.Ellipsis
            )

            serie.start_date?.let {
                Text(
                    text = "Début : $it",
                    style = MaterialTheme.typography.bodySmall,
                    color = Color.Gray
                )
            }

            serie.country?.let {
                Text(
                    text = "Pays : $it",
                    style = MaterialTheme.typography.bodySmall
                )
            }

            serie.network?.let {
                Text(
                    text = "Réseau : $it",
                    style = MaterialTheme.typography.bodySmall
                )
            }

            serie.status?.let {
                Text(
                    text = "Statut : $it",
                    style = MaterialTheme.typography.bodySmall
                )
            }
        }
    }
}