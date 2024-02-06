plugins {
    id("gentle.hilt.application")
    id("gentle.hilt.compose.application")
    alias(libs.plugins.ksp)
    alias(libs.plugins.ktlint)
}

android {
    namespace = "com.example.gentle_hilt_test_task"
    compileSdk = 34

    defaultConfig {
        applicationId = "com.example.gentle_hilt_test_task"
        minSdk = 24
        targetSdk = 34
        versionCode = 1
        versionName = "1.0"

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
        vectorDrawables {
            useSupportLibrary = true
        }
    }

    buildTypes {
        release {
            isMinifyEnabled = true
            proguardFiles(getDefaultProguardFile("proguard-android-optimize.txt"), "proguard-rules.pro")
        }
    }
    packaging {
        resources.excludes.add("META-INF/*")
    }

    ksp {
        arg("room.schemaLocation", "$projectDir/schemas")
    }
}

dependencies {
    implementation(projects.data)
    implementation(projects.network)
    implementation(projects.navigation)
    implementation(projects.screens.catalog)
    implementation(projects.screens.product)
    implementation(projects.screens.profile)
    implementation(projects.screens.favorite)
    implementation(projects.screens.login)

    implementation(libs.compose.runtime)
    implementation(libs.compose.activity)
    implementation(libs.compose.lifecycle)
    implementation(libs.constraint.compose)

    implementation(libs.gentle.hilt.navigation)
    implementation(libs.koin.android)
}
