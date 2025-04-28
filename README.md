# Spring Boot With MongoDB

### We will be covering all possible CRUD operations as part of this project by using MongoDB database

### MongoDB is a NoSQL database, meaning it stores data in flexible, JSON-like documents instead of tables. Spring Boot makes it easy to integrate MongoDB using Spring Data MongoDB.

## Mongo DB Commands

#### Start MongoDB
- mongod
#### Connect to MongoDB shell
- mongosh
#### List Databases
- show dbs
#### Switch to a Database
- use mydatabase
#### List Collections (Tables)
- show collections
#### Create a Collection
- db.createCollection("mycollection")
#### Insert Data
- db.mycollection.insertOne({ name: "Sunil", age: 28 })
#### Insert multiple documents
- db.mycollection.insertMany([
  { name: "Sunil", age: 28 },
  { name: "Shyam", age: 28 }
  ])


### Find/Search Data
##### Find all documents
- db.mycollection.find()
##### Find with filter
- db.mycollection.find({ name: "Sunil" })
##### Pretty print results
- Pretty print results


### Update Data
##### Update one document
- db.mycollection.updateOne(
  { name: "John" },
  { $set: { age: 31 } }
  )
##### Update many documents
- db.mycollection.updateMany(
  { age: { $gt: 25 } },
  { $set: { active: true } }
  )


### Delete Data
##### Delete one document
- db.mycollection.deleteOne({ name: "John" })
##### Delete many documents
- db.mycollection.deleteMany({ age: { $lt: 30 } })
#### Drop Collection
- db.mycollection.drop()
#### Drop Database
- db.dropDatabase()



 