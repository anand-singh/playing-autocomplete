package controllers

import javax.inject._

import collections.CountryCollection
import domains.Country
import play.api.data.Form
import play.api.data.Forms._
import play.api.libs.json.Json
import play.api.mvc._

import scala.concurrent.{ExecutionContext, Future}
import scala.util.control.NonFatal


/**
  * This controller creates an `Action` to handle HTTP requests to the
  * application's home page.
  */
@Singleton
class HomeController @Inject()
(implicit ec: ExecutionContext,
 webJarAssets: WebJarAssets,
 countryCollection: CountryCollection) extends Controller {

  import reactivemongo.play.json.BSONFormats._
  implicit val countryFormat = Json.format[Country]

  def searchForm = Form(single("criteria" -> nonEmptyText))

  /**
    * Create an Action to render an HTML page with a welcome message.
    * The configuration in the `routes` file means that this method
    * will be called when the application receives a `GET` request with
    * a path of `/`.
    */
  def index = Action {
    Ok(views.html.index("Welcome")(webJarAssets))
  }

  def autocomplete = Action.async { implicit request =>
    searchForm.bindFromRequest.fold(
      formWithErrors => {
        Future(Ok(Json.toJson(List.empty[Country])))
      },
      criteria => {
        countryCollection.search(criteria).map { countries =>
          Ok(Json.toJson(countries))
        }.recover {
          case NonFatal(t) =>
            t.printStackTrace()
            Ok(Json.toJson(List.empty[Country]))
        }
      }
    )
  }

}
