export const ArrayMultipleOf3Checker = () => {
    const array1 = [9, 4, 24];
    const array2 = [9, 24];

    const checkArray = (array) => {
        if (array.length % 3 === 0) {
            return 'The number of elements in the array is a multiple of 3';
        } else {
            return 'The number of elements in the array is not a multiple of 3';
        }
    };

    return (
        <div>
            <h3>Check if the number of elements is a multiple of 3:</h3>
            <p>{checkArray(array1)}</p>
            <p>{checkArray(array2)}</p>
        </div>
    );
};
