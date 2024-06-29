package ir.alirahimi.dailypulse.articles

import ir.alirahimi.dailypulse.articles.model.Article


data class ArticlesState(
    val articles: List<Article> = listOf(),
    val loading: Boolean = false,
    val error: String? = null
)