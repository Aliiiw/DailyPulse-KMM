package ir.alirahimi.dailypulse.articles.use_case

import ir.alirahimi.dailypulse.articles.Article
import ir.alirahimi.dailypulse.articles.model.ArticleRaw
import ir.alirahimi.dailypulse.articles.service.ArticlesService
import kotlinx.datetime.Clock
import kotlinx.datetime.Instant
import kotlinx.datetime.TimeZone
import kotlinx.datetime.daysUntil
import kotlinx.datetime.toLocalDateTime
import kotlinx.datetime.todayIn
import kotlin.math.abs

class ArticlesUseCase(private val service: ArticlesService) {
    suspend fun getAllArticles(): List<Article> {

        val articles = service.fetchArticles()

        return mapArticles(articles)
    }

    private fun mapArticles(articles: List<ArticleRaw>): List<Article> = articles.map {
        Article(
            it.title,
            it.desc ?: "Click to find out more",
            getDaysAgoString(it.date),
            it.imageUrl
                ?: "https://image.cnbcfm.com/api/v1/image/107326078-1698758530118-gettyimages-1765623456-wall26362_igj6ehhp.jpeg?v=1698758587&w=1920&h=1080"
        )
    }

    private fun getDaysAgoString(date: String): String {
        val today = Clock.System.todayIn(TimeZone.currentSystemDefault())
        val days = today.daysUntil(
            Instant.parse(date).toLocalDateTime(TimeZone.currentSystemDefault()).date
        )

        val result = when {
            abs(days) > 1 -> "${abs(days)} days ago"
            abs(days) == 1 -> "Yesterday"
            else -> "Today"
        }

        return result
    }
}