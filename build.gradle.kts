plugins {
    id("java")
}

group = "cz.malanak"
version = "1.0-SNAPSHOT"

repositories {
    mavenCentral()
}

dependencies {
    testImplementation(platform("org.junit:junit-bom:5.10.0"))
    testImplementation("org.junit.jupiter:junit-jupiter")
    implementation("com.google.code.gson:gson:2.13.2")
    // https://mvnrepository.com/artifact/com.fasterxml.jackson.dataformat/jackson-dataformat-xml
    implementation("com.fasterxml.jackson.dataformat:jackson-dataformat-xml:2.20.0")
    // https://mvnrepository.com/artifact/com.google.inject/guice
    implementation("com.google.inject:guice:7.0.0")
    // https://mvnrepository.com/artifact/org.quartz-scheduler/quartz
    implementation("org.quartz-scheduler:quartz:2.5.1")
    // https://mvnrepository.com/artifact/org.slf4j/slf4j-reload4j
    implementation("org.slf4j:slf4j-reload4j:2.0.17")
    implementation("org.apache.logging.log4j:log4j-api:2.20.0")
    implementation("org.apache.logging.log4j:log4j-core:2.20.0")
    implementation("org.apache.logging.log4j:log4j-slf4j-impl:2.20.0")
}

tasks.test {
    useJUnitPlatform()
}