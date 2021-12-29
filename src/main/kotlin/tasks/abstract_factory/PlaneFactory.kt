package tasks.abstract_factory

import tasks.abstract_factory.cargo_plane.СargoPlane
import tasks.abstract_factory.force_plane.ForcePlane
import tasks.abstract_factory.passenger_plane.PassengerPlane

interface PlaneFactory {
  fun createСargoPlane(): СargoPlane
  fun createForcePlane(): ForcePlane
  fun createPassengerPlane(): PassengerPlane
}