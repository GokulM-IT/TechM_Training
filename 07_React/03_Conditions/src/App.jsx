import FlowerChecker from "./FlowerChecker.jsx"
import { IfConditional } from "./IfConditional.jsx"
import { LogicalConditional } from "./LogicalConditional.jsx"
import { NumberDivisible } from "./NumberDivisible.jsx"
import { StringOddOrEven } from "./StringOddOrEven.jsx"
import { TernaryConditional } from "./TernaryConditional.jsx"
import { ArrayMultipleOf3Checker } from "./ArrayMultipleOf3Checker.jsx"
import VowelChecker from "./VowelChecker.jsx"


function App() {
  return <div>
    <IfConditional num={23} />
    <LogicalConditional friends={['ABCD', 'MDA', 'SP', 'ABR']} />
    <TernaryConditional />
    <NumberDivisible num={6} />
    <StringOddOrEven string={"hello"} />
    <FlowerChecker />
    <ArrayMultipleOf3Checker />
    <VowelChecker />
  </div>
}

export default App
