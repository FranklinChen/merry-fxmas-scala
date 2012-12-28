# merry-fxmas

Say "Merry Christmas" 25 times counting down, in [Scala](http://www.scala-lang.org/), using a [macro](http://docs.scala-lang.org/overviews/macros/overview.html) to unroll the loop.

For fun, I used a [quasiquote](http://docs.scala-lang.org/overviews/macros/quasiquotes.html) where I could.

The build uses [macro paradise](http://docs.scala-lang.org/overviews/macros/paradise.html) to get the bleeding edge stuff on macros for the upcoming Scala 2.11.

## Usage

Install [SBT](http://www.scala-sbt.org/) if you don't already have it.

To see the output:

```
$ sbt run
```
