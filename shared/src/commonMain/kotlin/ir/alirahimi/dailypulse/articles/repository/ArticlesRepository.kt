package ir.alirahimi.dailypulse.articles.repository

import ir.alirahimi.dailypulse.articles.data_source.ArticlesDataSource
import ir.alirahimi.dailypulse.articles.model.ArticleRaw
import ir.alirahimi.dailypulse.articles.service.ArticlesService

class ArticlesRepository(
    private val dataSource: ArticlesDataSource,
    private val articlesService: ArticlesService
) {

    suspend fun getAllArticles(): List<ArticleRaw> {
        val articleDB = dataSource.getAllArticles()
        if (articleDB.isEmpty()) {
            val fetchedArticles = articlesService.fetchArticles()
            dataSource.insertArticles(fetchedArticles)
            return fetchedArticles
        }
        return articleDB
    }

    suspend fun deleteAllArticles() = dataSource.deleteAllArticles()

    suspend fun insertArticles(articles: List<ArticleRaw>) = dataSource.insertArticles(articles)


}