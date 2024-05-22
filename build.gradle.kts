// Top-level build file where you can add configuration options common to all sub-projects/modules.
plugins {
    id("com.android.application") version "8.2.2" apply false
    id("org.jetbrains.kotlin.android") version "1.9.22" apply false
}

buildscript {
    repositories {
        google()
        mavenCentral()
    }
    dependencies {
        classpath("com.android.tools.build:gradle:7.3.1")  // Update with your version
        classpath("org.jetbrains.kotlin:kotlin-gradle-plugin:1.7.10")  // Update with your version
        classpath("androidx.navigation:navigation-safe-args-gradle-plugin:2.5.0")  // Safe Args plugin
    }
}