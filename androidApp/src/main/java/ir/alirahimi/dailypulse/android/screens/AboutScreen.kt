package ir.alirahimi.dailypulse.android.screens

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material3.Divider
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import ir.alirahimi.dailypulse.Platform
import ir.alirahimi.dailypulse.android.MyApplicationTheme

@Composable
fun AboutScreen(
    onBackClick: () -> Unit
) {
    Column {
        Toolbar(onBackClick)
        ContentView()
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun Toolbar(onBackClick: () -> Unit) {
    TopAppBar(
        title = { Text(text = "About Device") },
        navigationIcon = {
            IconButton(onClick = onBackClick) {
                Icon(imageVector = Icons.Default.ArrowBack, contentDescription = "Back Button")
            }
        }
    )
}

@Composable
fun ContentView() {
    val items = makeItems()
    LazyColumn {
        items(items) { row ->
            RowView(title = row.first, subtitle = row.second)
        }
    }
}

private fun makeItems(): List<Pair<String, String>> {
    val platform = Platform()
    platform.logSystemInfo()

    return listOf(
        Pair("Operation System", "${platform.osName} ${platform.osVersion}"),
        Pair("Device", platform.deviceModel),
        Pair("Density", platform.density.toString()),
    )
}

@Composable
fun RowView(title: String, subtitle: String) {
    Column(modifier = Modifier.padding(8.dp)) {
        Text(
            text = title,
            style = MaterialTheme.typography.bodySmall,
            color = Color.Gray
        )

        Text(
            text = subtitle,
            style = MaterialTheme.typography.bodyLarge,
        )
    }
    Divider()
}