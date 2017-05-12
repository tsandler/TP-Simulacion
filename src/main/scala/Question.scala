
class Question {

  var result: Boolean =_

  def this(function: (Long, Long) => Boolean, firstValue: Long, secondValue: Long){
    this()
    this.result = function(firstValue, secondValue)
  }

  def accept(action: () => Unit) ={
    if (result){
      action.apply()
    }
    this
  }

  def reject(action: () => Unit) ={
    if (!result){
      action.apply()
    }
    this
  }
}
