plugins {
    alias(libs.plugins.android.library)
    alias(libs.plugins.jetbrains.kotlin.android)
}

android {
    namespace = "${libs.versions.id.get()}.data"
}

dependencies {
    // Import the BoM for the Firebase platform
    implementation(platform(libs.google.firebase.bom))

    // Add the dependency for the Realtime Database library
    // When using the BoM, you don't specify versions in Firebase library dependencies
    implementation(libs.google.firebase.database.ktx)

    // test
    testImplementation(libs.junit)
    androidTestImplementation(libs.androidx.junit)

    // module dependency
    implementation(project(":domain"))

    // global dependency
    implementation(project(":util"))
}