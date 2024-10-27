pluginManagement {
    repositories {
        gradlePluginPortal()
        google()
        mavenCentral()
    }
}

dependencyResolutionManagement {
    repositoriesMode.set(RepositoriesMode.FAIL_ON_PROJECT_REPOS)
    repositories {
        google()
        mavenCentral()
    }
    versionCatalogs {
        create("libs") {
            // Definir las versiones
            version("kotlin", "1.9.0")
            version("android-gradle-plugin", "8.1.1")
            version("navigation", "2.7.3")
            version("core-ktx", "1.10.1")
            version("appcompat", "1.6.1")
            version("material", "1.9.0")
            version("constraintlayout", "2.1.4")
            version("junit", "4.13.2")
            version("espresso-core", "3.5.1")
            version("androidx-junit", "1.1.5")

            // Definir las librerías
            library("kotlin-stdlib", "org.jetbrains.kotlin", "kotlin-stdlib").versionRef("kotlin")
            library("androidx-core-ktx", "androidx.core", "core-ktx").versionRef("core-ktx")
            library("androidx-appcompat", "androidx.appcompat", "appcompat").versionRef("appcompat")
            library("material", "com.google.android.material", "material").versionRef("material")
            library("constraintlayout", "androidx.constraintlayout", "constraintlayout").versionRef("constraintlayout")
            library("navigation-fragment-ktx", "androidx.navigation", "navigation-fragment-ktx").versionRef("navigation")
            library("navigation-ui-ktx", "androidx.navigation", "navigation-ui-ktx").versionRef("navigation")
            library("junit", "junit", "junit").versionRef("junit")
            library("espresso-core", "androidx.test.espresso", "espresso-core").versionRef("espresso-core")
            library("androidx-junit", "androidx.test.ext", "junit").versionRef("androidx-junit")

            // Definir los plugins
            plugin("android-application", "com.android.application").versionRef("android-gradle-plugin")
            plugin("kotlin-android", "org.jetbrains.kotlin.android").versionRef("kotlin")
            plugin("androidx-navigation-safe-args", "androidx.navigation.safeargs.kotlin").versionRef("navigation")
        }
    // No es necesario volver a declarar el catálogo aquí
}

}
rootProject.name = "Onepiece_Final"
include(":app")
