package abstract_factory

import abstract_factory.cargo_plane.СargoPlane
import abstract_factory.force_plane.ForcePlane
import abstract_factory.passenger_plane.PassengerPlane

interface PlaneFactory {
 fun createСargoPlane(): СargoPlane
 fun createForcePlane(): ForcePlane
 fun createPassengerPlane(): PassengerPlane
}