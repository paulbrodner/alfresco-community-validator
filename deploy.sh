#!/usr/bin/env bash
set -e  # exit if commands fails

mvn --batch-mode release:prepare release:perform "-Darguments=-Dmaven.test.skip=true"
