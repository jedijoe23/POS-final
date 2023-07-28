package store.model.items

import store.model.items.Modifier

class Item(var name: String, var cost: Double)  {

  var modList: List[Modifier] = List()

  def description(): String = {
    name
  }

  def price(): Double = {
    var disCost: Double = cost
    for (mod <- modList){
      disCost = mod.updatePrice(disCost)
    }
    disCost
  }

  def setBasePrice(newCost: Double): Unit = {
    cost = newCost
  }

  def addModifier(mod: Modifier): Unit = {
    modList = modList :+ mod
  }

  def tax(): Double = {
    val disCost = price()
    var totalTax: Double = 0.0
    for (mod <- modList){
      totalTax += mod.computeTax(disCost)
    }
    totalTax
  }


}
