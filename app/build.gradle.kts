plugins {
    alias(libs.plugins.androidApplication)
    alias(libs.plugins.jetbrainsKotlinAndroid)
}

android {
    namespace = "com.example.humo1"
    compileSdk = 34

    defaultConfig {
        applicationId = "com.example.humo1"
        minSdk = 23
        targetSdk = 34
        versionCode = 1
        versionName = "1.0"

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
    }

    buildTypes {
        release {
            isMinifyEnabled = false
            proguardFiles(
                getDefaultProguardFile("proguard-android-optimize.txt"),
                "proguard-rules.pro"
            )
        }

        debug{

        }
    }
    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_1_8
        targetCompatibility = JavaVersion.VERSION_1_8
        //версия java-машины для компиляции
    }
    kotlinOptions {
        jvmTarget = "1.8"
    }
}

dependencies {

    implementation(libs.androidx.core.ktx)
    implementation(libs.androidx.appcompat) //умеет совмещать код под разные андроиды
    implementation(libs.material) //дизайн системы
    implementation(libs.androidx.activity) //
    implementation(libs.androidx.constraintlayout)
    testImplementation(libs.junit) //в итоговой сборке не будет
    androidTestImplementation(libs.androidx.junit) // так же не будет
    androidTestImplementation(libs.androidx.espresso.core)
    //базовые вещи для запуска
}