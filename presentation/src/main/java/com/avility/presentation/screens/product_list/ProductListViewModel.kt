package com.avility.presentation.screens.product_list

import androidx.lifecycle.viewModelScope
import com.avility.domain.usescases.SearchProductsUseCase
import com.avility.presentation.screens.BaseViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class ProductListViewModel @Inject constructor(
    private val searchProductsUseCase: SearchProductsUseCase
) : BaseViewModel<ProductListState, ProductListAction>(ProductListState()) {

    override fun dispatchAction(action: ProductListAction) {
        when (action) {
            is ProductListAction.UpdateQueryValue -> {
                setState(uiState.value.copy(
                    querySearch = action.query
                ))
            }
            ProductListAction.Search -> executeSearch()
        }
    }

    private fun executeSearch() {
        viewModelScope.launch {
            setState(uiState.value.copy(
                isLoading = true
            ))
            val listProductsResource = searchProductsUseCase(uiState.value.querySearch)
            setState(uiState.value.copy(
                isLoading = false,
                data = listProductsResource.data.orEmpty(),
                errorMessage = listProductsResource.message
            ))
        }
    }
}