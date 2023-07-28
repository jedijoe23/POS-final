package store.model.items

class BottleDeposit (var deposit: Double) extends Modifier {

  override def computeTax(price: Double): Double = {
    deposit
  }

}
