def call() {

    dependencyCheck(
        odcInstallation: 'OWASP',
        nvdCredentialsId: 'nvd-api-key',
        additionalArguments:  '--scan . \'
    )

    dependencyCheckPublisher(
        pattern: '**/dependency-check-report.xml',
    )
}   
