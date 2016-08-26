package domains

import reactivemongo.bson.BSONObjectID

/**
  * Country class to map with countries collection
  *
  * @param _id            The MongoDB id column
  * @param country_id     The country_id column
  * @param code           The code column
  * @param name           The name column
  * @param continent      The continent column
  * @param wikipedia_link The wikipedia_link column
  * @param keywords       The keywords column
  *
  *                       Created by anand on 8/26/2016
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
