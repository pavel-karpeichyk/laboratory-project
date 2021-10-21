package abstract_factory

import abstract_factory.passenger_plane.PassengerPlane
import abstract_factory.PlaneFactory
import abstract_factory.cargo_plane.СargoPlane
import abstract_factory.cargo_plane.BoeingCargo
import abstract_factory.force_plane.BoeingForce
import abstract_factory.passenger_plane.BoeingPassenger

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