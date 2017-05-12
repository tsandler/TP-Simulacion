import java.text.SimpleDateFormat
import java.util.Date

import scala.util.Random

class Simulation {

  var question: Question =_

  def execute: Unit = {
    while (variables.VC < 600){
      variables.initialize
      var day = 0
      variables.VC += 60
      while (day < 730) {
        new Question(higherOrder.less, variables.TPCM.getTime, variables.TPCJ.getTime)
          .accept(new Process().consume(true))
          .reject(new Process().consume(false))
        if (variables.changeDay) {
          day += 1
          variables.changeDay = false
        }
      }
      println("Tiempo entre llegada del repositor: " + variables.VC + " minutos")
      println("Desperdicio por dia: " + variables.waste / day + " ml de café")
      println("Cantidad de gente que no pudo consumir: " + variables.Q / day)
      println()
    }
  }
}
