plugins {
    alias(libs.plugins.android.application) apply false
    alias(libs.plugins.kotlin.android) apply false
    alias(libs.plugins.androidx.navigation.safe.args) apply false
}
buildscript {
    dependencies {
        classpath ("com.android.tools.build:gradle:8.1.1")
    }
}
