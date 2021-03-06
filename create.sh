#!/usr/bin/env bash

aws lambda create-function \
--region eu-central-1 \
--function-name aws-lambda-java-template \
--zip-file fileb://target/aws-lambda-java-template-0.0.1.jar \
--role ROLE_ARN \
--handler at.goosefraba.aws.lambda.template.Application \
--runtime java8 \
--timeout 30 \
--memory-size 256 \
--profile $1
