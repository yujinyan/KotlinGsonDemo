package com.example.test


import com.example.bean.User
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken

inline fun <reified T> fromJson2List(json: String) = fromJson<List<T>>(json)

inline fun <reified T> fromJson(json: String): T? {
  return try {
    val type = object : TypeToken<T>() {}.type
    return Gson().fromJson(json, type)
  } catch (e: Exception) {
    null
  }
}


fun main() {
  val user = fromJson<User>("""{"name": "张三"}""")
  println(user)

  val users = fromJson<List<User>>("""[{"name": "张三"},{"name": "李四"}]""")!!
  println(users)
  users.forEach {
    require(it is User)
  }

  val userList = fromJson2List<User>("""[{"name": "张三"},{"name": "李四"}]""")!!
  println(userList)
  try {
    val firstUser = userList[0]
  } catch (e: ClassCastException) {
    println("caught $e")
  }
}
