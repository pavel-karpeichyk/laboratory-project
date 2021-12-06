package tasks.abstract_factory

import tasks.abstract_factory.passenger_plane.PassengerPlane
import tasks.abstract_factory.cargo_plane.СargoPlane
import tasks.abstract_factory.cargo_plane.BoeingCargo
import tasks.abstract_factory.force_plane.BoeingForce
import tasks.abstract_factory.passenger_plane.BoeingPassenger

class BoeingFactory(): PlaneFactory {

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