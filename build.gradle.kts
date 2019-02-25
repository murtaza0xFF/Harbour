buildscript {
    repositories {
        google()
        jcenter()

    }
    dependencies {
        classpath(Deps.android_gradle_plugin)
        classpath(Deps.kotlin_gradle_plugin)
        // NOTE: Do not place your application dependencies here; they belong
        // in the individual module build.gradle files
    }
}

allprojects {
    repositories {
        google()
        jcenter()

    }
}

tasks {
    val clean by registering(Delete::class) {
        delete(rootProject.buildDir)
    }
}
