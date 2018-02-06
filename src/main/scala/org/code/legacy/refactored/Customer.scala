package org.code.legacy.refactored

import org.code.legacy.refactored.MappingFunctions.{mapToString, mapUsingPlaceholder, mapUsingPlaceholders, mappedSum}

import scala.collection.mutable

class Customer(customerName: String) {

  private val rentals: mutable.MutableList[Rental] = mutable.MutableList()

  def addRental(arg: Rental) {
    rentals += arg
  }

  def textStatement       = textHeader + textBody + textFooter
  def htmlStatement       = htmlHeader + htmlBody + htmlFooter

  private def textHeader  = mapUsingPlaceholder("Rental Record for %s\n", customerName)
  private def textBody    = mapToString[Rental](rentals) { (rental) =>  s"\t${rental.movieTitle}\t${rental.rentalAmount}\n"}
  private def textFooter  = mapUsingPlaceholders("Amount owed is %s\nYou earned %s frequent renter points", Array(totalRentalAmount, totalFrequentRentalPoints))

  private def htmlHeader  = mapUsingPlaceholder("<h1>Rental Record for %s</h1><br/>", customerName)
  private def htmlBody    = mapToString[Rental](rentals) { (rental) => s"\t${rental.movieTitle}\t${rental.rentalAmount}<br/>"}
  private def htmlFooter  = mapUsingPlaceholders("Amount owed is <b>%s</b><br/>You earned <b>%s</b> frequent renter points", Array(totalRentalAmount, totalFrequentRentalPoints))

  private def totalRentalAmount         = mappedSum[Double, Rental](rentals)(_ rentalAmount)
  private def totalFrequentRentalPoints = mappedSum[Int,    Rental](rentals)(_ rentalPoints)
}