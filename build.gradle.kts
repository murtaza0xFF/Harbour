task("assemble")
apply{from(rootProject.file("git-hooks.gradle"))}
buildscript{
    repositories {
        google()
        jcenter()
        maven {
            setUrl("https://plugins.gradle.org/m2/")
        }
    }
    dependencies {
        classpath(Deps.android_gradle_plugin)
        classpath(Deps.Test.junit5_plugin)
        classpath(Deps.kotlin_noarg)
        classpath(Deps.kotlin_gradle_plugin)
        classpath(Deps.Misc.klint)
        classpath(Deps.Misc.google_services)
    }
}

plugins.apply("org.jlleitschuh.gradle.ktlint")

allprojects {
    repositories {
        google()
        jcenter()
        maven {
            setUrl("https://plugins.gradle.org/m2/")
        }
    }
}

subprojects {
    plugins.apply("org.jlleitschuh.gradle.ktlint")
}

tasks {
    val clean by registering(Delete::class) {
        delete(rootProject.buildDir)
    }
}
