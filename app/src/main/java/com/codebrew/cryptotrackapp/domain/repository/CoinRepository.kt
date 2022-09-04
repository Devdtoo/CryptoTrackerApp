package com.codebrew.cryptotrackapp.domain.repository

import com.codebrew.cryptotrackapp.data.remote.dto.CoinDetailDto
import com.codebrew.cryptotrackapp.data.remote.dto.CoinDto

interface CoinRepository {
    suspend fun getCoins(): List<CoinDto>
    suspend fun getCoinById(coinId: String): CoinDetailDto
}