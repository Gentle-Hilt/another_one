@Suppress("DSL_SCOPE_VIOLATION")
plugins {
    id("gentle.hilt.library")
    id("gentle.hilt.compose.library")
    alias(libs.plugins.ksp)
}

android {
    namespace = "gentle.hilt.dependencies"
}

// Module for screenPlugin to easily setup dependencies in each screen
dependencies {
    api(libs.compose.activity)
    api(libs.compose.foundation)
    api(libs.compose.runtime)
    api(libs.constraint.compose)
    api(libs.compose.text)
    api(libs.compose.ui)
    api(libs.compose.lifecycle)
}