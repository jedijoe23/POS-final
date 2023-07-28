package store.model.items

abstract class Modifier {

  def updatePrice(price: Double): Double = {
    price
  }

  def computeTax(price: Double): Double = {
    0.0
  }

}
