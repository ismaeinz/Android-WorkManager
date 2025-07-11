// Top-level build file where you can add configuration options common to all sub-projects/modules.
plugins {
    alias(libs.plugins.androidApplication) apply false
    alias(libs.plugins.jetbrainsKotlinAndroid) apply false
    alias(libs.plugins.daggerHilt) apply false

    id("com.google.devtools.ksp") version "2.0.21-1.0.27" apply false
}