import kotlin.io.println;

plugins {
    id("org.jetbrains.dokka") version "0.10.1"
    kotlin("jvm") version "1.3.72"
    `maven-publish`
    maven
    signing
}

group = "com.eve-engine"
version = "0.1.0"

repositories {
    mavenCentral()
    maven {
        setUrl("https://plugins.gradle.org/m2/")
    }
}

object Versions {
    const val APACHE = "4.5.12"
    const val JACKSON_KOTLIN = "2.10.1"
}

val deployerJars by configurations.creating

dependencies {
    implementation("com.fasterxml.jackson.module:jackson-module-kotlin:${Versions.JACKSON_KOTLIN}")
    implementation("org.apache.httpcomponents:httpclient:${Versions.APACHE}")

    implementation(kotlin("stdlib-jdk8"))

    testImplementation("org.junit.jupiter:junit-jupiter:5.6.2")

    deployerJars("org.apache.maven.wagon-ssh:2.2")
}

val dokkaJar by tasks.creating(Jar::class) {
    archiveClassifier.set("javadoc")
    group = JavaBasePlugin.DOCUMENTATION_GROUP
    description = "Assembles Kotlin docs with Dokka"
    from(tasks.dokka)
}

val sourcesJar by tasks.creating(Jar::class) {
    description = "Assembles Kotlin sources Jar"
    archiveClassifier.set("sources")
    from(sourceSets.main.get().allSource)
}

artifacts {
    archives(sourcesJar)
    archives(dokkaJar)
}

publishing {
    publications {
        create<MavenPublication>("mavenKotlin"){
            from(components["java"])
            artifact(sourcesJar)
            artifact(dokkaJar)
            repositories {
                maven {
                    credentials {
                        username = project.property("ossrhUsername").toString()
                        password = project.property("ossrhPassword").toString()
                    }
                    val releasesRepoUrl = uri("https://oss.sonatype.org/service/local/staging/deploy/maven2/")
                    val snapshotsRepoUrl = uri("https://oss.sonatype.org/content/repositories/snapshots/")
                    url = if (version.toString().endsWith("SNAPSHOT")) snapshotsRepoUrl else releasesRepoUrl
                }
            }
            pom {
                name.set("ESI4K")
                description.set("Lightweight API client that interfaces with Eve Online's ESI API (https://esi.evetech.net/ui/).")
                url.set("eve-engine.com")
                licenses {
                    license {
                        name.set("Apache License 2.0")
                        url.set("http://www.apache.org/licenses/LICENSE-2.0.txt")
                    }
                }
                developers {
                    developer {
                        id.set("dallasphillips24")
                        name.set("Dallas Phillips")
                        email.set("dallasphillips24@gmail.com")
                    }
                }
                scm {
                    scm {
                        connection.set("scm:git:git://github.com/EveEngine/esi4k.git")
                        developerConnection.set("scm:git:ssh://github.com.com/EveEngine/esi4k.git")
                        url.set("http://github.com.com/EveEngine/esi4k")
                    }
                }
            }
        }
    }
}

tasks.named<Upload>("uploadArchives") {
    repositories.withGroovyBuilder {
        "mavenDeployer" {
            var username = project.property("ossrhUsername").toString()
            var password = project.property("ossrhPassword").toString()
            "repository"("url" to "https://oss.sonatype.org/service/local/staging/deploy/maven2/"){
                "authentication"("userName" to username, "password" to password)
            }
            "snapshotRepository"("url" to "https://oss.sonatype.org/content/repositories/snapshots/"){
                "authentication"("userName" to username, "password" to password)
            }
            "pom" {
                "project" {
                    setProperty("name", "ESI4k")
                    setProperty("description", "Lightweight API client that interfaces with Eve Online's ESI API (https://esi.evetech.net/ui/).")
                    setProperty("url", "eve-engine.com")
                    "scm"{
                        setProperty("connection","scm:git:git://github.com/EveEngine/esi4k.git")
                        setProperty("developerConnection", "scm:git:git://github.com/EveEngine/esi4k.git")
                        setProperty("url", "http://github.com.com/EveEngine/esi4k")
                    }
                    "licenses" {
                        "license" {
                            setProperty("name", "Apache License 2.0")
                            setProperty("url", "http://www.apache.org/licenses/LICENSE-2.0.txt")
                        }
                    }
                    "developers" {
                        "developer"{
                            setProperty("id", "dallasphillips24")
                            setProperty("name", "Dallas Phillips")
                            setProperty("email", "dallasphillips24@gmail.com")
                        }
                    }
                }
            }

        }
    }
}

signing {
    sign(publishing.publications["mavenKotlin"])
}

tasks {
    compileKotlin {
        kotlinOptions.jvmTarget = "11"
    }

    compileTestKotlin {
        kotlinOptions.jvmTarget = "11"
    }

    dokka {
        outputFormat = "html"
        outputDirectory = "$buildDir/javadoc"
    }

    javadoc {
        if(JavaVersion.current().isJava11Compatible){
            (options as StandardJavadocDocletOptions).addBooleanOption("html5", true)
        }
    }

    test {
        useJUnitPlatform()
        testLogging {
            events("passed", "skipped", "failed")
        }
    }

    wrapper {
        gradleVersion = "6.3"
    }
}