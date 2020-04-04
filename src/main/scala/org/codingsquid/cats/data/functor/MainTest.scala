package org.codingsquid.cats.data.functor

import cats.Functor
import cats.instances.list._ // for Functor
import cats.instances.option._ // for Functor

/**
 *
 * @author hubert.squid
 * @since 2020.04.04
 */
object MainTest {

  def main(args: Array[String]): Unit = {
    Functor[List].map(List(1, 2, 3))(_ * 2).foreach(println)
    Functor[Option].map(Option("hubert.squid"))(_.toUpperCase()).foreach(println)
  }
}

class CustomOptionFunctor extends Functor[Option] {

  override def map[A, B](fa: Option[A])(f: A => B): Option[B] = {
    fa.map(f)
  }
}