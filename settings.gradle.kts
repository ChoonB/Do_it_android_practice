pluginManagement {
    repositories {
        google()
        mavenCentral()
        gradlePluginPortal()
    }
}
dependencyResolutionManagement {
    repositoriesMode.set(RepositoriesMode.FAIL_ON_PROJECT_REPOS)
    repositories {
        google()
        mavenCentral()
    }
}

rootProject.name = "AndroidLab"
include(":app")
include(":ch6_view")
include(":ch7_layout")
include(":ch8_event")
include(":ch9_resource")
include(":ch10_notification")
include(":ch11_jetpack")
include(":ch13_activity")
include(":ch14_receiver")
include(":ch15_outer")
include(":ch15_service")
include(":ch16_provider")
