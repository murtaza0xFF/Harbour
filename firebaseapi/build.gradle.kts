plugins {
    id("com.android.library")
    id("de.mannodermaus.android-junit5")
    kotlin("android.extensions")
    kotlin("android")
    kotlin("kapt")
}

android {
    compileSdkVersion(28)
    defaultConfig {
        minSdkVersion(23)
        targetSdkVersion(28)
        versionCode = 1
        versionName = "1.0"
        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
    }

    buildTypes {
        getByName("release") {
            isMinifyEnabled = false
            proguardFiles(getDefaultProguardFile("proguard-android-optimize.txt"), "proguard-rules.pro")
        }
    }

    compileOptions {
        targetCompatibility = JavaVersion.VERSION_1_8
        sourceCompatibility = JavaVersion.VERSION_1_8
    }

}

dependencies {
    implementation(fileTree(mapOf("dir" to "libs", "include" to listOf("*.jar"))))
    implementation(Deps.kotlin_stdlib)
    implementation(Deps.Dagger.runtime)
    implementation(Deps.Misc.firebase_db)
    implementation(Deps.Rx.android)
    implementation(Deps.Rx.java)
    implementation(Deps.Misc.moshi)
    kapt(Deps.Dagger.compiler)
    testImplementation(Deps.Test.junit)
    testImplementation(Deps.Test.junit5)
    testRuntimeOnly(Deps.Test.junit5_engine)
    testImplementation(Deps.Test.junit5_params)
    testImplementation(Deps.Test.mockk)
}

