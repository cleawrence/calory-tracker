plugins {
    id ("com.android.application")
    kotlin("android")
    id ("com.google.dagger.hilt.android")
    id ("kotlin-parcelize")
    id ("kotlin-kapt")
}

android {
    namespace  = ProjectConfig.appId
    compileSdk = ProjectConfig.compileSdk

    defaultConfig {
        applicationId  = ProjectConfig.appId
        minSdk  = ProjectConfig.minSdk
        targetSdk  = ProjectConfig.targetSdk
        versionCode  = ProjectConfig.versionCode
        versionName  = ProjectConfig.versionName

        testInstrumentationRunner = Testing.testHiltRunner
        vectorDrawables {
            useSupportLibrary = true
        }
    }

    buildTypes {
        getByName("release") {
            isMinifyEnabled = false
        }
    }
    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_1_8
        targetCompatibility  = JavaVersion.VERSION_1_8
    }
    kotlinOptions {
        jvmTarget = "1.8"
    }
    buildFeatures {
        compose = true
    }
    composeOptions {
        kotlinCompilerExtensionVersion = Compose.composeCompilerVersion
    }
    testOptions {
        packagingOptions {
            jniLibs {
                useLegacyPackaging = true
            }
        }
    }
    packagingOptions {
        resources.excludes.add("META-INF/AL2.0")
        resources.excludes.add("META-INF/LGPL2.1")
        resources.excludes.add("**/attach_hotspot_windows.dll")
        resources.excludes.add("META-INF/licenses/ASM")
        resources.excludes.add("META-INF/*")
    }
}

dependencies {

    implementation (AndroidX.coreKtx)
    implementation (AndroidX.lifecycleRuntimeKtx)
    implementation (Compose.activityCompose)
    implementation (Compose.uiCompose)
    implementation (Compose.uiToolingPreview)
    implementation (Compose.material)
    implementation (Compose.navigation)
    implementation (Compose.runtime)
    implementation (Compose.hiltNavigationCompose)
    implementation (Compose.viewModelCompose)

    implementation (Google.material)

    androidTestImplementation (Testing.expressoTest)
    debugImplementation (Compose.uiCompose)
    debugImplementation (Testing.composeManifestTest)
    androidTestImplementation (Testing.linkedinDexMakerMockito)

    implementation(project(Modules.core))
    implementation(project(Modules.coreUi))
    implementation(project(Modules.onboardingPresentation))
    implementation(project(Modules.onboardingDomain))
    implementation(project(Modules.trackerPresentation))
    implementation(project(Modules.trackerDomain))
    implementation(project(Modules.trackerData))

    implementation(Coil.coilCompose)

    implementation(Retrofit.okHttp)
    implementation(Retrofit.retrofit)
    implementation(Retrofit.okHttpLoggingInterceptor)
    implementation(Retrofit.moshiConverter)

    testImplementation(Testing.junit4)
    testImplementation(Testing.junitAndroidExt)
    testImplementation(Testing.truth)
    testImplementation(Testing.coroutines)
    testImplementation(Testing.turbine)
    testImplementation(Testing.composeJunitTest)
    testImplementation(Testing.mockk)
    testImplementation(Testing.mockWebServer)

    androidTestImplementation(Testing.junit4)
    androidTestImplementation(Testing.junitAndroidExt)
    androidTestImplementation(Testing.truth)
    androidTestImplementation(Testing.coroutines)
    androidTestImplementation(Testing.turbine)
    androidTestImplementation(Testing.composeJunitTest)
    androidTestImplementation(Testing.mockkAndroid)
    androidTestImplementation(Testing.mockWebServer)
    androidTestImplementation(Testing.hiltTesting)
    kaptAndroidTest(DaggerHilt.hiltCompiler)
    androidTestImplementation(Testing.testRunner)

    kapt(Room.roomCompiler)
    implementation(Room.roomKtx)
    implementation(Room.roomRuntime)

    implementation(DaggerHilt.hiltAndroid)
    kapt(DaggerHilt.hiltCompiler)
}

kapt {
    correctErrorTypes = true
}