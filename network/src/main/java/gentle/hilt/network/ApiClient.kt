package gentle.hilt.network

import io.ktor.client.HttpClient
import io.ktor.client.request.get
import io.ktor.client.statement.HttpResponse
import io.ktor.http.isSuccess
import timber.log.Timber


const val BASE_URL = "https://run.mocky.io/v3/"

class ApiClient (
    private val httpClient: HttpClient
) {

    suspend fun getGoods(): ResponseState{
        return safeApiCall { fetch("97e721a7-0a66-4cae-b445-83cc0bcf9010/") }
    }

    private suspend fun fetch(endpoint: Any): HttpResponse {
        return httpClient.get("$BASE_URL$endpoint")
    }

    private inline fun safeApiCall(apiCall: () -> HttpResponse): ResponseState {
        return try {
            val response = apiCall.invoke()
            if (response.status.isSuccess()) {
                ResponseState.success(response)
            } else {
                Timber.d("HTTP Error: ${response.status.value}")
                ResponseState.failure(Exception("HTTP Error ${response.status.value}"))
            }
        } catch (e: Exception) {
            Timber.d("Network Error: ${e.message}")
            ResponseState.failure(Exception("Network Error: ${e.message}"))
        }
    }
}