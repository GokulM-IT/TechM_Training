export function NumberComponent({ num }) {
    function EvenNumber() {
        return <h1>EvenNumber!</h1>;
    }

    function OddNumber() {
        return <h1>OddNumber!</h1>;
    }

    let isEven = (num % 2 == 0);
    switch (isEven) {
        case true:
            return <EvenNumber />;
        // return <h1>Even Number!</h1>;
        case false:
            return <OddNumber />;
        //return <h1>Odd Number!</h1>;
    }
}