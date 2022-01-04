printjson(db.cw1.aggregate({
		"$group":{
		_id:"$job"
	}}
).toArray())