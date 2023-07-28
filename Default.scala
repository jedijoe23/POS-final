package store.model.checkout

import store.model.items.Item

class Default (val selfCheckout: SelfCheckout) extends CheckoutState(selfCheckout) {

  override def numberPressed(number: Int): Unit = {
    selfCheckout.numList = selfCheckout.numList :+ number
    selfCheckout.state = new Default(selfCheckout)
  }

  override def clearPressed(): Unit = {
    selfCheckout.numList = List()
    selfCheckout.state = new Default(selfCheckout)
  }

  override def enterPressed(): Unit = {
    val item = selfCheckout.storeItems.getOrElse(selfCheckout.displayString(), new Item("error", 0.0))
    selfCheckout.cartItems = selfCheckout.cartItems :+ item
    this.selfCheckout.state = new EnterState(this.selfCheckout, selfCheckout.displayString())
    selfCheckout.numList = List()
  }

  override def checkoutPressed(): Unit = {
    selfCheckout.state = new CheckoutPressedState(selfCheckout)
  }

  override def cashPressed(): Unit = {}

  override def creditPressed(): Unit = {}

  override def displayString(): String = {
    var display = ""
    for (num <- selfCheckout.numList) {
      display = display + num.toString
    }
    display
  }
}

