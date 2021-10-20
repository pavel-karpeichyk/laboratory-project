package abstract_factory

import `interface`.ForcePlane
import `interface`.PassengerPlane
import `interface`.PlaneFactory
import `interface`.СargoPlane
import boeing.BoeingCargo
import boeing.BoeingForce
import boeing.BoeingPassenger

open class BoeingFactory(): PlaneFactory {

  override fun createСargoPlane(): СargoPlane {
    println("Boeing Cargo Plane created")
    return BoeingCargo()
  }

  override fun createForcePlane(): BoeingForce {
    println("Boeing Force Plane created")
    return BoeingForce()
  }

  override fun createPassengerPlane(): PassengerPlane {
    println("Boeing Passenger Plane created")
    return BoeingPassenger()
  }
}