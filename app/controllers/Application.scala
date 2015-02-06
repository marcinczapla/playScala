package controllers

import play.api._
import play.api.mvc._

import scala.math.Ordering.String

object Application extends Controller {

  def index = Action {
    Ok(views.html.index("Your new application is ready."))
  }

  def default(path: String) = Action{
    NotFound("not found "+path);
  }

}