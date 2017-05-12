import scala.util.Random

class Process {

  var TPC: Time =_

  def consume(machine: Boolean): Unit ={
    TPC = variables.TPCJ
    if (machine)
      TPC = variables.TPCM

    new Question(higherOrder.less, TPC.getTime, variables.TPR.getTime)
      .accept(() => {this.drink(machine)})
      .reject(() => {this.recharge})
  }

  def drink(machine: Boolean): Unit ={
    var consume = variables.CDJ
    if (machine)
      consume = variables.CDM
    if (machine)
      variables.TPCM.addMinutes(generateIC(TPC))
    else
      variables.TPCJ.addMinutes(generateIC(TPC))
    variables.consumo = new Random().nextInt(50) + 50

    new Question(higherOrder.higherOrEqual, variables.consumo, consume).accept(() => {
      if (machine)
        variables.CDM = 0
      else
        variables.CDJ = 0
      variables.Q += 1
    }).reject(() => {
      if (machine)
        variables.CDM -= variables.consumo
      else
        variables.CDJ -= variables.consumo
    })

    var finalTime = new Time("18:00")
    if (variables.TPCJ.getTime > finalTime.getTime && variables.TPCM.getTime > finalTime.getTime) {
      variables.TPCJ = new Time("09:00")
      variables.TPCM = new Time("09:00")
      variables.changeDay = true
    }
  }
  def generateIC(time: Time): Int ={
    if (time.isRushHour)
      return new Random().nextInt(15)
    new Random().nextInt(40) + 10
  }

  def recharge: Unit ={
    variables.time = variables.TPR
    variables.waste += variables.CDM + variables.CDJ
    variables.TPR.addMinutes(variables.VC)
    variables.chargeCoffe
  }
}
