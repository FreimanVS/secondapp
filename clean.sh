#!/bin/bash
docker rm -f secondappmaster_db_1 secondappmaster_web_1
docker rmi secondappmaster_db secondappmaster_web
docker network rm secondappmaster_default