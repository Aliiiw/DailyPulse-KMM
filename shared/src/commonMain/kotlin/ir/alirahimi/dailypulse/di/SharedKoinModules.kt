package ir.alirahimi.dailypulse.di

import ir.alirahimi.dailypulse.articles.di.articleModule

val sharedKoinModule = listOf(
    articleModule,
    networkModule
)