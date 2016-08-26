package collections

import javax.inject.{Inject, Singleton}

import domains.Country
import play.api.libs.json.Json
import play.modules.reactivemongo.ReactiveMongoApi
import play.modules.reactivemongo.json.JsObjectDocumentWriter
import reactivemongo.play.json.collection.JSONCollection

import scala.concurrent.ExecutionContext.Implicits.global
import scala.concurrent.Future

/**
  * @author anand
  */
@Singleton
class CountryCollection @Inject()(mongoApi: ReactiveMongoApi) {

  import reactivemongo.play.json.BSONFormats._
  implicit val countryFormat = Json.format[Country]

  private def countries: Future[JSONCollection] = mongoApi.database.map(_.collection[JSONCollection]("countries"))

  def search(criteria: String): Future[List[Country]] = {
    val query = Json.obj("$text" -> Json.obj("$search" -> criteria))
    countries.flatMap(_.find(query).cursor[Country]().collect[List]())
  }

}