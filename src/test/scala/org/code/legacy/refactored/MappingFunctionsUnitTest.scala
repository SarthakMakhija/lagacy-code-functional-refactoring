package org.code.legacy.refactored

import org.scalatest.FlatSpec

import scala.collection.mutable

class MappingFunctionsUnitTest extends FlatSpec {

  it should "return sum of a collection given a mapping function" in {
    val rentals: mutable.MutableList[Rental] = mutable.MutableList()

    val newRelease  = new Movie("padmavat",     MovieTypes.NEW_RELEASE)
    val children    = new Movie("angry-birds",  MovieTypes.CHILDRENS)

    rentals += new Rental(newRelease, 2)
    rentals += new Rental(children, 2)

    val sum = MappingFunctions.mappedSum(rentals)(rental => 2)
    assert(sum == 4)
  }

  it should "return string representation of a collection given a mapping function" in {
    val rentals: mutable.MutableList[Rental] = mutable.MutableList()

    val newRelease  = new Movie("padmavat",     MovieTypes.NEW_RELEASE)
    val children    = new Movie("angry-birds",  MovieTypes.CHILDRENS)

    rentals += new Rental(newRelease, 2)
    rentals += new Rental(children, 2)

    val repr = MappingFunctions.mapToString(rentals)(rental => "String representation\n")
    assert(repr == "String representation\nString representation\n")
  }

  it should "return a string with placeholders replaced" in {
    val input = "Hello %s, total amount %s"
    val formatted = MappingFunctions.mapUsingPlaceholders(input, Array("John", 100))

    assert(formatted == "Hello John, total amount 100")
  }

  it should "return a string with single placeholder replaced" in {
    val input = "Hello %s"
    val formatted = MappingFunctions.mapUsingPlaceholder(input, "John")

    assert(formatted == "Hello John")
  }
}
