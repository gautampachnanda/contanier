#!/bin/sh
source functions.sh
stopContainer
initDockerFile
buildMvn
dockerRun
