import java.text.SimpleDateFormat
import java.util.Date

class Time {

  var time: Date =_

  def this(_time: String){
    this()
    this.time = new SimpleDateFormat("hh:mm").parse(_time)
  }

  def addMinutes(minutes: Int): Unit ={
    this.time = new Date(time.getTime + (minutes * 60000))
  }

  def isRushHour: Boolean = {
    val nine =  variables.generateTime("09:00")
    val eleven =  variables.generateTime("11:00")
    val four =  variables.generateTime("16:00")
    val six =  variables.generateTime("18:00")
    between(nine, eleven) || between (four, six)
  }

  def between(begin: Time, end: Time): Boolean ={
    time.getTime >= begin.getTime && time.getTime <= end.getTime
  }

  def greaterThan(otherTime: Time): Boolean ={
    this.time.getTime > otherTime.time.getTime
  }

  def getTime: Long ={
    time.getTime
  }
}
