package abstract_factory

import `interface`.ForcePlane
import `interface`.PassengerPlane
import `interface`.PlaneFactory
import `interface`.СargoPlane
import abstract_factory.airbus.AirbusCargo
import abstract_factory.airbus.AirbusForce
import abstract_factory.airbus.AirbusPassenger

class AirbusFactory() : PlaneFactory {
  override fun createСargoPlane(): СargoPlane {
    println("Airbus Cargo Plane created")
    return AirbusCargo()
  }

  override fun createForcePlane(): ForcePlane {
    println("Airbus Force Plane created")
    return AirbusForce()
  }

  override fun createPassengerPlane(): PassengerPlane {
    println("Airbus Passenger Plane created")
    return AirbusPassenger()
  }
}