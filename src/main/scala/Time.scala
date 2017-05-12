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
    var nine =  new Time("09:00")
    var eleven =  new Time("11:00")
    var four =  new Time("16:00")
    var six =  new Time("18:00")
    between(nine, eleven) || between (four, six)
  }

  def between(begin: Time, end: Time): Boolean ={
    time.after(begin.time) && time.before(end.time)
  }

  def greaterThan(otherTime: Time): Boolean ={
    this.time.getTime > otherTime.time.getTime
  }

  def getTime: Long ={
    time.getTime
  }
}
