@file:JvmName("JsonTest")

package com.example.test

import com.example.bean.User


fun main() {
  val user = fromJson<User>("""{"name": "张三"}""").also { println(it) }
  val users = fromJson<List<User>>("""[{"name": "张三"},{"name": "李四"}]""").also { println(it) }
  val userList = fromJson2List<User>("""[{"name": "张三"},{"name": "李四"}]""").also { println(it) }
  print("")
}

