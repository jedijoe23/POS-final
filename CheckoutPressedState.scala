package store.model.checkout

class CheckoutPressedState(selfCheckout: SelfCheckout) extends CheckoutState(selfCheckout) {

  override def numberPressed(number: Int): Unit = {}

  override def clearPressed(): Unit = {}

  override def enterPressed(): Unit = {}

  override def checkoutPressed(): Unit = {}

  override def displayString(): String = {"cash or credit"}

  override def cashPressed(): Unit = {
    selfCheckout.state = new Default(selfCheckout)
    selfCheckout.numList = List()
    selfCheckout.cartItems = List()
  }

  override def creditPressed(): Unit = {
    selfCheckout.state = new Default(selfCheckout)
    selfCheckout.numList = List()
    selfCheckout.cartItems = List()
  }



}
