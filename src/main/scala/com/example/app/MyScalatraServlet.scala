package com.example.app

import org.scalatra._
import scalate.ScalateSupport

class MyScalatraServlet extends ScalatrachardetissueStack {
  get("/") {
    serveTextOf(1 << 10)
  }

  get("/:length") {
    val length = params("length").toInt
    serveTextOf(length)
  }

  get("/100k") {
    serveTextOf(100 * (1 << 10))
  }

  get("/megabyte") {
    serveTextOf(1 << 20)
  }

  private def serveTextOf(length: Int): ActionResult = {
    val utf8Body = ("x" * length).getBytes("UTF-8")
    val contentTypeHeader = Map("Content-Type" -> "text/plain; charset=utf-8")
    Ok(utf8Body, contentTypeHeader)
  }
}
