
class Question {

  var function: (Long, Long) => Boolean =_
  var firstValue: Long =_
  var secondValue: Long =_

  def this(_function: (Long, Long) => Boolean, _firstValue: Long, _secondValue: Long){
    this()
    this.function = _function
    this.firstValue = _firstValue
    this.secondValue = _secondValue
  }

  def accept(action: () => Unit) ={
    if (acceptValue){
      action.apply()
    }
    this
  }

  def accept(question: Question) ={
    this
  }

  def reject(action: () => Unit) ={
    if (!acceptValue){
      action.apply()
    }
    this
  }

  def reject(question: Question) ={
    this
  }

  def acceptValue = function(firstValue, secondValue)
}
