package ir.alirahimi.dailypulse.articles.di

import ir.alirahimi.dailypulse.articles.ArticlesViewModel
import ir.alirahimi.dailypulse.articles.service.ArticlesService
import ir.alirahimi.dailypulse.articles.use_case.ArticlesUseCase
import org.koin.dsl.module

val articleModule = module {

    // Dependency Graph
    single<ArticlesService> { ArticlesService(get()) }
    single<ArticlesUseCase> { ArticlesUseCase(get()) }
    single<ArticlesViewModel> { ArticlesViewModel(get()) }

}