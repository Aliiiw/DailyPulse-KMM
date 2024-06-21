package ir.alirahimi.dailypulse.android.screens

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil.compose.AsyncImage
import ir.alirahimi.dailypulse.articles.Article
import ir.alirahimi.dailypulse.articles.ArticlesViewModel

@Composable
fun ArticlesScreen(viewModel: ArticlesViewModel) {

    val articlesState = viewModel.articlesState.collectAsState()

    Column {
        AppBar()
        if (articlesState.value.loading)
            Loader()
        if (articlesState.value.error != null)
            ErrorMessage(articlesState.value.error!!)
        if (articlesState.value.articles.isNotEmpty())
            ArticlesListView(viewModel.articlesState.value.articles)

    }


}

@Composable
fun ErrorMessage(message: String) {
    Box(
        modifier = Modifier.fillMaxSize(),
        contentAlignment = Alignment.Center
    ) {
        Text(
            text = message,
            style = TextStyle(fontSize = 28.sp, textAlign = TextAlign.Center)
        )
    }
}

@Composable
fun Loader() {
    Box(modifier = Modifier.fillMaxSize(), contentAlignment = Alignment.Center) {
        CircularProgressIndicator(
            modifier = Modifier.width(64.dp),
            color = MaterialTheme.colorScheme.surfaceVariant,
            trackColor = MaterialTheme.colorScheme.secondary
        )
    }
}


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun AppBar() {
    TopAppBar(title = { Text(text = "Articles") })
}

@Composable
fun ArticlesListView(articles: List<Article>) {
    LazyColumn(modifier = Modifier.fillMaxSize()) {
        items(articles) { article ->
            ArticleItem(article)
        }

    }
}

@Composable
fun ArticleItem(article: Article) {
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .padding(16.dp)
    ) {
        AsyncImage(
            model = article.imageUrl,
            contentDescription = null
        )

        Spacer(modifier = Modifier.height(4.dp))

        Text(
            text = article.title,
            style = TextStyle(fontWeight = FontWeight.Bold, fontSize = 22.sp)
        )

        Spacer(modifier = Modifier.height(8.dp))

        Text(text = article.description)

        Spacer(modifier = Modifier.height(4.dp))

        Text(
            text = article.date,
            style = TextStyle(color = Color.Gray),
            modifier = Modifier.align(Alignment.End)
        )

        Spacer(modifier = Modifier.height(4.dp))
    }
}


