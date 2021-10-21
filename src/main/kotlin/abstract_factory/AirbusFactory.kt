package abstract_factory

import abstract_factory.cargo_plane.AirbusCargo
import abstract_factory.cargo_plane.СargoPlane
import abstract_factory.force_plane.AirbusForce
import abstract_factory.force_plane.ForcePlane
import abstract_factory.passenger_plane.AirbusPassenger
import abstract_factory.passenger_plane.PassengerPlane

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