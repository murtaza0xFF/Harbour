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

}

dependencies {
    implementation(fileTree(mapOf("dir" to "libs", "include" to listOf("*.jar"))))
    implementation(Deps.kotlin_stdlib)
}

repositories {
    mavenCentral()
}
