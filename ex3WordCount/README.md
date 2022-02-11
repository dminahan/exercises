# Interview Challenge Exercise 3 - Word Count

## Requirement
Write a quick and dirty program (Shell, Python, Perl, Java, Lisp,
   C++, APL, or whatever) to produce a count of all the different
   &quot;words&quot; in a text file.  Use any definition of word that makes
   logical sense or makes your job easy.  The output might look like
   this:
     17 a
     14 the
      9 of
      9 in
      8 com
      7 you
      7 that
      7 energy
      6 to

## Definition
Blank lines should not add to word count.  Went route of only allowing true words so no characters count (numbers 001, speical characters like ,"# spaces do not count, and case does not matter).

## Tasks which are out of scope
*   No need to create a web interface to upload a file for count processing
*   Just used system out versus logger to log file

## How to run

In script directory there is a shell script that you can execute and some sample files.  It assumes your input file will be in that directory and that the jar is over in ../target.

To run type:
./runWordCount.sh <inputFileName>, i.e. ./runWordCount.sh sayings.txt  


