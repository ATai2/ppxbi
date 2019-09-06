#!/usr/bin/env bash

echo 'start to build common module'
funcDir(){
  cd $1
  if test -e "docker"
    then echo "has docker dir"
    mvn clean package
    mvn com.spotify:docker-maven-plugin:1.1.1:build
    mvn com.spotify:docker-maven-plugin:1.1.1:push

  else
    echo "$1 does not contain docker dir"
    fi
  cd ..
  echo "  "
}




cd ./ppx-common
pwd
mvn clean package
mvn install
#mvn com.spotify:docker-maven-plugin:1.1.1:build
cd ..
filelist=`ls ./`
pattern="^ppx-"
for file in $filelist
do
#  echo $file
  if [[ $file =~ $pattern ]];  then
    echo "right $file"
    funcDir $file
  fi
done


