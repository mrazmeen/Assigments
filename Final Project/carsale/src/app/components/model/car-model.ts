import {CarFeature} from './car-feature';
import {CarPhotos} from './car-photos';

export class CarModel {
  constructor(public modelName: string,
              public type: string,
              public make: string,
              public mileage: string,
              public condition: string,
              public exteriorColor: string,
              public interiorColor: string,
              public interiorMaterial: string,
              public generalInformation: string,
              public overview: string,
              public price: number,
              public drivetrain: string,
              public engineType: string,
              public displacement: string,
              public horsepower: string,
              public torque: string,
              public SeatingCapacity: string,
              public brakeType: string,
              public transmission: string,
              public carPhotos: CarPhotos[]) {
  }
}
