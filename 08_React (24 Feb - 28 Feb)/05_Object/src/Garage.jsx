import { Car } from "./Car.jsx"

export function Garage() {
    const cars = [
        { key: 1, brand: 'Ford' },
        { key: 2, brand: 'BMW' },
        { key: 3, brand: 'Audi' }
    ];
    return (
        <>
            <h1>Who lives in my garage?</h1>
            <ul>
                {cars.map(car => <Car key={car.key} brand={car.brand} />)}
            </ul>
        </>
    );
}