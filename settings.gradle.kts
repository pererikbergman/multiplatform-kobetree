enableFeaturePreview("TYPESAFE_PROJECT_ACCESSORS")
pluginManagement {
    repositories {
        google()
        gradlePluginPortal()
        mavenCentral()
    }
}

dependencyResolutionManagement {
    repositories {
        mavenLocal()
        google()
        mavenCentral()
        maven {
            url = uri("https://maven.pkg.github.com/pererikbergman/github-packages")
            credentials {
                username = extra["GPR_USER"] as String? ?:
                        System.getenv("GPR_USER")
                password = extra["GPR_API_KEY"] as String? ?:
                        System.getenv("GPR_API_KEY")
            }
        }
    }
}

rootProject.name = "multiplatform-kobetree"
include(":kobetree")