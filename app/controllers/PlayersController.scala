package controllers

import model.Player
import play.api.libs.json.{JsValue, JsPath, Writes}
import play.api.mvc.{Action, Controller}
import play.api.libs.json._
import repositories.PlayerRepository

/**
 * Created by Marcin Czapla on 2015-02-06.
 */
object PlayersController extends Controller{

  implicit val playerWrites = new Writes[Player] {
    override def writes(player: Player): JsValue = Json.obj("id" -> player.id,"name" -> player.name)
  }

  def all = Action{
    val players = PlayerRepository.getAllPlayers
    Ok(Json.toJson(players))
  }

  def find(id : Int) = Action{
    val player = PlayerRepository.findById(id)
    if (!player.isEmpty){
      Ok(Json.toJson(player))
    } else {
      NotFound(s"player with id=$id not found")
    }
  }

  def delete(id: Int) = Action{
    val deleted = PlayerRepository.deleteById(id)

    NotImplemented
  }

  def edit = Action{
    NotImplemented
  }

  def add = Action{
    NotImplemented
  }


}
