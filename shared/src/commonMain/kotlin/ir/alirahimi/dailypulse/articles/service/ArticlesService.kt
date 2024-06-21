package ir.alirahimi.dailypulse.articles.service

import io.ktor.client.HttpClient
import io.ktor.client.call.body
import io.ktor.client.request.get
import ir.alirahimi.dailypulse.articles.model.ArticleRaw
import ir.alirahimi.dailypulse.articles.model.ArticlesResponse

class ArticlesService(private val httpClient: HttpClient) {

    private val country = "us"
    private val category = "business"
    private val apiKey = "cdfd297eb47b4304a8ef86ae7c2a7ede"

    suspend fun fetchArticles(): List<ArticleRaw> {
        val response: ArticlesResponse = httpClient.get(
            urlString =
            "https://newsapi.org/v2/top-headlines?country=$country&category=$category&apiKey=$apiKey"
        ).body()

        return response.articles
    }
}