pipeline {
    agent any

    stages {
        stage('Build') {
            environment {
                MAVEN = credentials('maven')
            }
            steps {
                sh './gradlew -PspongeUsername=$MAVEN_USR -PspongePassword=$MAVEN_PSW ' +
                        'clean build :uploadArchives --refresh-dependencies'
            }
        }
    }
}
