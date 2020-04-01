package org.codingsquid.cats.data.option

import scala.concurrent.{ExecutionContext, Future}

/**
 *
 * @author hubert.squid
 * @since 2020.04.02
 */
case class CustomFutureOpt[T](value: Future[Option[T]])(implicit ec: ExecutionContext) {

  def map[R](f: T => R): CustomFutureOpt[R] = {
    CustomFutureOpt(value.map(e => e.map(f)))
  }

  def flatMap[R](f: T => CustomFutureOpt[R]): CustomFutureOpt[R] = {
    CustomFutureOpt(value.flatMap {
      case Some(v) => f(v).value
      case None => Future.successful(None)
    })
  }
}
