package repositories

import model.Player

/**
 * Created by Marcin Czapla on 2015-02-06.
 */
object PlayerRepository {
  var players = List[Player](Player(1, "John"), Player(2, "Sara"), Player(5, "Artur"), Player(4, "Joana"))
  def getAllPlayers : List[Player] = {
    players
  }

  def findById(id:Int) : Option[Player] = {
   val player = players.find(p => p.id==id)
    player
  }

  def deleteById(id: Int) ={
    players = players.filter(p => p.id!=id)
  }
}
