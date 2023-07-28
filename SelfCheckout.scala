package store.model.checkout

import store.model.items.Item
import store.model.items.Sale
import store.model.items.SalesTax
import store.model.items.BottleDeposit

class SelfCheckout {

  var state: CheckoutState = new Default(this)
  var numList: List[Int] = List()
  var storeItems: Map[String, Item] = Map()
  var cartItems: List[Item] = List()

  def addItemToStore(barcode: String, item: Item): Unit = {
    this.storeItems = this.storeItems + (barcode -> item)
  }

  def numberPressed(number: Int): Unit = {
    this.state.numberPressed(number)
  }
  def clearPressed(): Unit = {
    this.state.clearPressed()
  }
  def enterPressed(): Unit = {
    this.state.enterPressed()
  }

  def checkoutPressed(): Unit = {
    this.state.checkoutPressed()
  }

  def cashPressed(): Unit = {
    this.state.cashPressed()
  }

  def creditPressed(): Unit = {
    this.state.cashPressed()
  }

  def loyaltyCardPressed(): Unit = {
    // TODO
  }

  def displayString(): String = {
    this.state.displayString()
  }

  def itemsInCart(): List[Item] = {
    this.cartItems
  }

  def subtotal(): Double = {
    var totalPrice: Double = 0.0
    for (item <- cartItems){
      totalPrice += item.price()
    }
    totalPrice
  }

  def tax(): Double = {
    var totalTax: Double = 0.0
    for (item <- cartItems) {
      totalTax += item.tax()
    }
    totalTax
  }

  def total(): Double = {
    tax() + subtotal()
  }

  def prepareStore(): Unit = {
    // Similar to openMap in the Pale Blue Dot assignment, this method is not required and is
    // meant to help you run manual tests.
    //
    // This method is called by the GUI during setup. Use this method to prepare your
    // items and call addItemToStore to add their barcodes. Also add any sales/tax/etc to your
    // items.
    //
    // This method will not be called during testing and you should not call it in your tests.
    // Each test must setup its own items to ensure compatibility in AutoLab. However, you can
    // write a similar method in your Test Suite classes.
    val testItem1 = new Item("item1", 10.0)
    val testItem2 = new Item("item2", 20.0)

    testItem1.addModifier(new Sale(20.0))
    testItem1.addModifier(new SalesTax(8.0))

    testItem2.addModifier(new Sale(20.0))
    testItem2.addModifier(new SalesTax(8.0))

    addItemToStore("123", testItem1)
    addItemToStore("321", testItem2)
  }

}
