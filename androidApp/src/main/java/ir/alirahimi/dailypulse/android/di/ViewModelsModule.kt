package ir.alirahimi.dailypulse.android.di

import ir.alirahimi.dailypulse.articles.ArticlesViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val viewModelsModule = module {

    viewModel { ArticlesViewModel(get()) }

}