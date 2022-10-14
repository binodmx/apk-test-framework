#!/bin/sh

# Prerequisites
# ----------------------------------------------------------------------------------------------------------------------
# Install Git, Helm and Kubernetes client.
# Setup Kubernetes cluster.
# Install NGINX Ingress Controller.
# ----------------------------------------------------------------------------------------------------------------------

helm repo add wso2 https://helm.wso2.com && helm repo update
echo "Installing apim..."
helm install am-single wso2/am-single-node --version 4.1.0-1
echo "Waiting until all pods are ready..."
kubectl wait --for=condition=ready pod --selector=deployment=wso2am-single-node-am --timeout=480s
echo "Adding DNS record mapping..."
kubectl get ing -n default | awk '(NR>1) {print $4, $3}' | sudo tee -a /etc/hosts
echo "Running integration tests..."
cd ../sample-java-integration-test
mvn -Dit.test=TC101_VerifyDevportalUserCanCreateAnApplicationIT -Dendpoint=https://am.wso2.com clean verify | tee apim-it-results.log
#echo "Uninstalling apim..."
helm delete am-single
kubectl delete --force all --all
kubectl delete --force pv --all
