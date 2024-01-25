pluginManagement {
    repositories {

        google()
        mavenCentral()
        gradlePluginPortal()
        maven("https://jitpack.io")
        mavenCentral()
    }
}
dependencyResolutionManagement {
    repositoriesMode.set(RepositoriesMode.FAIL_ON_PROJECT_REPOS)
    repositories {
        google()
        mavenCentral()
        maven("https://jitpack.io")
    }
}

rootProject.name = "SampleApp"
include(":app",":multiselectionspinner")

 