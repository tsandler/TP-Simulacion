
object variables {
  var consumo: Int =_
  var VC = 0 //mins
  var IC: Int =_
  var CDM: Int =_
  var CDJ: Int =_
  var Q: Int =_
  var TPR, time, TPC, TPCM, TPCJ: Time =_
  var waste: Int =_

  def chargeCoffe: Unit ={
    CDM = 5000
    CDJ = 1500
  }

  def initialize: Unit ={
    TPR = new Time("09:00")
    time = new Time("09:00")
    TPC = new Time("09:00")
    TPCM = new Time("09:00")
    TPCJ = new Time("09:00")
    waste = 0
    IC = 0
    chargeCoffe
    consumo = 0
    Q = 0
    TPR.addMinutes(VC)
  }
  var changeDay = false
}
