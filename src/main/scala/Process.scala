import scala.util.Random

class Process {


  def consume(machine: Boolean): Question ={
    new Question(higherOrder.less, variables.TPC.getTime, variables.TPR.getTime)
      .accept(() => {this.drink(machine)})
      .reject(() => {this.recharge})
  }

  def drink(machine: Boolean): Unit ={
    var consume = variables.CDJ
    if (machine)
      consume = variables.CDM
    variables.time = variables.TPC
    variables.IC = generateIC(variables.time)
    variables.TPC.addMinutes(variables.IC)
    variables.consumo = new Random().nextInt(50) + 50
    new Question(higherOrder.higherOrEqual, variables.consumo, variables.CDM).accept(() => {
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
    if (variables.TPC.getTime > new Time("18:00").getTime) {
      variables.TPC = new Time("09:00")
      variables.changeDay = true
    }
    if (machine)
      variables.TPCM = variables.TPC
    else
      variables TPCJ = variables.TPC
  }
  def generateIC(time: Time): Int ={
    if (time.isRushHour)
      return new Random().nextInt(5)
    new Random().nextInt(20) + 10
  }

  def recharge: Unit ={
    variables.time = variables.TPR
    variables.waste += variables.CDM + variables.CDJ
    variables.TPR.addMinutes(variables.VC)
    variables.chargeCoffe
  }
}
