plugins {
    alias(libs.plugins.kotlinMultiplatform)
    alias(libs.plugins.androidLibrary)
}

kotlin {
    androidTarget {
        compilations.all {
            kotlinOptions {
                jvmTarget = "1.8"
            }
        }
    }
    
    listOf(
        iosX64(),
        iosArm64(),
        iosSimulatorArm64()
    ).forEach {
        it.binaries.framework {
            baseName = "shared"
            isStatic = true
        }
    }

    sourceSets {
        commonMain.dependencies {
            implementation("org.jetbrains.kotlinx:kotlinx-coroutines-core:1.7.1")
            implementation("io.ktor:ktor-client-core:2.3.1")
            implementation("io.ktor:ktor-client-cio:2.3.1")
            implementation("io.ktor:ktor-client-content-negotiation:2.3.1")
            implementation("io.ktor:ktor-serialization-kotlinx-json:2.3.1")
        }
        commonTest.dependencies {
            implementation(libs.kotlin.test)

        }
        androidMain.dependencies {
            implementation("io.insert-koin:koin-android:3.4.2")
        }
        iosMain.dependencies {
            implementation("io.ktor:ktor-client-darwin:2.3.1")
        }
    }
}

android {
    namespace = "com.example.multiplatformpractice"
    compileSdk = 34
    defaultConfig {
        minSdk = 33
    }
}
dependencies {
    implementation("androidx.core:core-ktx:+")
    implementation("androidx.core:core-ktx:+")
    implementation("androidx.core:core-ktx:+")
}
