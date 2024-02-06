@Suppress("DSL_SCOPE_VIOLATION") // TODO: Remove once KTIJ-19369 is fixed
plugins {
    id("gentle.hilt.library")
    id("gentle.hilt.compose.library")
}

android {
    namespace = "gentle.hilt.data"
}

dependencies {
    implementation(libs.compose.runtime)

    implementation(libs.koin.android)

    implementation(libs.timber)
    implementation(libs.logger)

    implementation(libs.ktor.core)
    implementation(libs.ktor.client)
    implementation(libs.ktor.http)
    implementation(libs.okhttp.logging)
    implementation(libs.ktor.content.negotiation)
    implementation(libs.ktor.gson)

}