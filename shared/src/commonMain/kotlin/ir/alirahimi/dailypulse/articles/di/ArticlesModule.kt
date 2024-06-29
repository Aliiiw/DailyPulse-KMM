package ir.alirahimi.dailypulse.articles.di

import ir.alirahimi.dailypulse.articles.ArticlesViewModel
import ir.alirahimi.dailypulse.articles.data_source.ArticlesDataSource
import ir.alirahimi.dailypulse.articles.repository.ArticlesRepository
import ir.alirahimi.dailypulse.articles.service.ArticlesService
import ir.alirahimi.dailypulse.articles.use_case.ArticlesUseCase
import org.koin.dsl.module

val articleModule = module {

    single<ArticlesService> { ArticlesService(get()) }
    single<ArticlesUseCase> { ArticlesUseCase(get()) }
    single<ArticlesViewModel> { ArticlesViewModel(get()) }
    single<ArticlesDataSource> { ArticlesDataSource(get()) }
    single<ArticlesRepository> { ArticlesRepository(get(), get()) }

}