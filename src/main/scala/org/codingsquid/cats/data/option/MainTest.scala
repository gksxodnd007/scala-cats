package org.codingsquid.cats.data.option

import cats.data.OptionT
import cats.implicits._

import scala.concurrent.ExecutionContext
import scala.concurrent.ExecutionContext.Implicits

/**
 *
 * @author hubert.squid
 * @since 2020.04.01
 */
object MainTest {

  implicit private val ec: ExecutionContext = Implicits.global

  private val userService = new UserService
  private val accountService = new AccountService

  def main(args: Array[String]): Unit = {
    notUseCats()
    useCustomMonadTransformer()
    useCats()
  }

  def notUseCats(): Unit = {
    (for {
      user <- userService.getById(1L)
      account <- accountService.getById(1L)
    } yield {
      for {
        userOpt <- user
        accountOpt <- account
      } yield s"${userOpt.name} : ${accountOpt.account}"
    }).map(_.map(println))

    Thread.sleep(500)
  }

  def useCats(): Unit = {
    (for {
      user <- OptionT(userService.getById(1L))
      account <- OptionT(accountService.getById(1L))
    } yield {
      s"${user.name} : ${account.account}"
    }).value.map(_.map(println))

    Thread.sleep(500)
  }

  def useCustomMonadTransformer(): Unit = {
    (for {
      user <- CustomFutureOpt(userService.getById(1L))
      account <- CustomFutureOpt(accountService.getById(1L))
    } yield {
      s"${user.name} : ${account.account}"
    }).value.map(_.map(println))

    Thread.sleep(500)
  }
}
