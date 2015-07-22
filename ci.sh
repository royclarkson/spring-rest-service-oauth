#!/bin/bash
cd $(dirname $0)

set -e

./gradlew clean build
rm -rf build

mvn clean package
rm -rf target
