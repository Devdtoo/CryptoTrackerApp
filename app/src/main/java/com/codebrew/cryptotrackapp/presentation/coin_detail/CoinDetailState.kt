package com.codebrew.cryptotrackapp.presentation.coin_detail

import com.codebrew.cryptotrackapp.domain.model.Coin
import com.codebrew.cryptotrackapp.domain.model.CoinDetail

data class CoinDetailState(
    val isLoading: Boolean = false,
    val coin: CoinDetail? = null,
    val error: String = ""
)
