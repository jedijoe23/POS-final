package store.model.checkout

import store.model.items.Item
import store.model.items.Sale
import store.model.items.SalesTax
import store.model.items.BottleDeposit

abstract class CheckoutState(val checkout: SelfCheckout){
  def addItemToStore(): Unit = {}
  def numberPressed(number: Int): Unit = {}
  def clearPressed(): Unit = {}
  def enterPressed(): Unit = {}
  def checkoutPressed(): Unit = {}
  def cashPressed(): Unit = {}
  def creditPressed(): Unit = {}
  def loyaltyCardPressed(): Unit = {}
  def displayString(): String = {""}
  def itemsInCart(): Unit = {}
  def subtotal(): Unit = {}
  def tax(): Unit = {}
  def total(): Unit = {}
  def prepareStore(): Unit = {}
}
