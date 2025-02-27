export function TernaryConditional(props) {
    function EvenNumber() {
        return <h1>Even Number!</h1>;
    }

    function OddNumber() {
        return <h1>Odd Number!</h1>;
    }

    const isNum = props.num;
    return <>{isNum % 2 == 0 ? <EvenNumber /> : <OddNumber />}</>;
}