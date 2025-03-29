// Closure
function parent() {
    let count = 0;
    return function() {
        count++;
        console.log(count);
    }
}

const child = parent();
child()
child()
child()
child()
child()
child()