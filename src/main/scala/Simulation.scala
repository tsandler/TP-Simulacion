import java.text.SimpleDateFormat
import java.util.Date

import scala.util.Random

class Simulation {

  var question: Question =_

  val simulation: Simulation = new Simulation()
  var consumo = 0
  var capacidadJarra = 1500
  var VC = 45 //mins
  var IC: Int = 0
  var CDM = 3000
  var Q = 0
  var TPLLR, time, TPC, TPCM, TPJ = new Time("09:00")
  TPLLR.addMinutes(VC)

  def addQuestion(question: Question): Unit ={
    this.question = question
  }

  def execute: Unit ={
    simulation.addQuestion(
      new Question(less, TPCM.getTime, TPJ.getTime).accept(
        new Question(less, TPCM.getTime, TPLLR.getTime).accept(() => {
          time = TPC
          IC = generateIC(time)
          TPC.addMinutes(IC)
          consumo = new Random().nextInt(50) + 50
          new Question(higherOrEqual, consumo, CDM).accept(() => {
            CDM = 0
            Q += 1
          }).reject(() => CDM = CDM - consumo)
        }
        )
      ).reject(() => println("no"))
    )
  }


  def higherOrEqual(firstValue: Long, secondValue: Long): Boolean ={
    firstValue >= secondValue
  }

  def less(firstValue: Long, secondValue: Long): Boolean ={
    firstValue < secondValue
  }

  def generateIC(time: Time): Int ={
    if (time.isRushHour)
      return new Random().nextInt(15)
    new Random().nextInt(40)
  }
}
