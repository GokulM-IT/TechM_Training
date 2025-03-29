import { AvailableCards } from "./AvailableCards.jsx"
import { NumberDivisible } from "./NumberDivisible.jsx"
import { StudentList } from "./StudentList.jsx"
import { ChildComponent } from "./ChildComponent.jsx"
import { ChildComponent2 } from "./ChildComponent2.jsx"
import { v4 as uuid } from 'uuid';
import AB1_React from "./AB1React.jsx"

function App() {
  return <div>
    <NumberDivisible num={33} />
    <AvailableCards />
    <StudentList />
    <ChildComponent key={uuid()} />
    <ChildComponent key={uuid()} />
    <ChildComponent key={uuid()} />
    <ChildComponent key={uuid()} />
    <ChildComponent2 />

    <AB1_React />
  </div>
}

export default App
