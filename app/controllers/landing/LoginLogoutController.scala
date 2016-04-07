package controllers.landing

import controllers.BaseController
import javax.inject.Inject
import jp.t2v.lab.play2.auth.LoginLogout
import models.user.UserService
import play.api.Play.current
import play.api.cache.CacheApi
import play.api.data.Form
import play.api.data.Forms._
import play.api.i18n.Messages.Implicits._
import play.api.libs.concurrent.Execution.Implicits.defaultContext
import play.api.mvc.Action
import scala.concurrent.{ ExecutionContext, Future }
import storage.DB

case class LoginData(username: String, password: String)

class LoginLogoutController @Inject() (implicit val cache: CacheApi, val db: DB) extends BaseController with LoginLogout {

  private val MESSAGE = "message"

  private val INVALID_LOGIN = "Invalid Username or Password"

  val loginForm = Form(
    mapping(
      "username" -> nonEmptyText,
      "password" -> nonEmptyText
    )(LoginData.apply)(LoginData.unapply)
  )

  def showLoginForm = Action { implicit request =>
    Ok(views.html.landing.login(loginForm))
  }

  def processLogin = Action.async { implicit request =>
    loginForm.bindFromRequest.fold(
      formWithErrors =>
        Future(BadRequest(views.html.landing.login(formWithErrors))),

      loginData =>
        UserService.validateUser(loginData.username, loginData.password).flatMap(isValid => {
          if (isValid)
            gotoLoginSucceeded(loginData.username)
          else
            Future(Redirect(routes.LoginLogoutController.showLoginForm()).flashing(MESSAGE -> INVALID_LOGIN))
        })
    )
  }

  def logout = Action.async { implicit request =>
    gotoLogoutSucceeded
  }

}
