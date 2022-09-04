package com.codebrew.cryptotrackapp.data.repository

import com.codebrew.cryptotrackapp.data.remote.CoinPaprikaApi
import com.codebrew.cryptotrackapp.data.remote.dto.CoinDetailDto
import com.codebrew.cryptotrackapp.data.remote.dto.CoinDto
import com.codebrew.cryptotrackapp.domain.repository.CoinRepository
import javax.inject.Inject

class CoinRepositoryImpl @Inject constructor(
    private val api: CoinPaprikaApi
) : CoinRepository {

    override suspend fun getCoins(): List<CoinDto> {
        return api.getCoins()
    }

    override suspend fun getCoinById(coinId: String): CoinDetailDto {
        return api.getCoinById(coinId)
    }
}