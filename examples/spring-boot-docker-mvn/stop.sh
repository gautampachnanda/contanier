#!/bin/sh
grep $containerid running.txt | awk '{print $14}' | xargs docker stop