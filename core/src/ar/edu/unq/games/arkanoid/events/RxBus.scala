package ar.edu.unq.games.arkanoid.events

import rx.lang.scala.subjects.{PublishSubject, SerializedSubject}
import rx.lang.scala.{Observable, Subject}

object RxBus {
  val _bus:Subject[RxEvent] = SerializedSubject[RxEvent](PublishSubject())
  def send(o:RxEvent) = _bus.onNext(o)
  def toObservable:Observable[RxEvent] = _bus
}
