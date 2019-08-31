
import org.gradle.api.Action
import org.gradle.api.Project
import org.gradle.api.Task
import org.gradle.api.artifacts.dsl.ArtifactHandler
import org.gradle.api.tasks.TaskContainer
import org.gradle.api.tasks.TaskProvider

fun ArtifactHandler.`archives`(artifact: Any) =
        add("archives", artifact)

fun <T : Task> ArtifactHandler.`archives`(artifact: TaskProvider<T>) =
        add("archives", artifact.get())