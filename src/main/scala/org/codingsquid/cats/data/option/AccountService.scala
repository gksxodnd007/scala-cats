package org.codingsquid.cats.data.option

import scala.concurrent.{ExecutionContext, Future}

/**
 *
 * @author hubert.squid
 * @since 2020.04.01
 */
case class Account(id: Long, userId: Long, account: String)

class AccountService()(implicit ec: ExecutionContext) {

  def getById(id: Long): Future[Option[Account]] = {
    Future.successful(Some(Account(1L, 1L, "110-329-482381")))
  }
}
