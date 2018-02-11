#!/bin/sh

xjc xsd/TrainingCenterDatabasev2.xsd -d src/main/java -p com.luxvelocitas.tinytcx.trainingcenterdatabasev2 -b bin -extension -verbose -npa -no-header -encoding "UTF-8"
