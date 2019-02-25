object Versions {
    const val kotlin: String = "1.3.21"
    const val android_gradle_plugin: String = "3.3.1"
    const val dagger = "2.18"
    const val okhttp = "3.13.1"
    const val retrofit = "2.5.0"
    const val rxbinding = "2.2.0"
    const val stetho = "1.5.0"
    const val androidTestSupport = "1.1.0-rc01"
    const val espresso = "3.1.0-alpha1"
    const val mockk = "1.9.1.kotlin12"
    const val moshi = "1.8.0"
    const val klint = "7.1.0"
}

object Deps {
    const val kotlin_stdlib = "org.jetbrains.kotlin:kotlin-stdlib-jdk7:${Versions.kotlin}"
    const val kotlin_gradle_plugin = "org.jetbrains.kotlin:kotlin-gradle-plugin:${Versions.kotlin}"
    const val android_gradle_plugin = "com.android.tools.build:gradle:${Versions.android_gradle_plugin}"

    object Dagger {
        const val runtime = "com.google.dagger:dagger:${Versions.dagger}"
        const val compiler = "com.google.dagger:dagger-compiler:${Versions.dagger}"
    }

    object Android {
        object Androidx {
            const val annotations = "androidx.annotation:annotation:1.0.1"
            const val appCompat = "androidx.appcompat:appcompat:1.1.0-alpha01"

            const val core = "androidx.core:core:1.1.0-alpha03"
            const val coreKtx = "androidx.core:core-ktx:1.1.0-alpha03"

            const val constraintLayout = "androidx.constraintlayout:constraintlayout:1.1.2"
            const val design = "com.google.android.material:material:1.1.0-alpha02"
            const val drawerLayout = "androidx.drawerlayout:drawerlayout:1.0.0"

            private const val fragmentVersion = "1.1.0-alpha03"
            const val fragment = "androidx.fragment:fragment:$fragmentVersion"
            const val fragmentKtx = "androidx.fragment:fragment-ktx:$fragmentVersion"

            const val viewPager = "androidx.viewpager:viewpager:1.0.0"
            const val swipeRefresh = "androidx.swiperefreshlayout:swiperefreshlayout:1.1.0-alpha01"
            const val palette = "androidx.palette:palette:1.0.0"
            const val paletteKtx = "androidx.palette:palette-ktx:1.0.0"

            const val preferenceVersion = "1.1.0-alpha02"
            const val preference = "androidx.preference:preference:$preferenceVersion"
            const val preferenceKtx = "androidx.preference:preference-ktx:$preferenceVersion"
            const val recyclerView = "androidx.recyclerview:recyclerview:1.0.0"

            object Lifecycle {
                private const val version = "2.1.0-alpha01"
                const val apt = "androidx.lifecycle:lifecycle-compiler:$version"
                const val extensions = "androidx.lifecycle:lifecycle-extensions:$version"
            }

            object Room {
                private const val version = "2.1.0-alpha03"
                const val apt = "androidx.room:room-compiler:$version"
                const val runtime = "androidx.room:room-runtime:$version"
                const val rxJava2 = "androidx.room:room-rxjava2:$version"
            }
        }
    }

    object Rx {
        const val android = "io.reactivex.rxjava2:rxandroid:2.1.0"
        const val java = "io.reactivex.rxjava2:rxjava:2.2.4"
        const val preferences = "com.f2prateek.rx.preferences2:rx-preferences:2.0.0"
        const val relay = "com.jakewharton.rxrelay2:rxrelay:2.1.0"

        object Binding {
            const val core = "com.jakewharton.rxbinding2:rxbinding-kotlin:${Versions.rxbinding}"
            const val v4 = "com.jakewharton.rxbinding2:rxbinding-support-v4-kotlin:${Versions.rxbinding}"
            const val design = "com.jakewharton.rxbinding2:rxbinding-design-kotlin:${Versions.rxbinding}"
        }
    }

    object Retrofit {
        const val core = "com.squareup.retrofit2:retrofit:${Versions.retrofit}"

        object Debug {
            const val mock = "com.squareup.retrofit2:retrofit-mock:${Versions.retrofit}"
        }

        const val moshi = "com.squareup.retrofit2:converter-moshi:${Versions.retrofit}"
        const val rxJava2 = "com.squareup.retrofit2:adapter-rxjava2:${Versions.retrofit}"
        const val coroutines = "com.jakewharton.retrofit:retrofit2-kotlin-coroutines-adapter:0.9.2"
    }

    object Okhttp {
        const val core = "com.squareup.okhttp3:okhttp:${Versions.okhttp}"

        object Debug {
            const val loggingInterceptor = "com.squareup.okhttp3:logging-interceptor:${Versions.okhttp}"
        }

        object Test {
            const val mockwebserver = "com.squareup.okhttp3:mockwebserver:${Versions.okhttp}"
        }
    }

    object Misc {
        const val bugsnag = "com.bugsnag:bugsnag-android:4.9.3"

        object Debug {
            const val flipper = "com.facebook.flipper:flipper:0.13.0"
            const val telescope = "com.mattprecious.telescope:telescope:2.1.0"
        }

        const val klint =  "org.jlleitschuh.gradle:ktlint-gradle:${Versions.klint}"
        const val gestureViews = "com.alexvasilkov:gesture-views:2.2.0"
        const val lottie = "com.airbnb.android:lottie:2.8.0"
        const val okio = "com.squareup.okio:okio:2.1.0"
        const val recyclerViewAnimators = "jp.wasabeef:recyclerview-animators:3.0.0"
        const val timber = "com.jakewharton.timber:timber:4.7.1"
        const val moshi = "com.squareup.moshi:moshi-kotlin:${Versions.moshi}"
    }

    object Stetho {
        object Debug {
            const val core = "com.facebook.stetho:stetho:${Versions.stetho}"
            const val okhttp = "com.facebook.stetho:stetho-okhttp3:${Versions.stetho}"
            const val timber = "com.facebook.stetho:stetho-timber:${Versions.stetho}"
        }
    }


    object Test {
        object Android {
            object Espresso {
                const val core = "androidx.test.espresso:espresso-core:${Versions.espresso}"
                const val contrib = "androidx.test.espresso:espresso-contrib:${Versions.espresso}"
                const val web = "androidx.test.espresso:espresso-web:${Versions.espresso}"
            }

            const val runner = "androidx.test:runner:${Versions.androidTestSupport}"
            const val rules = "androidx.test:rules:${Versions.androidTestSupport}"
        }

        const val junit = "junit:junit:4.12"
        const val robolectric = "org.robolectric:robolectric:4.0-alpha-1"
        const val mockk = "io.mockk:mockk:${Versions.mockk}"
    }
}
