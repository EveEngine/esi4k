plugins {
    kotlin("jvm") version "1.3.72"
}

group = "com.eve-engine"
version = "0.1.0"

repositories {
    mavenCentral()
}

object Versions {
    const val APACHE = "4.5.12"
    const val JACKSON_KOTLIN = "2.10.1"
}

dependencies {
    implementation("com.fasterxml.jackson.module:jackson-module-kotlin:${Versions.JACKSON_KOTLIN}")
    implementation("org.apache.httpcomponents:httpclient:${Versions.APACHE}")

    implementation(kotlin("stdlib-jdk8"))

    testImplementation("org.junit.jupiter:junit-jupiter:5.6.2")
}

tasks.wrapper {
    gradleVersion = "6.3"
}

tasks.test {
    useJUnitPlatform()
    testLogging {
        events("passed", "skipped", "failed")
    }
}

tasks {
    compileKotlin {
        kotlinOptions.jvmTarget = "11"
    }
    compileTestKotlin {
        kotlinOptions.jvmTarget = "11"
    }
}