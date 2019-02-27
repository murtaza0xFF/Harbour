plugins {
    id("com.android.application")
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
    }
    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_1_8
        targetCompatibility = JavaVersion.VERSION_1_8
    }

}

dependencies {
    implementation(fileTree(mapOf("dir" to "libs", "include" to listOf("*.jar"))))
    implementation(Deps.kotlin_stdlib)
    implementation(Deps.Android.Androidx.constraintLayout)
    implementation(Deps.Android.Androidx.appCompat)
    implementation(Deps.Okhttp.core)
    implementation(Deps.Misc.okio)
    implementation(Deps.Retrofit.core)
    implementation(Deps.Retrofit.moshi)
    implementation(Deps.Retrofit.rxJava2)
    implementation(Deps.Retrofit.coroutines)
    implementation(Deps.Rx.android)
    implementation(Deps.Rx.java)
    implementation(Deps.Rx.Binding.core)
    implementation(Deps.Rx.Binding.v4)
    implementation(Deps.Rx.Binding.design)
    implementation(Deps.Misc.timber)
    debugImplementation(Deps.Misc.Debug.telescope)
    debugImplementation(Deps.Okhttp.Debug.loggingInterceptor)
    debugImplementation(Deps.Retrofit.Debug.mock)
    implementation(Deps.Misc.timber)
    implementation(Deps.Misc.lottie)
    debugImplementation(Deps.Stetho.Debug.core)
    debugImplementation(Deps.Stetho.Debug.okhttp)
    debugImplementation(Deps.Stetho.Debug.timber)

    implementation(Deps.Dagger.runtime)
    kapt(Deps.Dagger.compiler)
}

repositories {
    mavenCentral()
}
