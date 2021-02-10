package com.example.solution

import com.example.bean.User
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import java.lang.reflect.Type

inline fun <reified T> fromJson2List(json: String) =
  fromJson<List<T>>(json, TypeToken.getParameterized(List::class.java, T::class.java).type)

inline fun <reified T> fromJson(json: String): T? {
  return try {
    val type = object : TypeToken<T>() {}.type
    return Gson().fromJson(json, type)
  } catch (e: Exception) {
    null
  }
}

inline fun <reified T> fromJson(json: String, type: Type): T? {
  return try {
    return Gson().fromJson(json, type)
  } catch (e: Exception) {
    null
  }
}

@Suppress("USELESS_IS_CHECK")
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
  userList.forEach {
    require(it is User)
  }
}
