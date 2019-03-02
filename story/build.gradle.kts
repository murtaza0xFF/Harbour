plugins{
    id("com.android.library")
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
    kapt(Deps.Dagger.compiler)
    testImplementation(Deps.Test.junit)
}
repositories {
    mavenCentral()
}