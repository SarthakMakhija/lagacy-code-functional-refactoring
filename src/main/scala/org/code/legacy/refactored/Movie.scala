package org.code.legacy.refactored

import org.code.legacy.refactored.MovieTypes.NEW_RELEASE

class Movie(val title: String, private val priceCode: Int) {

  def rentalPoints(daysRented: Int): Int    = if (priceCode == NEW_RELEASE && daysRented > 1) 2 else 1
  def rentalAmount(daysRented: Int): Double = MoviePriceFactory.movieAmountStrategy(priceCode)(daysRented)
}

object MovieTypes {
  val REGULAR     = 0
  val NEW_RELEASE = 1
  val CHILDRENS   = 2
}

object MoviePriceFactory {

  private val amountCalculationStrategies = Map[Int, (Int) => Double](MovieTypes.REGULAR      -> regularMovieAmount,
                                                                      MovieTypes.CHILDRENS    -> childrenMovieAmount,
                                                                      MovieTypes.NEW_RELEASE  -> newReleaseMovieAmount
                                                                     )

  def movieAmountStrategy(priceCode: Int)                    = amountCalculationStrategies(priceCode)

  private def regularMovieAmount   (daysRented: Int): Double = if (daysRented > 2) 2   + (daysRented - 2) * 1.5 else 2
  private def childrenMovieAmount  (daysRented: Int): Double = if (daysRented > 3) 1.5 + (daysRented - 3) * 1.5 else 1.5
  private def newReleaseMovieAmount(daysRented: Int): Double = daysRented * 3
}