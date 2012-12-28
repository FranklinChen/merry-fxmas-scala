package com.franklinchen

import language.experimental.macros
import scala.reflect.macros.Context

object Macros {
  def repeatMessage(n: Int): Unit = macro repeatMessageMacro

  def repeatMessageMacro(c: Context)(n: c.Expr[Int]): c.Expr[Unit] = {
    import c.universe._

    // Assume integer passed is constant
    val Literal(Constant(num: Int)) = n.tree

    // Not only unroll, but also construct the strings at compile time
    val unrolledSeq = num to 1 by -1 map { i =>
      val s = "Merry Christmas Bill " + i + "!"

      // For fun, use quasiquotes instead of calling reify/splice
      q"println($s)"
    }

    // TODO I don't know how to do this with quasiquotes.
    c.Expr(Block(unrolledSeq:_*))
  }
}
