allprojects {
    repositories {
        google()
        mavenCentral()
    }
}

val newBuildDir: Directory = rootProject.layout.buildDirectory.dir("../../build").get()
rootProject.layout.buildDirectory.value(newBuildDir)
subprojects {
    afterEvaluate {
        if (plugins.hasPlugin("com.android.library") || plugins.hasPlugin("com.android.application")) {
            plugins.withId("com.android.library") {
                extensions.configure<com.android.build.gradle.LibraryExtension>("android") {
                    if (namespace == null) {
                        namespace = project.group.toString()
                    }
                }
            }
            plugins.withId("com.android.application") {
                extensions.configure<com.android.build.gradle.AppExtension>("android") {
                    if (namespace == null) {
                        namespace = project.group.toString()
                    }
                }
            }
        }
    }
}
subprojects {
    val newSubprojectBuildDir: Directory = newBuildDir.dir(project.name)
    project.layout.buildDirectory.value(newSubprojectBuildDir)
}
subprojects {
    project.evaluationDependsOn(":app")
}


tasks.register<Delete>("clean") {
    delete(rootProject.layout.buildDirectory)
}
