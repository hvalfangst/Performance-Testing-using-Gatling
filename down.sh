#!/bin/sh

# Exits immediately if a command exits with a non-zero status
set -e

docker-compose -f "db/heroes/docker-compose.yml" down;