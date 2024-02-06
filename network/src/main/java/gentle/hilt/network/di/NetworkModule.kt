package gentle.hilt.network.di


import gentle.hilt.network.ApiClient
import gentle.hilt.network.NetworkRepository
import io.ktor.client.HttpClient
import io.ktor.client.engine.okhttp.OkHttp
import io.ktor.client.plugins.contentnegotiation.ContentNegotiation
import io.ktor.serialization.gson.gson
import okhttp3.logging.HttpLoggingInterceptor
import org.koin.dsl.module
import java.util.concurrent.TimeUnit

val networkModule = module {
    single {
        HttpClient(OkHttp) {
            engine {
                config {
                    val loggingInterceptor = HttpLoggingInterceptor()
                    loggingInterceptor.level = HttpLoggingInterceptor.Level.BODY
                    addInterceptor(loggingInterceptor)
                    connectTimeout(5, TimeUnit.SECONDS)
                    readTimeout(5, TimeUnit.SECONDS)
                    writeTimeout(5, TimeUnit.SECONDS)
                    retryOnConnectionFailure(false)
                }
            }
            install(ContentNegotiation) {
                gson()
            }
        }
    }

    single { ApiClient(get()) }
    single { NetworkRepository(get()) }
}