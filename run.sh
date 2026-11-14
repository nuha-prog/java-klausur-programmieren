#!/usr/bin/env bash
# Kompiliert alle Aufgaben und führt sie nacheinander aus.
set -e
cd "$(dirname "$0")"
rm -rf out && mkdir out
javac -encoding UTF-8 -d out $(find src -name "*.java")
for klasse in aufgabe1.Main aufgabe2.FizzBuzz aufgabe3.Main aufgabe4.Main aufgabe5.Main aufgabe6.Mystery; do
    echo "=== $klasse ==="
    java -Dstdout.encoding=UTF-8 -cp out "$klasse"
    echo
done
