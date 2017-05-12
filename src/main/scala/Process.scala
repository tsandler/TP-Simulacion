import scala.util.Random

class Process {

  var TPC: Time =_

  def consume(machine: Boolean): Unit ={
    TPC = variables.TPCJ
    if (machine)
      TPC = variables.TPCM

    new Question(higherOrder.less, TPC.getTime, variables.TPR.getTime)
      .accept(() => this.drink(machine))
      .reject(() => this.recharge)
  }

  def drink(machine: Boolean): Unit ={
    var available = 0
    if (machine) {
      available = variables.CDM
      variables.TPCM.addMinutes(generateIC(TPC))
    }else{
      available = variables.CDJ
      variables.TPCJ.addMinutes(generateIC(TPC))
    }
    variables.consume = new Random().nextInt(50) + 50

    new Question(higherOrder.higherOrEqual, available, variables.consume)
      .accept(() => variables.consume(machine))
      .reject(() => variables.cantConsume)

    variables.verifyDateChange
  }

  def generateIC(time: Time): Int ={
    if (time.isRushHour)
      return new Random().nextInt(7)
    new Random().nextInt(30) + 10
  }

  def recharge: Unit ={
    variables.time = variables.TPR
    variables.waste += variables.CDM + variables.CDJ
    variables.TPR.addMinutes(variables.VC)
    variables.chargeCoffe
  }
}
