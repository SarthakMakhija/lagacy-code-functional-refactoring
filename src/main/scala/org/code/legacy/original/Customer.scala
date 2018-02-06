package org.code.legacy.original

import scala.collection.mutable

class Customer(name: String) {

  private val rentals: mutable.MutableList[Rental] = mutable.MutableList()

  def addRental(arg: Rental) {
    rentals += arg
  }

  def statement(): String = {
    var totalAmount: Double       = 0
    var frequentRenterPoints: Int = 0
    var result = "Rental Record for " + name + "\n"

    for {
      rental <- rentals
    } {
      var thisAmount: Double = 0
      rental.movie.priceCode match {
        case MovieTypes.REGULAR =>
          thisAmount = thisAmount + 2
          if (rental.daysRented > 2)
            thisAmount += (rental.daysRented - 2) * 1.5

        case MovieTypes.NEW_RELEASE =>
          thisAmount = thisAmount + rental.daysRented * 3

        case MovieTypes.CHILDRENS =>
          thisAmount = thisAmount + 1.5
          if (rental.daysRented > 3)
            thisAmount += (rental.daysRented - 3) * 1.5
      }

      frequentRenterPoints = frequentRenterPoints + 1
      if (rental.movie.priceCode == MovieTypes.NEW_RELEASE && rental.daysRented > 1)
        frequentRenterPoints = frequentRenterPoints + 1

      result += "\t" + rental.movie.title + "\t" + String.valueOf(thisAmount) + "\n"
      totalAmount += thisAmount
    }

    //add footer lines result
    result += "Amount owed is " + String.valueOf(totalAmount) + "\n"
    result += "You earned " + String.valueOf(frequentRenterPoints) + " frequent renter points"

    result
  }
}