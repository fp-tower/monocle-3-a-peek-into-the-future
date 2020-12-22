package monocle3

import java.time.YearMonth

case class User(name: String, address: Address, paymentMethods: Map[String, PaymentMethod])

case class Address(streetNumber: Int, postCode: String)

sealed trait PaymentMethod
case class DebitCard(cardNumber: String, expirationDate: YearMonth, securityCode: Int) extends PaymentMethod
case class PayPal(email: String) extends PaymentMethod

object PaymentMethod {
  def foo(e: YearMonth): YearMonth = e.plusYears(2)
}