package store.model.items

class Sale (var salePercent: Double) extends Modifier {

  override def updatePrice(price: Double): Double = {
    val discount = price * (salePercent / 100)
    price - discount
  }


}
