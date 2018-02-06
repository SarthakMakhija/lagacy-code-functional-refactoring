package org.code.legacy.model.refactored

import org.code.legacy.refactored.{Customer, Movie, MovieTypes, Rental}
import org.scalatest.FlatSpec

class CustomerTest extends FlatSpec {

  it should "return customer text statement given all rentals" in {
    val expectedStatement = "Rental Record for john\n\tpadmavat\t6.0\n\tdabang\t3.5\n\tangry-birds\t3.0\nAmount owed is 12.5\nYou earned 4 frequent renter points"
    val john              = new Customer("john")

    val newRelease  = new Movie("padmavat",     MovieTypes.NEW_RELEASE)
    val children    = new Movie("angry-birds",  MovieTypes.CHILDRENS)
    val regular     = new Movie("dabang",       MovieTypes.REGULAR)

    john.addRental(new Rental(newRelease, 2))
    john.addRental(new Rental(regular,    3))
    john.addRental(new Rental(children,   4))

    val textStatement = john.textStatement
    assert(textStatement == expectedStatement)
  }

  it should "return customer html statement given all rentals" in {
    val expectedStatement = "<h1>Rental Record for john</h1><br/>\tpadmavat\t6.0<br/>\tdabang\t3.5<br/>\tangry-birds\t3.0<br/>Amount owed is <b>12.5</b><br/>You earned <b>4</b> frequent renter points"
    val john              = new Customer("john")

    val newRelease  = new Movie("padmavat",     MovieTypes.NEW_RELEASE)
    val children    = new Movie("angry-birds",  MovieTypes.CHILDRENS)
    val regular     = new Movie("dabang",       MovieTypes.REGULAR)

    john.addRental(new Rental(newRelease, 2))
    john.addRental(new Rental(regular,    3))
    john.addRental(new Rental(children,   4))

    val htmlStatement = john.htmlStatement
    assert(htmlStatement == expectedStatement)
  }
}