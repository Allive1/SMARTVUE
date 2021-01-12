pipeline {
    agent any

    tools {
        // Install the Maven version configured as "M3" and add it to the path.
        maven "M3"
        gradle "G6"
    }

    stages {
        stage('Git') {
            steps {
                // Get some code from a GitHub repository
                git 'https://github.com/Allive1/SmartVue.git'
                bat "dir"
            }
        }
        stage('Build') {
            steps {
                // Get some code from a GitHub repository
                // dir('SmartVue'){
                 configFileProvider(
                        [configFile(fileId: '97de7780-748c-4ad8-afdc-d5972220653c', variable: 'SDK_SETTINGS')]) {
                        bat "del local.properties"
                        bat "copy $SDK_SETTINGS local.properties"
                        bat """
                        set ANDROID_SDK_ROOT=C:\\Users\\Omi\\AppData\\Local\\Android\\Sdk
                        ${WORKSPACE}\\gradlew.bat build
                        """
                    }

                // }
            }
        }
    }
}
