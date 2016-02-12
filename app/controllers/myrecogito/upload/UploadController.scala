package controllers.myrecogito.upload

import akka.actor.ActorSystem
import controllers.{ AbstractController, Security }
import database.DB
import javax.inject.Inject
import jp.t2v.lab.play2.auth.AuthElement
import models.Roles._
import scala.concurrent.Future
import play.api.Logger

class UploadController @Inject() (implicit val db: DB, system: ActorSystem) extends AbstractController with AuthElement with Security {

  def processContentUpload = AsyncStack(AuthorityKey -> Normal) {  implicit request =>
    request.body.asMultipartFormData match {
      
      case Some(formData) => Future.successful {
        formData.file("file") match {
          case Some(filePart) => {
              new GeoParser().parseAsync(filePart.ref.file)
              Ok("")
            }
          case None => 
            BadRequest("Form data missing")
        }
      }
      
      case None => 
        Future.successful(BadRequest("Form data missing"))
      
    }    
  }
  
}