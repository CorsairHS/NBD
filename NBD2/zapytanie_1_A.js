printjson(db.cw1.aggregate({"$group":{
    _id:"$sex",
    "avg_height": {"$avg":{"$toDouble":"$height"}},
    "avg_weight":{"$avg":{"$toDouble":"$weight"}}
  }}
  ).toArray())