printjson(db.cw1.aggregate(
	{$unwind:"$credit"},
	{"$group":{
		_id:"$credit.currency",
		"sum_balance":{"$sum":{$toDouble:"$credit.balance"}}}}
).toArray())