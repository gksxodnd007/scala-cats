package org.codingsquid.cats.data.option

import scala.concurrent.{ExecutionContext, Future}

/**
 *
 * @author hubert.squid
 * @since 2020.04.01
 */
case class User(id: Long, name: String, age: Int)

class UserService()(implicit ec: ExecutionContext) {

  def getById(id: Long): Future[Option[User]] = {
    Future.successful(Some(User(1L, "hubert.squid", 27)))
  }
}
