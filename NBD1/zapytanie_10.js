printjson(db.cw1.updateMany({job:"Editor"}, {$unset: {email:1}})}.toArray())