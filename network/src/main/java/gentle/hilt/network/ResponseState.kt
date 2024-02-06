package gentle.hilt.network

import io.ktor.client.call.body
import io.ktor.client.statement.HttpResponse

data class ResponseState(
    val status: Status,
    val data: HttpResponse?,
    val exception: Exception?
) {
    sealed class Status {
        data object Success : Status()
        data object Failure : Status()
    }

    companion object {
        fun success(data: HttpResponse) = ResponseState(Status.Success, data, null)
        fun failure(exception: Exception) = ResponseState(Status.Failure, null, exception)
    }

    val failed: Boolean
        get() = this.status == Status.Failure

    val isSuccessful: Boolean
        get() = !failed && this.data?.status?.value == 200


    suspend inline fun <reified T> body(): T {
        return data!!.body()
    }

    suspend inline fun <reified T> bodyNullable(): T? {
        return data?.body<T>()
    }
}