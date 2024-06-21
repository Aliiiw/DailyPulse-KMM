package ir.alirahimi.dailypulse.articles.use_case

import ir.alirahimi.dailypulse.articles.Article
import ir.alirahimi.dailypulse.articles.model.ArticleRaw
import ir.alirahimi.dailypulse.articles.service.ArticlesService

class ArticlesUseCase(private val service: ArticlesService) {
    suspend fun getAllArticles(): List<Article> {

        val articles = service.fetchArticles()

        return mapArticles(articles)
    }

    private fun mapArticles(articles: List<ArticleRaw>): List<Article> = articles.map {
        Article(
            title = it.title,
            description = it.desc ?: "Click to find out more",
            date = it.date,
            imageUrl = it.imageUrl ?: ""
        )
    }
}