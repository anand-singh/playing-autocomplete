package controllers

import javax.inject._

import collections.CountryCollection
import play.api.mvc._

import scala.concurrent.ExecutionContext

/**
  * This controller creates an `Action` to handle HTTP requests to the
  * application's home page.
  */
@Singleton
class HomeController @Inject()(implicit ec: ExecutionContext, webJarAssets: WebJarAssets, countryCollection: CountryCollection) extends Controller {

  /**
    * Create an Action to render an HTML page with a welcome message.
    * The configuration in the `routes` file means that this method
    * will be called when the application receives a `GET` request with
    * a path of `/`.
    */
  def index = Action.async {
    countryCollection.search().map { countries =>
      Ok(views.html.index(countries)(webJarAssets))
    }.recover {
      case t: Exception =>
        InternalServerError(t.getMessage)
    }
  }

}
