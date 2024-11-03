plugins {
    alias(libs.plugins.android.application)
    alias(libs.plugins.jetbrains.kotlin.android)
    alias(libs.plugins.google.gms.google.service)
}

android {
    namespace = libs.versions.id.get()

    defaultConfig {
        applicationId = libs.versions.id.get()
    }
    dataBinding { // TODO
        enable = true
    }
}

dependencies {
    implementation(libs.androidx.core.ktx)
    implementation(libs.androidx.appcompat)
    implementation(libs.material)
    testImplementation(libs.junit)
    androidTestImplementation(libs.androidx.junit)
    androidTestImplementation(libs.androidx.espresso.core)

    // all module for build dependency
    implementation(project(":domain"))
    implementation(project(":data"))
    implementation(project(":firebase"))
    implementation(project(":presenter"))
    implementation(project(":util"))
}