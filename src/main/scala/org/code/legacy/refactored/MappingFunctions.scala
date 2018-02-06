package org.code.legacy.refactored

import scala.collection.mutable

object MappingFunctions {

  def mappedSum[T: Numeric, R] (values: mutable.MutableList[R]) (mapFn: (R) => T): T = values map mapFn sum
  def mapToString[T]           (values: mutable.MutableList[T]) (fn: (T) => String)  = values map fn mkString
  def mapUsingPlaceholders     (str: String,  placeholders: Array[Any])              = str.format(placeholders: _*)
  def mapUsingPlaceholder      (str: String,  placeholder: Any)                      = mapUsingPlaceholders(str, Array(placeholder))
}