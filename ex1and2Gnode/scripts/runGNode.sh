#! /bin/sh

if [ -z $1 ]; then
  echo "Please provide input action of walkGraph or path, Parameter 1 is empty"
  exit 0
else
  java -cp ../target/ex1and2Gnode-0.0.1-SNAPSHOT.jar interview.exercises.gnode.ExerciseGnode $1
fi
