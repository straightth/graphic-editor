plugins {
    java
    id("org.openjfx.javafxplugin") version "0.0.10"
}

group = "com.github.straightth"
version = "1.0-SNAPSHOT"

repositories {
    mavenCentral()
}

dependencies {
    implementation("org.jetbrains:annotations:16.0.2")
    implementation(group = "org.fxmisc.richtext", name= "richtextfx", version= "0.10.6")
    testImplementation("org.junit.jupiter:junit-jupiter-api:5.6.0")
    testRuntimeOnly("org.junit.jupiter:junit-jupiter-engine")
}

tasks.getByName<Test>("test") {
    useJUnitPlatform()
}

javafx {
    version = "16"
    modules("javafx.controls", "javafx.swing", "javafx.fxml")
}
