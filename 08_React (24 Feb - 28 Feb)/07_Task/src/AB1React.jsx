import { AB4_React } from './components/AB4_React'
import React, { Suspense } from 'react';

// Below function should be default function not named function.
const ABComponent2 = React.lazy(() => import('./AB2_React'));
const ABComponent3 = React.lazy(() => import('./components/AB3_React'));

function AB1_React() {
    return (
        <div>
            <h1>Welcome to ReactApp with Vite and AB1_React!!!</h1>
            <Suspense fallback={<h1>Loading...</h1>}>
                <ABComponent2 />
                <ABComponent3 />
                <AB4_React />
            </Suspense>
        </div>
    );
}

export default AB1_React;