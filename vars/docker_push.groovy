
def call(String Project, String ImageTag) {

    withCredentials([
        usernamePassword(
            credentialsId: 'docker',
            usernameVariable: 'DH_USER',
            passwordVariable: 'DH_PASS'
        )
    ]) {

        sh '''
            echo "$DH_PASS" | docker login \
                --username "$DH_USER" \
                --password-stdin
        '''

        sh "docker push ${DH_USER}/${Project}:${ImageTag}"

        sh 'docker logout'
    }
}

