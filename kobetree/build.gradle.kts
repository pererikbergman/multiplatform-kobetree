plugins {
    alias(libs.plugins.kotlinMultiplatform)
    alias(libs.plugins.androidLibrary)
    id("maven-publish")
}

group = "com.rakangsoftware.kobetree"
version = "0.1.0"

kotlin {
    androidTarget {
        compilations.all {
            kotlinOptions {
                jvmTarget = "1.8"
            }
        }
        publishLibraryVariants("release", "debug")
    }
    
    listOf(
        iosX64(),
        iosArm64(),
        iosSimulatorArm64()
    ).forEach {
        it.binaries.framework {
            baseName = "kobetree"
            isStatic = true
        }
    }

    sourceSets {
        commonMain.dependencies {
            //put your multiplatform dependencies here
            implementation ("org.jetbrains.kotlin:kotlin-stdlib-jdk8:1.9.21")


        }
        commonTest.dependencies {
            implementation(libs.kotlin.test)

//            implementation("org.junit.jupiter:junit-jupiter-api:5.8.1")
//            implementation("org.junit.jupiter:junit-jupiter-engine:5.8.1")
//            implementation("org.junit.jupiter:junit-jupiter-params:5.8.1")
//            implementation("org.mockito:mockito-core:5.3.1")
//            implementation ("org.mockito.kotlin:mockito-kotlin:5.1.0")
//            implementation("io.mockative:mockative:2.0.1")

        }
    }
}

android {

    namespace = "com.rakangsoftware.kobetree"
    compileSdk = 34
    defaultConfig {
        minSdk = 24
    }
}

publishing {
    publications {
//        // iOS arm64
//        create<MavenPublication>("iosArm64") {
//            groupId = "com.rakangsoftware.kobetree"
//            artifactId = "kobetree-iosarm64"
//            version = "0.2.0"
//
//            // Metadata artifact
//            artifact("$buildDir/outputs/kobetree-iosarm64-metadata.jar")
//
//            // Sources artifact
//            val iosArm64SourcesJar by tasks.registering(Jar::class) {
//                archiveClassifier.set("iosarm64-sources")
//                from(kotlin.sourceSets["iosArm64Main"].kotlin)
//            }
//            artifact(iosArm64SourcesJar)
//        }
//
//        // iOS arm64
//        create<MavenPublication>("iosSimulatorArm64") {
//            groupId = "com.rakangsoftware.kobetree"
//            artifactId = "kobetree-iossimulatorarm64"
//            version = "0.2.0"
//
//            // Metadata artifact
//            artifact("$buildDir/outputs/kobetree-iosarm64-metadata.jar")
//
//            // Sources artifact
//            val iosArm64SourcesJar by tasks.registering(Jar::class) {
//                archiveClassifier.set("iosarm64-sources")
//                from(kotlin.sourceSets["iosArm64Main"].kotlin)
//            }
//            artifact(iosArm64SourcesJar)
//        }

//        create<MavenPublication>("iosarm64") {
//            groupId = "com.rakangsoftware.kobetree"
//            artifactId = "kobetree"
//            version = "0.2.0"
//            artifact("${layout.buildDirectory.get().asFile}/libs/kobetree-kotlin-sources.jar")
//        }
    }

    repositories {
        maven {
            name = "GitHubPackages"
            url = uri("https://maven.pkg.github.com/pererikbergman/kobetree-lib")
            credentials {
                username = project.findProperty("GPR_USER") as String? ?: System.getenv("GPR_USER")
                password =
                    project.findProperty("GPR_API_KEY") as String? ?: System.getenv("GPR_API_KEY")
            }
        }
    }
}