#!/bin/sh
cd /Users/Rob/git/StatesHotOrCold/States
mvn clean install
cd /Developer/apache-tomcat-7.0.61/webapps
./../bin/shutdown.sh
rm -rf States*
cp /Users/rob0229/git/StatesHotOrCold/States/target/States.war .
./../bin/startup.sh