#! /bin/sh

if [ -z $1 ]; then
  echo "Please provide input filename, Parameter 1 is empty"
  exit 0
else
  java -cp ../target/ex3WordCount-0.0.1-SNAPSHOT.jar interview.exercises.wordcount.ExerciseWordCountMain $1
fi
