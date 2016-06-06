package com.chapter18

/**
  * Created by lgrcyanny on 16/5/27.
  */
class Simulation {
  type Action = () => Unit

  case class WorkItem(time: Int, action: Action)

  private var currTime = 0

  def currentTime = currTime

  private var agenda: List[WorkItem] = List()

  /**
    * Insure agenda time
    *
    * @param agenda
    * @param item
    * @return
    */
  def insert(agenda: List[WorkItem], item: WorkItem): List[WorkItem] = {
    if (agenda.isEmpty || item.time < agenda.head.time)
      item :: agenda
    else
      agenda.head :: insert(agenda.tail, item)
  }

  def afterDelay(delay: Int)(block: => Unit) = {
    val item = WorkItem(currentTime + delay, () => block)
    agenda = insert(agenda, item)
  }

  private def next() = {
    (agenda: @unchecked) match {
      case item :: rest =>
        agenda = rest
        currTime = item.time
        item.action()
    }
  }

  def run(): Unit = {
    afterDelay(0) {
      println(s"****Simulation started time $currentTime *******")
    }
    while (!agenda.isEmpty) next()
  }
}

abstract class BasicCircuitSimulation extends Simulation {
  def inverterDelay: Int

  def andGateDelay: Int

  def orGateDelay: Int

  class Wire {
    private var sigVal = false
    private var actions: List[Action] = List()

    def signal = sigVal

    def setSignal(s: Boolean) = {
      if (s != sigVal) {
        sigVal = s
        actions.foreach(_ ())
      }
    }

    def addAction(action: Action) = {
      actions = action :: actions
      action()
    }
  }

  def inverter(input: Wire, output: Wire) = {
    def invertAction() = {
      val inputSig = input.signal
      afterDelay(inverterDelay) {
        output setSignal !inputSig
      }
    }
    input addAction invertAction
  }

  def andGate(a1: Wire, a2: Wire, output: Wire) = {
    def andAction() = {
      val a1Sig = a1.signal
      val a2Sig = a2.signal
      afterDelay(andGateDelay) {
        output setSignal (a1Sig & a2Sig)
      }
    }
    a1 addAction andAction
    a2 addAction andAction
  }

  def orGate(a1: Wire, a2: Wire, output: Wire) = {
    def andAction() = {
      val a1Sig = a1.signal
      val a2Sig = a2.signal
      afterDelay(andGateDelay) {
        output setSignal (a1Sig | a2Sig)
      }
    }
    a1 addAction andAction
    a2 addAction andAction
  }

  def probe(name: String, wire: Wire) {
    def probeAction() {
      println(name + " " + currentTime +
        " new-value = " + wire.signal)
    }
    wire addAction probeAction
  }
}

abstract class CircuitSimulation
  extends BasicCircuitSimulation {
  def halfAdder(a: Wire, b: Wire, s: Wire, c: Wire) {
    val d, e = new Wire
    orGate(a, b, d)
    andGate(a, b, c)
    inverter(c, e)
    andGate(d, e, s)
  }

  def fullAdder(a: Wire, b: Wire, cin: Wire,
                sum: Wire, cout: Wire) {
    val s, c1, c2 = new Wire
    halfAdder(a, cin, s, c1)
    halfAdder(b, s, sum, c2)
    orGate(c1, c2, cout)
  }
}

object SimulationTest extends CircuitSimulation {
  def inverterDelay: Int = 1
  def andGateDelay: Int = 3
  def orGateDelay: Int = 5

  def main(args: Array[String]) {
    val input1, input2, sum, carry = new Wire
    probe("input1", input1)
    probe("input2", input2)
    probe("sum", sum)
    probe("carry", carry)
    val output = halfAdder(input1, input2, sum, carry)
    input1.setSignal(true)
    run()
    input2.setSignal(false)
    run()
  }
}
