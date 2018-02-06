package org.code.legacy.refactored

import org.scalatest.FlatSpec

class RentalUnitTest extends FlatSpec {

  it should "return movie title" in {
    val rental      = new Rental(new Movie("Dangal", MovieTypes.CHILDRENS), 0)
    val movieTitle  = rental.movieTitle

    assert(movieTitle == "Dangal")
  }

  it should "return movie rental points given a regular movie" in {
    val rental       = new Rental(new Movie("Dangal", MovieTypes.REGULAR), 1)
    val rentalPoints = rental.rentalPoints

    assert(rentalPoints == 1)
  }

  it should "return movie rental amount given a regular movie with days rented greater than 2" in {
    val rental       = new Rental(new Movie("Dangal", MovieTypes.REGULAR), 5)
    val rentalAmount = rental.rentalAmount

    assert(rentalAmount == 6.5)
  }
}
