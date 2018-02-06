package org.code.legacy.refactored

import org.scalatest.FlatSpec

class MovieUnitTest extends FlatSpec {

  it should "return rental points given a new release movie with days rented greater than 1" in {
    val newRelease   = new Movie(null, MovieTypes.NEW_RELEASE)
    val rentalPoints = newRelease.rentalPoints(2)

    assert(rentalPoints == 2)
  }

  it should "return rental points given a new release movie with days rented equal to 1" in {
    val newRelease   = new Movie(null, MovieTypes.NEW_RELEASE)
    val rentalPoints = newRelease.rentalPoints(1)

    assert(rentalPoints == 1)
  }

  it should "return rental points given a regular movie" in {
    val newRelease   = new Movie(null, MovieTypes.REGULAR)
    val rentalPoints = newRelease.rentalPoints(1)

    assert(rentalPoints == 1)
  }

  it should "return rental points given a childrens movie" in {
    val newRelease   = new Movie(null, MovieTypes.CHILDRENS)
    val rentalPoints = newRelease.rentalPoints(1)

    assert(rentalPoints == 1)
  }

  it should "return rental amount given a regular movie with days rented greater than 2" in {
    val newRelease   = new Movie(null, MovieTypes.REGULAR)
    val rentalAmount = newRelease.rentalAmount(4)

    assert(rentalAmount == 5)
  }

  it should "return rental amount given a regular movie with days rented less than 2" in {
    val newRelease   = new Movie(null, MovieTypes.REGULAR)
    val rentalAmount = newRelease.rentalAmount(1)

    assert(rentalAmount == 2)
  }

  it should "return rental amount given a childrens movie with days rented greater than 3" in {
    val newRelease   = new Movie(null, MovieTypes.CHILDRENS)
    val rentalAmount = newRelease.rentalAmount(5)

    assert(rentalAmount == 4.5)
  }

  it should "return rental amount given a childrens movie with days rented less than 3" in {
    val newRelease   = new Movie(null, MovieTypes.CHILDRENS)
    val rentalAmount = newRelease.rentalAmount(2)

    assert(rentalAmount == 1.5)
  }

  it should "return rental amount given a new release movie" in {
    val newRelease   = new Movie(null, MovieTypes.NEW_RELEASE)
    val rentalAmount = newRelease.rentalAmount(3)

    assert(rentalAmount == 9)
  }
}
