
export function IfConditional(props) {
    function EvenNumber() {
        return <h1>Even Number!</h1>;
    }

    function OddNumber() {
        return <h1>Odd Number!</h1>;
    }

    const isNum = props.num;
    if (isNum % 2 == 0) {
        return <EvenNumber />;
    }
    return <OddNumber />;
}