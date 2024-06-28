package ir.alirahimi.dailypulse.articles

import ir.alirahimi.dailypulse.BaseViewModel
import ir.alirahimi.dailypulse.articles.use_case.ArticlesUseCase
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch

class ArticlesViewModel(private val useCase: ArticlesUseCase) : BaseViewModel() {

    private val _articlesState: MutableStateFlow<ArticlesState> =
        MutableStateFlow(ArticlesState(loading = true))
    val articlesState: StateFlow<ArticlesState> get() = _articlesState

    init {
        getArticles()
    }

    private fun getArticles() {
        scope.launch {
            delay(1500)
            _articlesState.emit(ArticlesState(error = "Something went wrong"))
            delay(1500)
            val articles = useCase.getAllArticles()
            _articlesState.emit(ArticlesState(articles))
        }
    }
}