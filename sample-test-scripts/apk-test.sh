#!/bin/sh

# Prerequisites
# ----------------------------------------------------------------------------------------------------------------------
# Install Git, Docker, Helm and Kubernetes client.
# Setup Kubernetes cluster.
# Install NGINX Ingress Controller.
# ----------------------------------------------------------------------------------------------------------------------

repos="https://github.com/BLasan/APKCTL-Demo"

clone_repos() {
    for repo in "$@"
    do
        git clone $repo
    done
}

clean_repos() {
    for repo in "$@"
    do
        directory=`echo $repo | awk '{i=split($0,a,"/"); print a[i];}'`
        rm -rf $directory
    done
}

build() {
    cd APKCTL-Demo/CTL
    go test ./impl -v | tee ../../apkctl-ut-results.log
    go build apkctl.go
    cd ../..
    # - docker build -t wso2/my-app .
}

# $1: apkctl path
deploy_apk() {
    cd APKCTL-Demo/CTL
    ./apkctl install platform
    kubectl wait --for=condition=ready pod --selector=app.kubernetes.io/release=apk-test --timeout=480s
    cd ../..
}

# $1: apkctl path
undeploy_apk() {
    ./APKCTL-Demo/CTL/apkctl uninstall platform
}

# $1: run apkctl tests?
# $2: run API tests?
# $3: run cypress tests?
run_tests() {
    # verify the deployment
    kubectl wait --for=condition=ready pod --selector=app.kubernetes.io/component=controller --timeout=480s

    # run apkctl tests
    if [ $1 = "true" ]
    then
        cd APKCTL-Demo/CTL
        go test ./integration | tee apkctl-it-results.log
        cd ../..
    fi

    # run API tests
    if [ $2 = "true" ]
    then
        cd carbon-apimgt
        git checkout apk-refactor
        mvn clean verify | tee ../api-test-results.log
        cd ..
    fi

    # run cypress tests
    if [ $3 = "true" ]
    then
        npm run test | tee cypress-test-results.log
    fi
}

clone_repos $repos
build
# cluster info should be set in ~/.kube/config
deploy_apk
run_tests true false false
undeploy_apk
clean_repos $repos
