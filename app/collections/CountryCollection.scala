package collections

import javax.inject.{Inject, Singleton}

import domains.Country
import play.api.libs.json.Json
import play.modules.reactivemongo.ReactiveMongoApi
import play.modules.reactivemongo.json.JsObjectDocumentWriter
import reactivemongo.play.json.collection.JSONCollection

import scala.concurrent.ExecutionContext.Implicits.global
import scala.concurrent.Future
import reactivemongo.play.json.BSONFormats._

/**
  * @author anand
  */
@Singleton
class CountryCollection @Inject()(mongoApi: ReactiveMongoApi) {

  implicit val countryFormat = Json.format[Country]

  private def countries: Future[JSONCollection] = mongoApi.database.map(_.collection[JSONCollection]("countries"))

  def search(): Future[List[Country]] = {
    val query = Json.obj("_id" -> Json.obj("$exists" -> true))
    countries.flatMap(_.find(query).cursor[Country]().collect[List]())
  }

}