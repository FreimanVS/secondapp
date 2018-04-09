#!/bin/bash
docker rm -f secondapp_db_1 secondapp_web_1
docker rmi secondapp_db secondapp_web
docker network rm secondapp_default