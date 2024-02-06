package gentle.hilt.network

import gentle.hilt.network.models.goods.GoodsModel
import timber.log.Timber


class NetworkRepository (
    private val apiClient: ApiClient,
) {

    suspend fun getGoods(): GoodsModel?{
        val request = apiClient.getGoods()

        if(!request.isSuccessful || request.failed){
            Timber.d("request is not successful")
            return request.bodyNullable()
        }

        Timber.d("request successful returning body")

        return request.body()
    }
}
