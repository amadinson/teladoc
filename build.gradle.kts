plugins {
    id("java")
}

group = "org.health"
version = "1.0-SNAPSHOT"

java {
    sourceCompatibility = JavaVersion.VERSION_17
    targetCompatibility = JavaVersion.VERSION_17
    withSourcesJar()
}

repositories {
    mavenCentral()
}

dependencies {
    implementation("org.apache.logging.log4j:log4j-api:2.20.0")
    implementation("org.apache.logging.log4j:log4j-core:2.20.0")
    testImplementation(platform("org.junit:junit-bom:5.9.1"))
    testImplementation("org.junit.jupiter:junit-jupiter")
}

tasks.test {
    useJUnitPlatform()
}

tasks.jar {
    archiveFileName.set("App.jar")
    manifest {
        attributes(mapOf("Main-Class" to "org.health.SumStringsAsNumber",
                         "Class-Path" to configurations.compileClasspath.get().joinToString(" ")))
    }
}