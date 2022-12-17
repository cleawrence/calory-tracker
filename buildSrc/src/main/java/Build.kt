object Build {
    private const val androidBuildToolsVersion = "7.0.4"
    const val androidBuildTools = "com.android.tools.build:gradle:$androidBuildToolsVersion"

    const val kotlinGradlePlugin = "org.jetbrains.kotlin:kotlin-gradle-plugin:${Kotlin.version}"

    const val hiltAndroidGradlePluginVersion = "2.44.2"
    const val hiltAndroidGradlePlugin = "com.google.dagger:hilt-android-gradle-plugin"
}