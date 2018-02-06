package org.code.legacy.refactored

class Rental(private val movie: Movie, private val daysRented: Int) {

  def movieTitle:   String  = movie.title
  def rentalPoints: Int     = movie rentalPoints daysRented
  def rentalAmount: Double  = movie rentalAmount daysRented
}