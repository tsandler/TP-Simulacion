
object variables {
  var consume: Int =_
  var VC = 0 //mins
  var CDM: Int =_
  var CDJ: Int =_
  var Q: Int =_
  var TPR, time, TPCM, TPCJ: Time =_
  var waste: Int =_

  def chargeCoffe: Unit ={
    CDM = 5000
    CDJ = 1500
  }

  def initialize: Unit ={
    TPR = this.generateTime("09:00")
    TPCM = this.generateTime("09:00")
    TPCJ = this.generateTime("09:00")
    waste = 0
    chargeCoffe
    consume = 0
    Q = 0
    TPR.addMinutes(VC)
  }
  var changeDay = false

  def consume(machine: Boolean): Unit ={
    if (machine)
      CDM -= consume
    else
      CDJ -= consume
  }

  def cantConsume: Unit ={
    Q += 1
  }

  def verifyDateChange: Unit ={
    val finalTime = this.generateTime("18:00")
    if (variables.TPCJ.getTime > finalTime.getTime && variables.TPCM.getTime > finalTime.getTime) {
      variables.TPCJ = this.generateTime("09:00")
      variables.TPCM = this.generateTime("09:00")
      variables.TPR = this.generateTime("09:00")
      variables.changeDay = true
    }
  }

  def generateTime(time: String): Time ={
    new Time(time)
  }
}
