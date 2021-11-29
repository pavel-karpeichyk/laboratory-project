package tasks.abstract_factory

import tasks.abstract_factory.cargo_plane.AirbusCargo
import tasks.abstract_factory.cargo_plane.СargoPlane
import tasks.abstract_factory.force_plane.AirbusForce
import tasks.abstract_factory.force_plane.ForcePlane
import tasks.abstract_factory.passenger_plane.AirbusPassenger
import tasks.abstract_factory.passenger_plane.PassengerPlane

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