package domains

import reactivemongo.bson.BSONObjectID

/**
  * Created by imana on 8/26/2016.
  */
case class Country
(
  _id: BSONObjectID,
  country_id: Long,
  code: String,
  name: String,
  continent: String,
  wikipedia_link: String,
  keywords: String
)
