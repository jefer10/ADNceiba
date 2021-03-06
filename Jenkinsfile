pipeline {
  //Donde se va a ejecutar el Pipeline
  agent {
    label 'Slave_Induccion'
  }

  //Opciones específicas de Pipeline dentro del Pipeline
  options {
    	buildDiscarder(logRotator(numToKeepStr: '5'))
 	disableConcurrentBuilds()
  }

  //Una sección que define las herramientas “preinstaladas” en Jenkins
  tools {
    jdk 'JDK11_Centos' //Verisión preinstalada en la Configuración del Master
  }

  //Aquí comienzan los “items” del Pipeline
  stages{
    stage('Checkout') {
      steps{
        echo "------------>Checkout<------------"
        checkout([$class: 'GitSCM', branches: [[name: '*/main']],
        		  			doGenerateSubmoduleConfigurations: false,
        		  			extensions: [],
        		  			gitTool:'Default',
        		  			submoduleCfg: [],
        		  			userRemoteConfigs: [[credentialsId:'GitHub_jefer10',
        		  			url:'https://github.com/jefer10/ADNceiba.git']]])

        // sh 'gradlew clean'
      }
    }

    stage('Compile & Unit Tests') {
      steps{
        echo "------------>Compile & Unit Tests<------------"
            sh "./gradlew compileJava"
            sh "./gradlew test"
      }
    }

    stage('Integration Tests') {
        steps {
               echo "------------>Unit Tests<------------"
               sh './gradlew jacocoTestReport'
               publishHTML (target: [
                        	        reportDir: 'build/reports/jacoco/test/html',
                        			reportFiles: 'index.html',
                        			reportName: 'JacocoReport'
                        	    ])
               sh './gradlew jacocoTestCoverageVerification'

                //sh 'gradlew --stacktrace test'
                //junit '**/build/test-results/test/*.xml'
                //step([$class: 'JacocoPublisher'])
            }
    }

    stage('Static Code Analysis') {
      steps{
        echo '------------>Análisis de código estático<------------'
            withSonarQubeEnv('Sonar') {
                            	sh "${tool name: 'SonarScanner', type: 'hudson.plugins.sonar.SonarRunnerInstallation'}/bin/sonar-scanner"
                                }
      }
    }

    stage('Build') {
      steps {
        echo "------------>Build<------------"
        sh 'gradlew --d --stacktrace ./build.gradle build -x test'
      }
    }
  }

  post {
    always {
      echo 'This will always run'
    }
    success {
      echo 'This will run only if successful'
      junit 'build/test-results/test/*.xml'
    }
    failure {
      echo 'This will run only if failed'
      mail (to: 'jefersson.rondon@ceiba.com.co',
      			    subject: "Failed Pipeline: ${currentBuild.fullDisplayName}",
      			    body: "Something is wrong with ${env.BUILD_URL}")
    }
    unstable {
      echo 'This will run only if the run was marked as unstable'
    }
    changed {
      echo 'This will run only if the state of the Pipeline has changed'
      echo 'For example, if the Pipeline was previously failing but is now successful'
    }
  }
}