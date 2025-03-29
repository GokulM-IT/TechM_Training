const FlowerChecker = () => {
    const flowers = ['Rose', 'Jasmine', 'Lotus'];
    const flowerName = "Rose";

    const checkIfFlower = (name) => {
        if (flowers.includes(name)) {
            return `${name} is a flower.`;
        } else {
            return `${name} is not a flower.`;
        }
    };

    return (
        <div>
            <h3>Check if the given string is a flower:</h3>
            <p>{checkIfFlower(flowerName)}</p>
        </div>
    );
};

export default FlowerChecker;
