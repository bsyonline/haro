#!/bin/bash
SCRIPT_PATH=`readlink -f "$0"`;
cd `dirname ${SCRIPT_PATH}`
git pull
VERSION=`ls target/*.tar.gz |awk 'BEGIN{FS="[-.]"} END{print $3}'`
echo $VERSION
fab deploy:$VERSION
rm -rf target/*.tar.gz

