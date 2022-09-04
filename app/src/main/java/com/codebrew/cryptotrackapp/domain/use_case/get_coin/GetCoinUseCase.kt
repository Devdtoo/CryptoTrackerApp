package com.codebrew.cryptotrackapp.domain.use_case.get_coin

import com.codebrew.cryptotrackapp.common.Resource
import com.codebrew.cryptotrackapp.data.remote.dto.toCoin
import com.codebrew.cryptotrackapp.data.remote.dto.toCoinDetail
import com.codebrew.cryptotrackapp.domain.model.Coin
import com.codebrew.cryptotrackapp.domain.model.CoinDetail
import com.codebrew.cryptotrackapp.domain.repository.CoinRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import retrofit2.HttpException
import java.io.IOException
import javax.inject.Inject

class GetCoinUseCase @Inject constructor(
    private val coinRepository: CoinRepository
) {
    operator fun invoke(coinId: String): Flow<Resource<CoinDetail>> = flow {
        try {
            emit(Resource.Loading<CoinDetail>())
            val coin = coinRepository.getCoinById(coinId).toCoinDetail()
            emit(Resource.Success<CoinDetail>(coin))
        } catch (e: HttpException) {
            emit(Resource.Error<CoinDetail>(e.localizedMessage ?: "An unexpected error occurred"))
        } catch (e: IOException) {
            emit(Resource.Error<CoinDetail>("Couldn't reach server. Check your internet connection."))
        }
    }
}