import org.jetbrains.compose.compose
import org.jetbrains.compose.desktop.application.dsl.TargetFormat
import org.jetbrains.kotlin.gradle.tasks.KotlinCompile

plugins {
    kotlin("jvm") version "1.5.31"
    id("org.jetbrains.compose") version "1.0.0"
    id("com.squareup.sqldelight") version "1.5.3"
}

sqldelight {
    database("MonhoDb") {
        packageName = "com.monhodb"
        sourceFolders = listOf("sqldelight")
        dialect = "mysql"
    }
}

group = "me.dalerhamzaev"
version = "1.0"

repositories {
    google()
    mavenCentral()
    maven("https://maven.pkg.jetbrains.space/public/p/compose/dev")
    maven("https://www.jetbrains.com/intellij-repository/releases")
    maven("https://jetbrains.bintray.com/intellij-third-party-dependencies")
}

dependencies {
    implementation(compose.desktop.currentOs)
    implementation("com.squareup.sqldelight:jdbc-driver:1.5.3")
    implementation("com.zaxxer:HikariCP:5.0.1")
    implementation("org.slf4j:slf4j-simple:1.7.36")
    implementation("mysql:mysql-connector-java:8.0.26")
    testImplementation("org.jetbrains.kotlin:kotlin-test:1.5.31")
}

tasks.withType<KotlinCompile> {
    kotlinOptions.jvmTarget = "11"
}

compose.desktop {
    application {
        mainClass = "MainKt"
        nativeDistributions {
            targetFormats(TargetFormat.Dmg, TargetFormat.Msi, TargetFormat.Deb)
            packageName = "Monho"
            packageVersion = "1.0.0"
        }
    }
}