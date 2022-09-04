package com.codebrew.cryptotrackapp.presentation.coin_list

import com.codebrew.cryptotrackapp.domain.model.Coin

data class CoinListState(
    val isLoading: Boolean = false,
    val coins: List<Coin> = emptyList(),
    val error: String = ""
)
