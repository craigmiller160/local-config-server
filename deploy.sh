#!/bin/bash

version=$(cat pom.xml | grep version | head -n3 | tail -n1)
version=$(echo $version | sed 's/<version>//g' | sed 's/<\/version>//g')

#if [ $# -ne 1 ]; then
#  echo "Must provide version number"
#  exit 1
#fi

NAME=local-config-server
VERSION=$version

mvn clean package
eval $(minikube docker-env)
docker build -t $NAME:$VERSION .
kubectl delete deployment $NAME
kubectl apply -f deployment.yml
minikube service local-config-server