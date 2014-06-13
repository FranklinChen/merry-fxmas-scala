package com.franklinchen

import language.experimental.macros
import scala.reflect.macros.blackbox.Context

object Macros {
  def repeatMessage(n: Int): Unit = macro repeatMessageMacro

  def repeatMessageMacro(c: Context)(n: c.Tree) = {
    import c.universe._

    // Assume integer passed is constant
    val Literal(Constant(num: Int)) = n

    // Not only unroll, but also construct the strings at compile time
    val unrolledSeq = num to 1 by -1 map { i =>
      val s = "Merry Christmas Bill " + i + "!"

      q"println($s)"
    }

    q"{ ..$unrolledSeq }"
  }
}
