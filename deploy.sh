#!/usr/bin/env bash
set -e  # exit if commands fails

mvn --batch-mode -Darguments="-Dmaven.test.skip=true" clean release:prepare release:perform
