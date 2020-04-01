package org.codingsquid.cats

import cats.data.OptionT
import cats.implicits._

import scala.concurrent.{ExecutionContext, Future}
import scala.concurrent.ExecutionContext.Implicits

/**
 *
 * @author hubert.squid
 * @since 2020.03.25
 */
object CatsDemoApp extends App {

  implicit val ec: ExecutionContext = Implicits.global

  quickStart()
  Thread.sleep(100)

  private def quickStart(): Unit = {
    val f: Future[Option[String]] = Future.successful(Some("hello cats world"))
    OptionT(f).map(_ + "!!").value.map(println)
  }
}
