import kotlin.String

/**
 * Find which updates are available by running
 *     `$ ./gradlew buildSrcVersions`
 * This will only update the comments.
 *
 * YOU are responsible for updating manually the dependency version.
 */
object Versions {
    const val navigation: String = "2.1.0-alpha03"

    const val appcompat: String = "1.1.0-alpha01" 

    const val constraintlayout: String = "1.1.3" 

    const val core_ktx: String = "1.0.2"

    const val androidx_core_core: String = "1.1.0-alpha03" 

    const val androidx_fragment: String = "1.1.0-alpha03" 

    const val navigation_safe_args_gradle_plugin: String = "2.1.0-alpha02"

    const val androidx_preference: String = "1.1.0-alpha02" 

    const val viewpager2: String = "1.0.0-alpha02" 

    const val com_android_tools_build_gradle: String = "3.4.0"

    const val lint_gradle: String = "26.4.0"

    const val material: String = "1.1.0-alpha02" 

    const val com_google_dagger: String = "2.22.1"

    const val firebase_database: String = "17.0.0"

    const val google_services: String = "4.2.0" 

    const val com_jakewharton_rxbinding3: String = "3.0.0-alpha2" 

    const val timber: String = "4.7.1" 

    const val com_spotify_mobius: String = "1.2.2"

    const val moshi_kotlin: String = "1.8.0" 

    const val com_squareup_okhttp3: String = "3.14.1"

    const val com_squareup_retrofit2: String = "2.5.0" 

    const val de_fayard_buildsrcversions_gradle_plugin: String = "0.3.2" 

    const val android_junit5: String = "1.4.2.0"

    const val mockk: String = "1.9.3"

    const val rxandroid: String = "2.1.1" 

    const val rxjava: String = "2.2.8"

    const val junit: String = "4.12" 

    const val org_jetbrains_kotlin: String = "1.3.31"

    const val ktlint_gradle: String = "8.0.0"

    const val org_junit_jupiter: String = "5.4.2"

    /**
     *
     *   To update Gradle, edit the wrapper file at path:
     *      ./gradle/wrapper/gradle-wrapper.properties
     */
    object Gradle {
        const val runningVersion: String = "5.0"

        const val currentVersion: String = "5.4.1"

        const val nightlyVersion: String = "5.5-20190512000035+0000"

        const val releaseCandidate: String = ""
    }
}
