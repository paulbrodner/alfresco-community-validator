#!/usr/bin/env bash
set -e  # exit if commands fails

mvn --batch-mode -Darguments="-Dmaven.test.skip=true" -DskipTests release:prepare release:perform
