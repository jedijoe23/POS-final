package store.model.items

class SalesTax (var tax: Double) extends Modifier {

  override def computeTax(price: Double): Double = {
    price * (tax / 100)
  }

}
