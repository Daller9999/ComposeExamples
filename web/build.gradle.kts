import org.jetbrains.compose.compose

plugins {
    kotlin("multiplatform") version "1.5.31"
    id("org.jetbrains.compose") version "1.0.0"
}

group = "me.dalerhamzaev"
version = "1.0"

repositories {
    google()
    mavenCentral()
    maven("https://maven.pkg.jetbrains.space/public/p/compose/dev")
    maven("https://maven.pkg.jetbrains.space/kotlin/p/kotlin/kotlin-js-wrappers")
}

kotlin {
    js(IR) {
        browser {
            testTask {
                testLogging.showStandardStreams = true
                useKarma {
                    useChromeHeadless()
                    useFirefox()
                }
            }
        }
        binaries.executable()
    }
    sourceSets {
        val jsMain by getting {
            dependencies {
                val ktor = "1.5.4"
                implementation(compose.web.core)
                implementation(compose.runtime)
                implementation(npm("react", "17.0.2"))
                implementation(npm("react-dom", "17.0.2"))
//                implementation("io.ktor:ktor-client-core:$ktor")
//                implementation("io.ktor:ktor-client-js:$ktor")
//                implementation("io.ktor:ktor-client-serialization:1.6.8")
            }
        }
        val jsTest by getting {
            dependencies {
                implementation(kotlin("test-js"))
            }
        }
    }
}
