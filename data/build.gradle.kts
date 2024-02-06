@Suppress("DSL_SCOPE_VIOLATION") // TODO: Remove once KTIJ-19369 is fixed
plugins {
    id("gentle.hilt.library")
    id("gentle.hilt.compose.library")
}

android {
    namespace = "gentle.hilt.data"

    defaultConfig{
        ksp {
            arg("room.schemaLocation", "$projectDir/schemas")
        }
    }
}

dependencies {
    implementation(projects.network)

    ksp(libs.room.compiler)

    implementation(libs.compose.runtime)
    implementation(libs.room.runtime)
    implementation(libs.room)
    implementation(libs.gson)

    // Entire application see those dependencies because of ScreensPlugin in build-logic
    api(libs.logger)
    api(libs.timber)
    api(libs.compose.coil)
    api(libs.datastore.preferences)
    api(libs.compose.material)
    api(libs.koin.android)
    api(libs.koin.compose)
    api(libs.datastore.preferences)
}