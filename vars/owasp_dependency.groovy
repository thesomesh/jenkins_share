def call() {

    dependencyCheck(
        odcInstallation: 'OWASP',
        nvdCredentialsId: 'nvd-api-key',
        additionalArguments: '''
            --scan . \
            --format XML \
            --format HTML
        '''
    )

    dependencyCheckPublisher(
        pattern: '**/dependency-check-report.xml',
        failedTotalHigh: 1,
        failedTotalCritical: 1
    )
}    // give  fresher level 
